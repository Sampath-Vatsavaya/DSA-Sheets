package arrays.hard;

import arrays.ArrayProblem;
import arrays.Run;

import java.util.Arrays;

/*
*
* Merge Sorted Array
* Link: https://leetcode.com/problems/merge-sorted-array/description/
* You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
* */

public class MergeSortedArray implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Merge Sorted Array";
    }

    public void mergeSimple(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++)
        {
            nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    /*
    *
    * We are given two sorted arrays nums1 and nums2 and nums1 has enough space at the end (filled with zeros) to accommodate all elements from nums2. Now, if we try to insert elements from nums2 into nums1 from the beginning, we would need to shift elements in nums1 every time to make room which becomes time consuming and inefficient.

Since both arrays are sorted in non-decreasing order, the largest elements will be at the end of each array. If we start comparing elements from the back of both arrays and place the largest one at the end of nums1, we won't need to shift anything.

To efficiently insert elements at the end, we will use three pointers.
Initialize three pointers: One points at the last valid index (excluding zeros) of nums1, one points at the last valid index of nums2 andd the last pointer points to last index of nums1.
Compare the elements pointed by the first two pointers and whichever is larger, place it at the third pointer's index.
Move the respective pointer one step back and also move the third pointer one step back.
If there are any remaining elements in nums2, then copy them in nums1. If any elements remain in nums1, they’re already in place
The result is a fully merged and sorted array stored in nums1 itself.
    *
    * */
    public int[] mergeOptimal(int[] nums1, int m, int[] nums2, int n) {

        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>=0 && j>=0)
        {
            if(nums1[i]>nums2[j])
            {
                nums1[k]=nums1[i];
                i--;

            }
            else{
                nums1[k]=nums2[j];
                j--;
            }
            k--;
        }
        while(j>=0)
        {
            nums1[k]=nums2[j];
            k--;
            j--;
        }

        return nums1;
    }

    @Override
    public void solve() {
        int[] nums1 = {1, 3, 5, 0, 0, 0};
        int[] nums2 = {2, 4, 6};
        int m = 3, n = 3;
        int[] nums11 = {1, 3, 5, 0, 0, 0};
        int[] nums12 = {2, 4, 6};
        int m1 = 3, n1 = 3;

        mergeSimple(nums1, m, nums2, n);
        mergeOptimal(nums11,m1,nums12,n1);
    }
}
