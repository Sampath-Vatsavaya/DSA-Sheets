package arrays.basic;

import arrays.ArrayProblem;
import arrays.Run;

import java.util.Arrays;

/*
* Left Rotate the Array by One
Problem Statement: Given an integer array nums, rotate the array to the left by one.
Note: There is no need to return anything, just modify the given array.
*Example 1:
Input:
 nums = [1, 2, 3, 4, 5]
Output:
 [2, 3, 4, 5, 1]
Explanation:
 Initially, nums = [1, 2, 3, 4, 5]
Rotating once to the left results in nums = [2, 3, 4, 5, 1].

Example 2:
Input:
 nums = [-1, 0, 3, 6]
Output:
 [0, 3, 6, -1]
Explanation:
 Initially, nums = [-1, 0, 3, 6]
Rotating once to the left results in nums = [0, 3, 6, -1].
* */
@Run
public class LeftRotateArrayByOne implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Left Rotate Given Array By One Place";
    }


    /*
    * Algorithm
        Store the value of the first element of the array in a temporary variable.
        Iterate through the array starting from the second element.
        Shift each element one position to the left by assigning the current element to the position of its predecessor.
        After completing the iteration, place the value from the temporary variable into the last position of the array.
    * */
    public void rotateArrayByOne(int[] nums)
    {
        int temp = nums[0];
        for(int i =1;i<nums.length;i++)
        {
            nums[i-1]=nums[i];
        }
        nums[nums.length-1] = temp;
        System.out.println(Arrays.toString(nums));
    }

    @Override
    public void solve() {

        int[] nums = {1, 2, 3, 4, 5};
        rotateArrayByOne(nums);
    }
}
