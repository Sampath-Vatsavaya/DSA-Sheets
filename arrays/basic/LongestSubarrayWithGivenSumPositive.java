package arrays.basic;

import arrays.ArrayProblem;
import arrays.Run;

/*
* Longest Subarray with given Sum K(Positives)
* Problem Statement: Given an array nums of size n and an integer k,
* find the length of the longest sub-array that sums to k.
* If no such sub-array exists, return 0.
*Example 1:
Input:
 nums = [10, 5, 2, 7, 1, 9], k = 15
Output:
 4
Explanation:
 The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a length of 4. This sub-array starts at index 1 and ends at index 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the length of this sub-array is 4.

Example 2:
Input:
 nums = [-3, 2, 1], k = 6
Output:
 0
Explanation:
 There is no sub-array in the array that sums to 6. Therefore, the output is 0.
* */

@Run
public class LongestSubarrayWithGivenSumPositive implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Longest Subarray with given Sum K(Positives)";
    }

    /*
    * Algorithm — Longest Subarray with Given Sum K (Positive Numbers)
    Initialize:
    left = 0
    sum = 0
    maxLength = 0
    Traverse the array using right from 0 to n - 1.
    Add the current element to sum.
    If sum > k:
    Remove elements from the left of the window.
    Move left forward.
    Continue until sum <= k.
    If sum == k:
    Calculate the current window length:
    right - left + 1
    Update maxLength if the current length is larger.
    After traversing the entire array, return maxLength.
    *
    *
    * */

    public void getLongestSubArraySum(int[] nums,int k)
    {
        int startIndex=0;
        int endIndex=0;
        int n = nums.length;
        int sum =0;
        int max =0;
        while(endIndex<n)
        {
            sum += nums[endIndex];

            if(sum>k)
            {
                sum-=nums[startIndex];
                startIndex++;
            }
            if(sum==k)
            {
                max=Math.max((endIndex-startIndex)+1,max);
            }

            endIndex++;
        }
        System.out.println(max);
    }

    @Override
    public void solve() {
        int[] nums1={10,5,2,7,1,9};
        int[] nums2={-3,2,1};
        getLongestSubArraySum(nums1,15);
        getLongestSubArraySum(nums2,6);
    }
}
