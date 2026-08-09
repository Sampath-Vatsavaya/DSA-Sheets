package arrays.basic;

import arrays.ArrayProblem;
import arrays.Run;

@Run
public class LinearSearch implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Linear Search";
    }

    /*
    * Algorithm
    Given an array, traverse through the entire array.
    For each element, check if the element is present in the array.
    If the element is found, print the index of the element.
    If the element is not found, print -1.
    *
    * */
    public int linear(int[] nums,int target)
    {
        int n = nums.length;

        for(int i=0;i<n;i++)
        {
            if (nums[i] == target) return i;
        }
        return -1;
    }

    @Override
    public void solve() {

    }
}
