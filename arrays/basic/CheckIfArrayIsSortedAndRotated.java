package arrays.basic;

import arrays.ArrayProblem;
import arrays.Run;

/*
*
* Check if Array Is Sorted and Rotated
* Link: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
*Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
There may be duplicates in the original array.
Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length] for every valid index i.
*
*
*
* NeetCode ( Sliding Window Approach) : https://youtu.be/Vzs_vlCIFEw?si=zFCE1BRvzt50cMgJ
* Babbar (My Approach): https://youtu.be/Z7_nMTHROZo?si=jlsabnTUvTZuje47
*
*  */

public class CheckIfArrayIsSortedAndRotated implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Check if Array Is Sorted and Rotated";
    }

   /*Source Babbar
     Algorithm Check how many times a number is not greater than its previous number (Breaking the sorted condition)
     Note: since we need to form a cycle ( because the array was rotated) we also need to check the last and first element
    If count ==0 , it means the array is already sorted
    If count  == 1 , it means array was sorted and then rotated
    If count >1 , it is never a sorted array
    */
    public boolean check(int[] nums) {

        int count =0;
        int n = nums.length;
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]>nums[i+1])
            {
                count++;
            }
            if(count>1)
            {
                return false;
            }
        }
        if(nums[n-1]>nums[0])
        {
            count++;
        }

        return count<=1;



    }


    /*Leet Code Solution
    * https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/solutions/8287191/aot-beats-100-see-it-in-action-by-nandin-9b9d/
    * */
    public boolean checkArray(int[] nums) {
        int breaks = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            //The final check of Last Number and First Number is handled by %
            // Time: O(N)
            // Space: O(1)
            if (nums[i] > nums[(i + 1) % n]) {
                breaks++;
            }
        }

        return breaks <= 1;
    }


    /*
    * One more approach is to find the minimum element and then check every elemnet from min element in cyclic order
    * whether the array is sorted or not
    * */



    @Override
    public void solve() {

        int[] arr1 = {3,4,5,1,2};

        /*Output: true
        Explanation: [1,2,3,4,5] is the original sorted array.
        You can rotate the array by x = 2 positions to begin on the element of value 3: [3,4,5,1,2].
*/

        int[] arr2 = {2,1,3,4};
        /*
        * Output: false
          Explanation: There is no sorted array once rotated that can make nums.
        *
        * */
        int[] arr3={1,2,3};
        /*
        * Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.
        * */

        System.out.println(check(arr1));
        System.out.println(check(arr2));
        System.out.println(check(arr3));
    }
}
