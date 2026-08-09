package patterns;

public class KKPattern {

    public static void pattern1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void pattern2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }


    public static void pattern3(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = i; j >= 1; j--) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }


    public static void pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d", j);
            }
            System.out.println();
        }
    }


    public static void pattern5(int n) {
        for (int i = 1; i <= 2 * n - 1; i++) {
            int count = i;
            if (i > n) {
                count = 2 * n - i;
            }
            for (int j = 1; j <= count; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern6(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void pattern7(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= n - i - 1; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }


    public static void pattern8(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    public static void pattern9(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * n - 2 * i - 1; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    public static void pattern10(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    public static void pattern11(int n) {
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern12(int n) {
        for (int i = 0; i < 2 * n; i++) {
//            int starCount = n-i;
//            int spaceCount = i;
//
//            if(i >= n)
//            {
//                starCount = i-n+1;
//                spaceCount = 2*n -i -1;
//
//            }
            int spaceCount = i < n ? i : 2 * n - i - 1;

            int starCount = n - spaceCount;
            for (int j = 0; j < spaceCount; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < starCount; j++) {
                System.out.print("* ");
            }
            for (int j = 0; j < spaceCount; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    public static void pattern12SingleLoopVariant(int n) {
        int rows = 2 * n;
        int cols = 2 * n;

        for (int k = 0; k < rows * cols; k++) {
            int i = k / cols;
            int j = k % cols;

            int spaces = i < n ? i : 2 * n - i - 1;
            int stars = n - spaces;

            if (j < spaces) {
                System.out.print(" ");
            } else if (j < spaces + stars) {
                System.out.print("* ");
            }

            if (j == cols - 1) {
                System.out.println();
            }
        }
    }


    public static void pattern13(int n) {
        for (int i = 0; i < n; i++) {
            // spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // stars
            for (int j = 0; j < 2 * i + 1; j++) {
                // first row
                // first star
                // last star
                // last row
                if (i == 0 || i == n - 1 || j == 0 || j == 2 * i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }


    public static void pattern14(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * n - 2 * i - 1; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == 2 * n - 2 * i - 2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void pattern15(int n) {
        for (int i = 0; i < 2 * n - 1; i++) {
            int spaces = i < n
                    ? n - i - 1
                    : i - n + 1;

            int width = i >= n
                    ? 2 * (2 * n - i - 1) - 1
                    : 2 * i + 1;

            // left spaces
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }

            // hollow width
            for (int j = 0; j < width; j++) {
                if (j == 0 || j == width - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }
    }

    // Pascals triangle
    public static void pattern16(int n)
    {
        for(int i=0;i<n;i++)
        {
            int spaces = n-i;
            int width = 0;
            for(int j=0;j<n;j++)
            {
                System.out.print("");
            }
            System.out.println();
        }
    }




    public static void pattern21(int n)
    {
        int cnt =1;
        for(int i=0;i<n;i++)
        {

            for(int j=0;j<=i;j++)
            {
                System.out.printf("%d ",cnt++);
            }
            System.out.println();
        }
    }
    @LatestPattern
    public static void pattern26(int n)
    {
        n=6;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=(n-i)+1;j++)
            {
                System.out.print(i);
            }
            System.out.println();
        }
    }


























    public static void pattern31(int n) {

        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {

                int topDistance = i;
                int leftDistance = j;
                int bottomDistance = 2 * n - 2 - i;
                int rightDistance = 2 * n - 2 - j;

                int value = n - Math.min(Math.min(topDistance, bottomDistance), Math.min(leftDistance, rightDistance));
                System.out.print(value);

            }
            System.out.println();
        }
    }


    public static void pattern32(int n) {
        char lastChar = (char) ('A' + (n - 1));
        for (int i = 0; i < n; i++) {
            for (char j = (char) (lastChar - i); j <= lastChar; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }


    public static void pattern33(int n) {
//        int counter =0;
//        for(int i=1;i<=n;i++)
//        {
//            for(int j=1;j<=i;j++)
//            {
//                char val = (char) (counter%2==0 ? Character.toLowerCase('A'+counter) : 'A' + counter);
//
//                System.out.print(val);
//                counter++;
//            }
//            System.out.println();
//        }
        char ch = 'a';
        int count = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (count % 2 == 0) {
                    System.out.print(Character.toUpperCase(ch) + " ");
                } else {
                    System.out.print(Character.toLowerCase(ch) + " ");
                }

                ch++;
                count++;
            }

            System.out.println();
        }
    }


    public static void pattern34(int n) {

        for (int i = 0; i < n; i++) {
            char finalChar = (char) ('A' + n - i - 1);
            for (int j = 0; j < n - i; j++) {
                System.out.print(finalChar);
                finalChar--;
            }
            System.out.println();
        }
        char start = (char) ('A' + n - 1);

//        for(int i = 0; i < n; i++)
//        {
//            for(char ch = (char)(start - i); ch >= 'A'; ch--)
//            {
//                System.out.print(ch + " ");
//            }
//
//            System.out.println();
//        }
    }



    public static void pattern35(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }


}
