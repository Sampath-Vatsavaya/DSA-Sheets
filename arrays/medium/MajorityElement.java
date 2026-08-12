package arrays.medium;

import arrays.ArrayProblem;
import arrays.Run;

import java.util.HashMap;
import java.util.Map;

/*
* Majority Element
* Link: https://leetcode.com/problems/majority-element/description/
* Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
Example 1:
Input: nums = [3,2,3]
Output: 3
Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
*
*
*
* */

public class MajorityElement implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Majority Element";
    }

    /*Initialize two variables: count to track the count of elements, and element to keep track of the element being counted.
Traverse through the given array. If count is 0, store the current value of the array as element.
If the current element in the array is the same as element, increment the count by 1.
If the current element is different from element, decrement the count by 1.
At the end of the traversal, the integer stored in element will be the expected result (the majority element).*/
     int boyerMooreAlgo(int[] nums)
    {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
    /*
    * Use a hashmap to store elements as (key, value) pairs, where the key is the element of the array and the value is the number of times it occurs.
Traverse the array and update the value of the corresponding key in the hashmap.
Simultaneously check if the value (the count) of any key is greater than the floor of (N/2).
If the value is greater than the floor of (N/2), return the key immediately as the majority element.
If no majority element is found, continue iterating through the array.
    *
    *
    * */
    public int majorityElement(int[] nums) {

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        int n = nums.length;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        /* Iterate through the map to
           find the majority element */
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }

        return -1;



    }

    @Override
    public void solve() {
        int[] nums1 = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums1));
        System.out.println(boyerMooreAlgo(nums1));
    }
}
