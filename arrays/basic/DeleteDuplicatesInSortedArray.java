package arrays.basic;

import arrays.ArrayProblem;
import arrays.Run;

import java.util.Arrays;

/*
* Remove Duplicates from Sorted Array
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
Consider the number of unique elements in nums to be k. After removing duplicates, return the number of unique elements k.
The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.
*
* Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
*
* */



public class DeleteDuplicatesInSortedArray implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Delete Duplicates In A Sorted Array";
    }


    /*
    * Instead of using a set to store the unique elements, we can implement a two pointer strategy to optimize the space. Since the array is sorted, we know that all the duplicate values will be adjacent to each other.
       Begin at the first position, which will always be part of the final unique list.
    Move through the list one item at a time, comparing the current item with the most recently kept unique item.
    If the current item is the same as the last kept one, skip it because it’s a duplicate.
    If it’s different, place it right after the last kept unique item to keep all unique values grouped at the front.
    Continue until every element in the list has been checked. The first part of the list now contains all the unique values in their original order, and the rest can be ignored.
    * */
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;

        // Pointer for last unique element
        int i = 0;

        // Start from second element
        for (int j = 1; j < nums.length; j++) {
            // If new unique element is found
            if (nums[j] != nums[i]) {
                // Move unique position forward
                i++;
                // Place new unique element
                nums[i] = nums[j];
            }
        }

        System.out.println(Arrays.toString(nums));
        // i is last index of unique element, count = i + 1
        return i + 1;


    }
    @Override
    public void solve() {

        /*Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).*/

        int[] nums1={1,1,2};
        int[] nums2={0,0,1,1,1,2,2,3,3,4};
        /*
    * Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
    *
    * */

        removeDuplicates(nums1);
        removeDuplicates(nums2);

    }
}
