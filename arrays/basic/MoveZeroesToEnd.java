package arrays.basic;

import arrays.ArrayProblem;

/*
*
* Move Zeroes To the End:
*
* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.
Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:
Input: nums = [0]
Output: [0]
* */
public class MoveZeroesToEnd implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Move Zeroes To The End ";
    }
    /*
    * My Approach
    * */
    public void moveZeroes(int[] nums) {
        int i=0;
        int j=1;
        int n = nums.length;
        if (n==0 || n==1) return;
        while(i<n && j<n)
        {
            if(nums[i]!=0)
            {
                i++;
            }
            if(nums[i]==0 && nums[j]!=0)
            {
                nums[i]=nums[j];
                nums[j]=0;
                i++;
            }
            j++;

        }
    }

    /*
    * Move Zeroes Striver:
    * Algorithm:
    * First, we iterate through the array to locate the position of the first zero, using a pointer j. If no zero is found, no further steps are needed.
Next, we set a second pointer i to j + 1 and start moving it forward through the array.
While moving i, whenever we encounter a non-zero element a[i], we swap it with the element at index j. After the swap, since j now holds a non-zero value, we increment j to point to the next zero.
    *
    * */
    public void moveZeroesStriver(int[] nums) {
        // Pointer to the first zero
        int j = -1;

        // Find the first zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // If no zero found, return
        if (j == -1) return;

        // Start from the next index of first zero
        for (int i = j + 1; i < nums.length; i++) {
            // If current element is non-zero
            if (nums[i] != 0) {
                // Swap with nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // Move j to next zero
                j++;
            }
        }
    }

    // Shift non-zero values as far forward as possible
// Fill remaining space with zeros
    // https://leetcode.com/problems/move-zeroes/solutions/72011/simple-on-java-solution-using-insert-ind-u41k/
    public void moveZeroesIndex(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    @Override
    public void solve() {

        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }
}
