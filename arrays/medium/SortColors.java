package arrays.medium;

import arrays.ArrayProblem;
import arrays.Run;

import java.util.Arrays;

/*
    Sort Colors
    Link: https://leetcode.com/problems/sort-colors/description/
* Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.



Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
*
*
* */


@Run
public class SortColors implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Sort an array of 0s, 1s and 2s";
    }

    /*
    * Initialize three counters to zero: one each for 0s, 1s, and 2s.
Traverse the entire array and increment the respective counter based on the element value.
After counting, overwrite the array:
Place all 0s first (based on count of 0s).
Then all 1s (based on count of 1s).
Then all 2s (based on count of 2s).
    *
    * */
    public void countBasedSol(int[] nums)
    {
        // Count of 0s, 1s, and 2s
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        // First pass: Count the number of 0s, 1s, and 2s
        for (int num : nums) {
            if (num == 0) cnt0++;
            else if (num == 1) cnt1++;
            else cnt2++;
        }

        // Second pass: Fill the array with 0s, then 1s, then 2s

        // Fill the first 'cnt0' elements with 0
        for (int i = 0; i < cnt0; i++) {
            nums[i] = 0;
        }

        // Fill the next 'cnt1' elements with 1
        for (int i = cnt0; i < cnt0 + cnt1; i++) {
            nums[i] = 1;
        }

        // Fill the remaining elements with 2
        for (int i = cnt0 + cnt1; i < nums.length; i++) {
            nums[i] = 2;
        }
        System.out.println(Arrays.toString(nums));

    }

    /*
        This approach is a direct implementation of the Dutch National Flag algorithm.

We divide the array into three partitions using three pointers – low, mid, and high.
From 0 to low-1, we’ll keep only 0s
From low to mid-1, only 1s
From high+1 to n-1, only 2
The range from mid to high is the unsorted zone we’re scanning and fixing. At each step:
If arr[mid] == 0, it belongs to the left section → swap with low, move both low and mid.
If arr[mid] == 1, it’s already in the middle section → just move mid.
If arr[mid] == 2, it belongs to the right section → swap with high, only move high.
When you swap with high, you don’t move mid because the incoming value might still be 0 or 2 which needs processing.This ensures we sort the array in one single pass without using extra space.
Start with three pointers at the beginning, middle, and end of the array.
Iterate while the middle pointer is less than or equal to the end pointer.
If the current element belongs to the front section:
Swap it with the element at the front boundary.
Move both front and middle boundaries forward.
If the current element belongs to the middle section:
Move the middle boundary forward.
If the current element belongs to the end section:
Swap it with the element at the end boundary.
Move the end boundary backward.
Repeat until all elements are in their correct zones.
     */

    public void multiPointerSol(int[] nums) {
        // Initialize three pointers: low and mid at 0, high at the end
        int low = 0, mid = 0, high = nums.length - 1;

        // Continue processing until mid crosses high
        while (mid <= high) {
            // If current element is 0, swap with low and move both low and mid forward
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            // If current element is 1, just move mid forward
            else if (nums[mid] == 1) {
                mid++;
            }
            // If current element is 2, swap with high and move only high backward
            else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    @Override
    public void solve() {

        int[] arr1={1,2,0,1,0,2,1,2,0,1};
        countBasedSol(arr1);
        multiPointerSol(arr1);
    }
}
