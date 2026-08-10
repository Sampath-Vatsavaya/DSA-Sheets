package arrays.medium;

import arrays.ArrayProblem;
import arrays.Run;

import java.util.Arrays;
import java.util.HashMap;

/*
* Two Sum : Check if a pair with given sum exists in Array


44

Problem Statement: Given an array of integers arr[] and an integer target.

Return indices of the two numbers such that their sum is equal to the target.
*  Otherwise, we will return {-1, -1}.
*
* */

@Run
public class TwoSum implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Two Sum";
    }

    /*
    *
    * We will select the element of the array one by one using a loop (say i).
    Then we will check if the other required element (i.e. target - arr[i]) exists in the HashMap.
    If that element exists, then we will return “YES” for the first variant or we will return the current index i.e. i, and the index of the element found using map i.e. mp[target - arr[i]].
    If that element does not exist, then we will just store the current element in the HashMap along with its index. Because in the future, the current element might be a part of our answer.
    Finally, if we are out of the loop, that means there is no such pair whose sum is equal to the target. In this case, we will return either “NO” or {-1, -1} as per the variant of the question
    *
    *
    *
    *
    * */
    public int[] mapBasedTwoSum(int[] arr, int target)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            // If complement found, return indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            // Store current element and index
            map.put(arr[i], i);
        }
        // No pair found
        return new int[] { -1, -1 };
    }


    /*
    * We will sort the given array first.
    Now, we will take two pointers i.e. left, which points to the first index, and right, which points to the last index.
    Now using a loop we will check the sum of arr[left] and arr[right] until left < right.
    If arr[left] + arr[right] > sum, we will decrement the right pointer.
    If arr[left] + arr[right] < sum, we will increment the left pointer.
    If arr[left] + arr[right] == sum, we will return the result.
    Finally, if no results are found we will return “NO” or {-1, -1}.
    *
    * */
    public int[] twoPointerTwoSum(int[] arr,int target)
    {
        int n = arr.length;
        int[][] numsWithIndex = new int[n][2];

        // Store element with original index
        for (int i = 0; i < n; i++) {
            numsWithIndex[i][0] = arr[i];
            numsWithIndex[i][1] = i;
        }

        // Sort by the value to apply two-pointer
        Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0, right = n - 1;
        while (left < right) {
            int sum = numsWithIndex[left][0] + numsWithIndex[right][0];
            if (sum == target) {
                // Return original indices of the two numbers found
                return new int[] {numsWithIndex[left][1], numsWithIndex[right][1]};
            } else if (sum < target) {
                // Increase sum by moving left pointer forward
                left++;
            } else {
                // Decrease sum by moving right pointer backward
                right--;
            }
        }

        // No pair found
        return new int[] {-1, -1};


    }

    @Override
    public void solve() {
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        System.out.println(Arrays.toString(mapBasedTwoSum(arr,target)));
        System.out.println(Arrays.toString(twoPointerTwoSum(arr,target)));
    }
}
