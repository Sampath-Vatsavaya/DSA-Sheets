package arrays.basic;

import arrays.ArrayProblem;
import arrays.Run;

import java.util.HashMap;
import java.util.Map;

/*
*Length of the longest subarray with zero Sum
Problem Statement: Given an array containing both positive and negative integers,
* we have to find the length of the longest subarray with the sum of all elements equal to zero.
* Example 1:
Input:
 N = 6, array[] = {9, -3, 3, -1, 6, -5}
Result:
 5
Explanation:
 The following subarrays sum to zero:
- {-3, 3}
- {-1, 6, -5}
- {-3, 3, -1, 6, -5}
The length of the longest subarray with sum zero is 5.
Example 2:
Input:
 N = 8, array[] = {6, -2, 2, -8, 1, 7, 4, -10}
Result:
 8
Explanation:
 Subarrays with sum zero:
- {-2, 2}
- {-8, 1, 7}
- {-2, 2, -8, 1, 7}
- {6, -2, 2, -8, 1, 7, 4, -10}
The length of the longest subarray with sum zero is 8.
*
* */


@Run
public class LongestSubArrayWithZeroSum implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Length of the longest subarray with zero Sum";
    }

    /*
    * Initialize a variable sum = 0, which stores the sum of elements traversed so far, and another variable max = 0, which stores the length of the longest subarray with sum zero.
      Declare a HashMap<Integer, Integer> to store the prefix sum of every element as a key and its index as a value.
      Traverse the array and add the array element to the sum.
        If sum = 0, update max with the maximum value between max and current_index + 1, as the subarray from the start to the current index has a sum of 0.
        If sum is not equal to zero, check the HashMap to see if we've encountered this sum before.
        If the HashMap contains the sum, this indicates that a subarray with the same sum exists, so update max accordingly.
        If the sum is not found in the HashMap, insert (sum, current_index) into the HashMap to store the prefix sum until the current index.
        After traversing the entire array, the max variable will hold the length of the longest subarray with a sum equal to zero. Return max.
    *
    *
    * */

    public void getLongestSubArrayWithZeroSum(int[] nums)
    {
        int max =0;
        int sum =0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();


        for(int i =0;i< nums.length;i++)
        {
            sum += nums[i];
            if (sum==0)
            {
                max = i+1;
            }
            else{
                if (map.containsKey(sum))
                {
                    max = Math.max(max , i - map.get(sum));
                }
                else{
                    map.put(sum,i);
                }
            }
        }
        System.out.println(max);
    }


    @Override
    public void solve() {
        int[] n1 = {6, -2, 2, -8, 1, 7, 4, -10};
        int[] n2 = {9, -3, 3, -1, 6, -5};
        getLongestSubArrayWithZeroSum(n1);
        getLongestSubArrayWithZeroSum(n2);
    }
}
