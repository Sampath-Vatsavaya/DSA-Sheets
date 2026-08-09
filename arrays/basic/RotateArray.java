package arrays.basic;

import arrays.ArrayProblem;
import arrays.Run;

import java.util.Arrays;

/*
* Rotate An Array:
*
* Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
* Link: https://leetcode.com/problems/rotate-array/description/
*
* Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
*
* */
@Run
public class RotateArray implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Rotate An Array";
    }


    /*
    * Brute Force
    * */

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        for(int i=0;i<n;i++)
        {
            temp[(i+k)%n] = nums[(i)%n];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
        System.out.println(Arrays.toString(nums));
    }

    /*
    * Optimal Approach:
    * Approach 2: Optimized Reversal (Efficient)
    Normalize k → k % n.
    Reverse the entire array.
    Reverse the first k elements.
    Reverse the last n-k elements.
    Complexity
    Time Complexity: O(n) (each element reversed at most twice)
    Space Complexity: O(1)
    * */

    public void rotateOptimised(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        Reverse(nums, 0, n - 1);
        Reverse(nums, 0, k - 1);
        Reverse(nums, k, n - 1);
        System.out.println("R   otate Optimized");
        System.out.println(Arrays.toString(nums));
    }
    void Reverse(int[] nums, int s, int e) {
        while (e > s) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }

    @Override
    public void solve() {
        int[] num1 ={1,2,3,4,5,6,7};
        int k1=3;
        int[] num2 = {-1,-100,3,99};
        int k2 = 2;
        rotate(num1,k1);
        rotate(num2,k2);
        int[] num3 = {1, 2, 3, 4, 5, 6, 7};
        int[] num4 = {-1, -100, 3, 99};
        rotateOptimised(num3,k1);
        rotateOptimised(num4,k2);
    }
}
