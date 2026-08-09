package arrays;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ArrayRunner {

    public static void main(String[] args) {

        List<Class<?>> classes = getClasses("arrays");

        Class<? extends ArrayProblem> latestProblem = null;
        long latestModifiedTime = Long.MIN_VALUE;

        for (Class<?> clazz : classes) {

            // Check whether the class implements ArrayProblem
            if (!ArrayProblem.class.isAssignableFrom(clazz)) {
                continue;
            }

            // Check whether the class has @Run
            if (!clazz.isAnnotationPresent(Run.class)) {
                continue;
            }

            try {

                URL location = clazz
                        .getProtectionDomain()
                        .getCodeSource()
                        .getLocation();

                File rootDirectory = new File(location.toURI());

                File classFile = new File(
                        rootDirectory,
                        clazz.getName()
                                .replace('.', File.separatorChar)
                                + ".class"
                );

                long modifiedTime = classFile.lastModified();

                System.out.println(
                        "Found @Run: "
                                + clazz.getName()
                                + " | Modified: "
                                + modifiedTime
                );

                // Keep the most recently modified class
                if (modifiedTime > latestModifiedTime) {

                    latestModifiedTime = modifiedTime;

                    latestProblem =
                            clazz.asSubclass(ArrayProblem.class);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // No problem found
        if (latestProblem == null) {

            System.out.println("No @Run ArrayProblem found.");

            return;
        }

        // Create and execute the latest problem
        try {

            ArrayProblem problem =
                    latestProblem
                            .getDeclaredConstructor()
                            .newInstance();

            System.out.println();
            System.out.println("========================================");
            System.out.println("Problem: " + problem.getProblemTitle());
            System.out.println("========================================");

            problem.solve();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Finds all classes inside the specified package
     * and all its subpackages.
     */
    private static List<Class<?>> getClasses(String packageName) {

        List<Class<?>> classes = new ArrayList<>();

        String path = packageName.replace('.', '/');

        try {

            ClassLoader classLoader =
                    Thread.currentThread()
                            .getContextClassLoader();

            URL resource =
                    classLoader.getResource(path);

            if (resource == null) {
                return classes;
            }

            File directory =
                    new File(resource.toURI());

            scanDirectory(
                    directory,
                    packageName,
                    classes
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return classes;
    }


    /**
     * Recursively scans directories for .class files.
     */
    private static void scanDirectory(
            File directory,
            String packageName,
            List<Class<?>> classes) {

        File[] files = directory.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {

            // If directory, scan its subpackage
            if (file.isDirectory()) {

                String subPackage =
                        packageName + "." + file.getName();

                scanDirectory(
                        file,
                        subPackage,
                        classes
                );

            }

            // If .class file, load the class
            else if (file.getName().endsWith(".class")) {

                String className =
                        packageName
                                + "."
                                + file.getName()
                                .substring(
                                        0,
                                        file.getName().length() - 6
                                );

                try {

                    Class<?> clazz =
                            Class.forName(className);

                    classes.add(clazz);

                } catch (ClassNotFoundException e) {

                    System.out.println(
                            "Could not load: "
                                    + className
                    );
                }
            }
        }
    }
}