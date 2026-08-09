package arrays.basic;

import arrays.ArrayProblem;
import arrays.Run;

/*
* Problem Statement: Given a non-empty array of integers arr,
* every element appears twice except for one. Find that single one.
*Example 1:
Input: nums = [2,2,1]
Output: 1
Example 2:
Input: nums = [4,1,2,1,2]
Output: 4
Example 3:
Input: nums = [1]
Output: 1
*
* */
@Run
public class SingleNumber implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Find the number that appears once, and the other numbers twice";
    }

    /*
    * Intuition
    Two important properties of XOR are the following:
    XOR of two same numbers is always 0 i.e. a ^ a = 0. ←Property 1.
    XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a. ←Property 2
    Approach
    We will just perform the XOR of all elements of the array using a loop and the final XOR will be the answer.
    * */

    public int getSingleElement(int[] arr) {
        int xorr = 0;

        // XOR all elements — duplicates cancel each other out
        for (int num : arr) {
            xorr ^= num;
        }

        return xorr;
    }
    @Override
    public void solve() {
        int[] arr = {4, 1, 2, 1, 2};
        int ans = getSingleElement(arr);
        System.out.println("The single element is: " + ans);
    }
}
