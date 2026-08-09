package patterns;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
/****
****
****
****/
public class MainPrinter {


    static final int n =5;
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

      // regularScanner();

            callAllMethods();
            //executeLatestMethod();

        //scanner5();
    }
    public static void executeLatestMethod()
    {
        Method[] methods = KKPattern.class.getDeclaredMethods();

        for(Method method : methods)
        {
            if(method.isAnnotationPresent(LatestPattern.class))
            {
                try
                {
                    System.out.println("Executing---------"+method.getName());
                    method.invoke(null, 5);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void scanner5()
    {
        PatternPrinter.printRibbon(5);
    }

    public static  void  callAllMethods() throws InvocationTargetException, IllegalAccessException {
        Method[] methods = KKPattern.class.getDeclaredMethods();

        for(Method method: methods)
        {
            System.out.println("\n================================");
            System.out.println("Running: " + method.getName());
            System.out.println("================================");

            int paramCount = method.getParameterCount();
            // No arguments
            if(paramCount == 0)
            {
                method.invoke(null);
            }

            // One integer argument
            else if(paramCount == 1
                    && method.getParameterTypes()[0] == int.class)
            {
                method.invoke(null, 5);
            }

            else
            {
                System.out.println("Skipped (unsupported parameters)");
            }
        }
    }
    public static void regularScanner()
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int x=0;x<n;x++)
        {
            int f = scanner.nextInt();
            PatternPrinter.printDiamond(f);
        }
    }

}
