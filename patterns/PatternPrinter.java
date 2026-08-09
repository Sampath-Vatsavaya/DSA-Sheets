package patterns;


//Sheet link - https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa?mode=track&sheet=a2z-dsa

public class PatternPrinter {
    public static void printStarSquare(int n) {


        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    public static void printLeftTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    public static void printNumericLeftTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d ", j);
            }
            System.out.println();
        }
    }

    public static void printEqualNumericLeftTriangle(int n)
    {
        for(int i=1;i<=n;i++)
        {
            for(int j =1;j<=i;j++)
            {
                System.out.printf("%d ",i);
            }
            System.out.println();
        }
    }

    public static void printDecreasingLeftTriangle(int n)
    {
        for(int i=n;i>0;i--)
        {
            for(int j =1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void printDecreasingLeftTriangleNumeric(int n)
    {
        for(int i=n;i>0;i--)
        {
            for(int j =1;j<=i;j++)
            {
                System.out.printf("%d ",j);
            }
            System.out.println();
        }
    }

    public static void printCentralTriangle(int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                System.out.print(" ");
            }
            for(int j=0;j<2*i+1;j++)
            {
                System.out.print("*");
            }
            for(int j=0;j<n-i-1;j++)
            {
                System.out.print(" ");
            }
            System.out.println();
        }

    }


    public static void printCentralDecreasingTriangle(int n)
    {
        for(int i=0;i<n;i++)
        {

            //Space
            for(int j= 0;j<i;j++)
            {
                System.out.print(" ");
            }

            for(int j=0;j<2*n -(2*i+1);j++)
            {
                System.out.print("*");
            }

            for(int j= 0;j<i;j++)
            {
                System.out.print(" ");
            }



            System.out.println();
        }

    }

    public static void printDiamond(int n)
    {
        PatternPrinter.printCentralTriangle(n);
        PatternPrinter.printCentralDecreasingTriangle(n);
    }

    public static void printHorizontalTriangle(int n)
    {
//        for(int i=0;i<n;i++)
//        {
//            for (int j =0;j<=i;j++)
//            {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//        for(int i = n-1;i>0;i--)
//        {
//            for (int j =i;j>0;j--)
//            {
//                System.out.print("*");
//            }
//            System.out.println();
//        }


        for(int i=1;i<=2*n-1;i++)
        {
            int stars = i;
            if(i> n) stars = 2*n-i;
            for(int j=1;j<=stars;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }


    }

    public static void printLeftBinaryTriangle(int n)
    {
//        for(int i=0;i<n;i++)
//        {
//            for(int j=0;j<=i;j++)
//            {
//                if ((i+j)%2==0)
//                {
//                    System.out.print(1);
//                }
//                else{
//                    System.out.print(0);
//                }
//
//            }
//            System.out.println();
//        }

        int start =1 ;
        for (int i=0;i<n;i++)
        {
            if(i%2==0) start =1;
            else start =0;

            for(int j=0;j<=i;j++)
            {
                System.out.print(start);
                start = 1 - start;
            }
            System.out.println();
        }
    }

    public static void printDoubleNumericTriangle(int n)
    {  int space = 2*(n-1);
        for(int i =1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print(j);
            }
            for (int j=0;j<space;j++)
            {
                System.out.print("-");
            }
            for(int j= i;j>0;j--)
            {
                System.out.print(j);
            }
            space-=2;
            System.out.println();
        }
    }

    public static void printLeftIncreasingNumericTriangle(int n) {
        int x =1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.printf("%d ",x++);

            }
            System.out.println();
        }
    }

    public static void printLeftCharacterTriangle(int n)
    {
        char startChar = 'A';
        for(int i=0;i<n;i++)
        {
            for (char x = 'A' ; x <= 'A'+i;x++)
            {
                System.out.print(x);
            }
            System.out.println();
        }
    }

    public static void printLeftDecreasingCharacterTriangle(int n)
    {
        char startChar = 'A';
        for(int i=0;i<n;i++)
        {
            for (char x = 'A' ; x <= 'A'+(n-i-1);x++)
            {
                System.out.print(x);
            }
            System.out.println();
        }
    }

    public static void printLeftIncreasingSameCharacterTriangle(int n)
    {
        char x ='A';
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print(x);
            }
            x++;
            System.out.println();
        }
    }

    public static void printCentralAlphabetTriangle(int n)
    {

        for(int i=0;i< n;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                System.out.print("-");
            }

            char start='A';
            int breakpoint = (2*i+1)/2;
            for(char j=1;j<=2*i+1;j++)
            {
                System.out.print(start);
                if (j<=breakpoint) start ++;

                else start--;
            }

            for(int j=0;j<n-i-1;j++)
            {
                System.out.print("-");
            }
            System.out.println();
        }

    }

    public static void printLeftIncreasingAlphabetDecreasingTriangle(int n)
    {
        char max= (char) ('A'+ n-1);
        for(int i=0;i<n;i++)
        {
            for(char j = (char) (max-i); j <=max; j++)
            {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void printInsideOpenDiamond(int n)
    {
        int spaces = 0;

        // Upper half
        for(int i = 0; i < n; i++)
        {
            // Left stars
            for(int j = 0; j < n - i; j++)
            {
                System.out.print("*");
            }

            // Middle spaces
            for(int j = 0; j < spaces; j++)
            {
                System.out.print(" ");
            }

            // Right stars
            for(int j = 0; j < n - i; j++)
            {
                System.out.print("*");
            }

            spaces += 2;

            System.out.println();
        }

        spaces = 2 * n - 2;

        // Lower half
        for(int i = 1; i <= n; i++)
        {
            // Left stars
            for(int j = 0; j < i; j++)
            {
                System.out.print("*");
            }

            // Middle spaces
            for(int j = 0; j < spaces; j++)
            {
                System.out.print(" ");
            }

            // Right stars
            for(int j = 0; j < i; j++)
            {
                System.out.print("*");
            }

            spaces -= 2;

            System.out.println();
        }
    }


    public static void printRibbon(int n)
    {
        int spaces =2*n -2;
        for(int i=1;i<=2*n-1;i++)
        {
            int stars = i;
            if(i>n) stars = 2*n-i;
            for(int j=1;j<=stars;j++)
            {
                System.out.print("*");
            }
            for(int j=1;j<=spaces;j++)
            {
                System.out.print("-");
            }
            for(int j=1;j<=stars;j++)
            {
                System.out.print("*");
            }

            if (i<n) spaces -=2;
            else spaces +=2;

            System.out.println();
        }
    }

    public static void printEmptyBox(int n)
    {
        for(int i=0;i<n;i++)
        {

            for(int j=0;j<n;j++)
            {
                if((i==0 || i== n-1) || (j==0 || j==n-1))
                {
                    System.out.print("* ");
                    continue;
                }
                System.out.print("  ");


            }
            System.out.println();
        }
    }

    @LatestPattern
    public static void printNumericBorderBox(int n)
    {


        for(int i=0;i<2*n-1;i++)
        {
            for(int j=0;j<2*n-1;j++)
            {
                int topDistance = i;
                int leftDistance =j;
                int bottomDistance = 2*n- 2 -i;
                int rightDistance = 2*n-2-j;

                int value = n - Math.min(Math.min(topDistance,bottomDistance),Math.min(leftDistance,rightDistance));
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
