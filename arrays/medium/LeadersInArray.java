package arrays.medium;

import arrays.ArrayProblem;
import arrays.Run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
* Leaders in an Array
* Link: https://takeuforward.org/data-structure/leaders-in-an-array
* Example 1:
Input:
 arr = [4, 7, 1, 0]
Output:
 7 1 0
Explanation:
 The rightmost element (0) is always a leader.
7 and 1 are greater than the elements to their right, making them leaders as well.
Example 2:
Input:
 arr = [10, 22, 12, 3, 0, 6]
Output:
 22 12 6
Explanation:
 6 is a leader because there are no elements after it.
12 is greater than all the elements to its right (3, 0, 6), and 22 is greater than 12, 3, 0, 6, making them leaders as well.
* */
@Run
public class LeadersInArray implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Leaders in an Array";
    }

    /*
    * Set a variable max to the last element of the array (nums[sizeOfArray - 1]), as the last element is always a leader.
Create an empty list ans to store the leader elements, and initially add the last element of the array to this list, as it is always a leader.
Start from the second last element (index = sizeOfArray - 2) and move towards the first element (index = 0).
For each element, compare it with the max variable. If the current element is greater than max, add this element to the ans list and update max to the current element.
After processing all elements, the ans list will contain all the leader elements in reverse order. Reverse the ans list and return it.
    *
    *
    * */
    public ArrayList<Integer> leaders(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (nums.length == 0) {
            return ans;
        }

        // Last element of the array is always a leader
        int max = nums[nums.length - 1];
        ans.add(nums[nums.length - 1]);

        // Check elements from right to left
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > max) {
                ans.add(nums[i]);
                max = nums[i];
            }
        }

        /* Reverse the list to match
        the required output order */
        Collections.reverse(ans);

        // Return the leaders
        return ans;
    }

    @Override
    public void solve() {
        int[] nums = {10, 22, 12, 3, 0, 6};
        System.out.println(leaders(nums).toString());
    }
}
