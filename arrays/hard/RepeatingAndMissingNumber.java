package arrays.hard;

import arrays.ArrayProblem;
import arrays.Run;

/*
*
* Find the repeating and missing numbers
Problem Statement: Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.
Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.
Note: You are not allowed to modify the original array.
Examples
Example 1:
Input:
 nums = [3, 5, 4, 1, 1]
Output:
 [1, 2]
Explanation:
 1 appears twice in the array, and 2 is missing from the array. So the output is [1, 2].
Example 2:
Input:
 nums = [1, 2, 3, 6, 7, 5, 7]
Output:
 [7, 4]
Explanation:
 7 appears twice in the array, and 4 is missing from the array. So the output is [7, 4].
* */
@Run
public class RepeatingAndMissingNumber implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Find the repeating and missing numbers";
    }

    private int[] findMissingRepeatingNumbers(int[] arr) {

        int[] ans = new int[2];
        int n = arr.length;
        int answer =0;
        int sum =0;
        // XOR all the elements with 0
        for (int i = 0; i < n; i++) {
            answer = answer ^ arr[i];
            sum+=arr[i];
        }

        // XOR all the elements with no from 1 to n
        // i.e   answer^0 = answer
        for (int i = 1; i <= n; i++) {
            answer = answer ^ i;
        }
        int expectedSum = n * (n + 1) / 2;
        System.out.println(expectedSum);
        System.out.println(sum);
        ans[1] = expectedSum - (sum-answer);
        ans[0] = answer;
        return ans;
    }

    @Override
    public void solve() {

        int[] nums = {3, 1, 2, 5, 4, 6, 7, 5};



        int[] result = findMissingRepeatingNumbers(nums);

        // Print the repeating and missing numbers found
        System.out.println("The repeating and missing numbers are: {"
                + result[0] + ", " + result[1] + "}");


    }


}
