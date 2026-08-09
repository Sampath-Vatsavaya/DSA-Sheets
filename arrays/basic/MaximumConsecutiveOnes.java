package arrays.basic;

import arrays.ArrayProblem;
import arrays.Run;

@Run
/*
*
* Count Maximum Consecutive One's in the array:
* Given a binary array nums, return the maximum number of consecutive 1's in the array.
* Link: https://leetcode.com/problems/max-consecutive-ones/description/
* */
public class MaximumConsecutiveOnes implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Max Consecutive Ones";
    }

    /*
    * We need to find the longest streak of consecutive 1’s in a binary array. A simple idea is to traverse the array while maintaining a counter. Every time we encounter a 1, we increase the counter. If we encounter a 0, the streak breaks, so we reset the counter to 0.
    *  At each step, we track the maximum streak length seen so far.
    Initialize two variables:
    cnt → counts the current streak of 1’s.
    maxi → stores the maximum streak found so far.
    Traverse through the array:
    If nums[i] == 1, increment cnt.
    If nums[i] == 0, reset cnt to 0.
    Update maxi = max(maxi, cnt) at each step.
    Finally, return maxi, which contains the length of the longest consecutive 1’s.
    *
    *
    * */

    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        // Variable to store maximum consecutive 1's
        int maxi = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            // If current element is 1, increment count
            if (nums[i] == 1) {
                cnt++;
            } else {
                // If element is 0, reset count
                cnt = 0;
            }

            // Update maximum if current count is greater
            maxi = Math.max(maxi, cnt);
        }

        // Return maximum consecutive 1's
        return maxi;
    }

    @Override
    public void solve() {

        int[]  nums1= {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums1));
    }
}
