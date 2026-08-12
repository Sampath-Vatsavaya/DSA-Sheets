package arrays.medium;

import arrays.ArrayProblem;
import arrays.Run;

import java.util.ArrayList;

/*
*
* Rearrange Array Elements by Sign
* Link: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
*
* You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should return the array of nums such that the array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
*
* */
@Run
public class RearrangeElementsBySign implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Rearrange Array Elements by Sign";
    }

    /*
    * Approach -1 :
    * In this simple approach, since the number of positive and negative elements are the same, we put positives into an array called “pos” and negatives into an array called “neg”.
After segregating each of the positive and negative elements, we start putting them alternatively back into array A.
Since the array must begin with a positive number and the start index is 0, so all the positive numbers would be placed at even indices (2*i) and negatives at the odd indices (2*i+1), where i is the index of the pos or neg array while traversing them simultaneously.
This approach uses O(N+N/2) of running time due to multiple traversals which we’ll try to optimize in the optimized approach given below.
*
    *
    * */
    public int[] rearrangeArraySimple(int[] nums) {
        ArrayList<Integer> n1 = new ArrayList<Integer>();
        ArrayList<Integer> n2 = new ArrayList<Integer>();
        for(int i:nums)
        {
            if (i>=0) n1.add(i);
            else n2.add(i);
        }
        int n=nums.length;
        for(int i=0;i<n/2;i++)
        {
            nums[2*i]=n1.get(i);
            nums[2*i+1]=n2.get(i);
        }
        return nums;
    }
    // Approach 1 in my way
    public int[] rearrangeArrayWithWhile(int[] nums) {
        ArrayList<Integer> n1 = new ArrayList<Integer>();
        ArrayList<Integer> n2 = new ArrayList<Integer>();
        for(int i:nums)
        {
            if (i>=0) n1.add(i);
            else n2.add(i);
        }
        int i = 0;
        int j = 0;

        while (i < nums.length) {
            nums[i] = n1.get(j);
            nums[i + 1] = n2.get(j);

            i += 2;
            j++;
        }
        return nums;
    }

    /*
    *
    * In this optimal approach, we will try to solve the problem in a single pass and try to arrange the array elements in the correct order in that pass only.
We know that the resultant array must start from a positive element so we initialize the positive index as 0 and negative index as 1 and start traversing the array such that whenever we see the first positive element, it occupies the space at 0 and then posIndex increases by 2 (alternate places).
Similarly, when we encounter the first negative element, it occupies the position at index 1, and then each time we find a negative number, we put it on the negIndex and it increments by 2.
When both the negIndex and posIndex exceed the size of the array, we see that the whole array is now rearranged alternatively according to the sign.
    * */
    public int[] rearrangeArrayOptimalTime(int[] nums) {

        int posIndex=0;
        int negIndex=1;
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                ans[posIndex] = nums[i];
                posIndex+=2;
            }
            else{
                ans[negIndex]=nums[i];
                negIndex+=2;
            }
        }

        return ans;
    }

    // If order is not required to be preserved
    public int[] rearrangeArrayNoOrder(int[] nums) {
        int n = nums.length;
        int pos = 0, neg = 1;
        while(pos < n && neg < n) {
            if(nums[pos] >= 0) pos += 2;
            else if(nums[neg] < 0) neg += 2;
            else {
                int temp = nums[pos];
                nums[pos] = nums[neg];
                nums[neg] = temp;
            }
        }
        return nums;
    }



    @Override
    public void solve() {

    }
}
