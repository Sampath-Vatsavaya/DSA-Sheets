package arrays.medium;

import arrays.ArrayProblem;
import arrays.Run;

/*
*Print subarray with maximum subarray sum (extended version of above problem)
* Can you print the subarray that has the maximum sum?
* Link: https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array
*
* */

public class KadaneFollowUp implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Print subarray with maximum subarray sum";
    }



    /*My Approach*/
    public void printMaxSubArray(int[] nums)
    {
        int n=nums.length;
        int start =0 , end =0;
        int ansStart=-1;
        int ansEnd=-1;
        int sum =0;
        int maxSum =0;
        for(int i=0;i<n;i++)
        {


            sum+=nums[i];

            if(sum<=0)
            {
                sum=0;
                start = i+1;
            }
            if(sum > maxSum)
            {
                maxSum = sum;
                ansStart = start;
                ansEnd =i;
            }
        }
        for(int i=ansStart;i<=ansEnd;i++)
        {
            System.out.print(nums[i] +" ");
        }
    }


    /*
   * Start by iterating through the array using a variable i. During each iteration, add the current element arr[i] to a running sum variable.
       Initialize a start variable to keep track of the starting index of the current subarray.
       Use ansStart and ansEnd to store the starting and ending indices of the subarray with the maximum sum found so far. Initially, set both to -1.
       If the current sum is greater than the previous maximum sum, update ansStart to start and ansEnd to i.
       If the sum becomes negative at any point, reset it to 0 and set start to i + 1 to start a new subarray.
       After processing all elements, ansStart and ansEnd will point to the starting and ending indices of the subarray with the maximum sum.
       Return the subarray from arr[ansStart] to arr[ansEnd].
   *
   * */
    public int maxSubArrayStriver(int[] nums) {

        // Maximum sum
        long maxi = Long.MIN_VALUE;

        // Current sum of subarray
        long sum = 0;

        // Starting index of current subarray
        int start = 0;

        // Indices of the maximum sum subarray
        int ansStart = -1, ansEnd = -1;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {

            // Update starting index if sum is reset
            if (sum == 0) {
                start = i;
            }

            // Add current element to the sum
            sum += nums[i];

            // Update maxi and subarray indices if current sum is greater
            if (sum > maxi) {
                maxi = sum;
                ansStart = start;
                ansEnd = i;
            }

            // Reset sum to 0 if it becomes negative
            if (sum < 0) {
                sum = 0;
            }
        }

        // Printing the subarray
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("]");

        // Return the maximum subarray sum found
        return (int) maxi;
    }


    @Override
    public void solve() {

        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        printMaxSubArray(arr);
        System.out.println();
        maxSubArrayStriver(arr);

    }
}
