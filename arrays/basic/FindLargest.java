package arrays.basic;

import arrays.ArrayProblem;
import arrays.Run;


/*
*
* Goal : Find the Largest Element in the Array:
* Created On: 09-08-2026
* Link: https://takeuforward.org/data-structure/find-the-largest-element-in-an-array
*
*
* */


public class FindLargest implements ArrayProblem {

    @Override
    public String getProblemTitle() {
        return "Find Largest Element in an Array";
    }



    /*
    * Brute Force would be sorting all the elements and then getting last element in the array
    * Complexity Analysis
     *   Time Complexity: O(N log N), where N is the size of the array, as we are sorting the array.
        * Space Complexity: O(1), as we are using a constant
    * */





    /*
    * Algorithm:
        Create a variable called max and initialize it with the value of the first element in the array.
        Use a for loop to iterate through the rest of the elements in the array.
        In each iteration, compare the current element with the max variable.
        If the current element is greater than the max value, update the max value with the current element's value.
        After completing the loop, print the max variable, which will hold the largest value in the array.
    *
    *Complexity Analysis
        Time Complexity: O(N), where N is the size of the array, as we are iterating through the array once.
        Space Complexity: O(1), as we are using a constant
    *
    * */
    // Function to find the largest element in the array
    public static int findLargestElement(int[] arr, int n) {
        int max = arr[0];  // Initialize max with the first element in the array

        // Iterate through the array to find the maximum element
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {  // If the current element is greater than max, update max
                max = arr[i];
            }
        }

        return max;  // Return the largest element found
    }


    public void findLargestElement (int[] arr)
    {
        int curr = arr[0];
        for ( int i:arr)
        {
            if (i > curr ) curr=i;
        }
        System.out.printf("Largest Element %d\n",curr);
    }

    @Override
    public void solve() {

        int[] arr1 = {2, 5, 1, 3, 0};
        int[] arr2 = {8, 10, 5, 7, 9};
        findLargestElement(arr1);
        findLargestElement(arr2);

        System.out.println(findLargestElement(arr1,arr1.length));
        System.out.println(findLargestElement(arr2,arr2.length));



    }
}