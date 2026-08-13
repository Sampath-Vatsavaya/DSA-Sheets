package arrays.medium;

import arrays.ArrayProblem;
import arrays.Run;

import java.util.Arrays;

/*
* Next Permutation
* Link: https://leetcode.com/problems/next-permutation/description/
* A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible,
* the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a
* lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.
*
*
* */
@Run
public class NextPermutation implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Next Permutation";
    }


    // Function to find next permutation
    /*
    * We want to rearrange the array to form the next greater permutation.
    *  If that's not possible (i.e., it's the last permutation), we return the smallest one (i.e., sorted ascendingly).
To find this next permutation with minimal change, we need to find a digit that can be increased slightly
*  to make the number bigger and then rearrange the remaining part to be the smallest possible.
Traverse from the end and find the first index where the current digit is smaller than the next one
* (this is the "breaking point").
Then again traverse from the end to find the first digit greater than the breaking point digit
*  and swap them.
Finally, reverse the part of the array to the right of the breaking point to get
*  the smallest next permutation.
If no such breaking point exists (entire array is descending), just reverse the whole array.
    *
    *
    * */
    public void nextPermutation(int[] nums) {
        // Set index to -1
        int index = -1;

        // Find the first decreasing element from end
        for (int i = nums.length - 2; i >= 0; i--) {
            // If smaller found
            if (nums[i] < nums[i + 1]) {
                // Store index
                index = i;
                break;
            }
        }

        // If no index found
        if (index == -1) {
            // Reverse the entire array
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // Find just larger element
        for (int i = nums.length - 1; i > index; i--) {
            // Swap them
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        // Reverse part after index
        reverse(nums, index + 1, nums.length - 1);
    }

    // Helper to reverse array
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    // Helper to swap
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public void solve() {
        int[] nums = {1, 2, 3};
        int[] nums1 = {3,2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
