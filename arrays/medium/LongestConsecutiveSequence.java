package arrays.medium;

import arrays.ArrayProblem;
import arrays.Run;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* Longest Consecutive Sequence in an Array
Link : https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-array
* Problem Statement: Given an array nums of n integers.
Return the length of the longest sequence of consecutive integers. The integers in this sequence can appear in any order.
* */
@Run
public class LongestConsecutiveSequence implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Longest Consecutive Sequence in an Array";
    }


    /*
    * Begin by sorting the entire array in ascending order. This step helps group consecutive numbers together, simplifying the sequence detection process.
Use a loop to iterate through each element of the sorted array.
Track consecutive sequences by comparing each element arr[i] with the lastSmaller variable. If arr[i] - 1 == lastSmaller, increment the length of the current sequence (cnt) and update lastSmaller to arr[i].
Skip the current element if arr[i] equals lastSmaller, as it's already part of a sequence.
If arr[i] is greater than lastSmaller + 1, start a new sequence from arr[i] by updating lastSmaller to arr[i] and reset cnt to 1.
Throughout the iteration, compare cnt with longest and update longest to store the maximum sequence length encountered.
Note: Here, we are distorting the given array by sorting it.
    *
    * */
    public int longestConsecutive(int[] nums) {
        // Store the size of the array
        int n = nums.length;

        // Return 0 if array is empty
        if (n == 0) return 0;

        // Sort the array to bring consecutive numbers together
        Arrays.sort(nums);

        // Variable to track the last smaller element in sequence
        int lastSmaller = Integer.MIN_VALUE;

        // Variable to store the current sequence length
        int cnt = 0;

        // Variable to store the longest sequence length found
        int longest = 1;

        // Iterate through the sorted array
        for (int i = 0; i < n; i++) {
            // Case 1: Current element is exactly one greater than lastSmaller → part of sequence
            if (nums[i] - 1 == lastSmaller) {
                // Increment the sequence length
                cnt += 1;
                // Update the last smaller element
                lastSmaller = nums[i];
            }
            // Case 2: Current element is not consecutive and not a duplicate
            else if (nums[i] != lastSmaller) {
                // Reset the sequence length count to 1
                cnt = 1;
                // Update the last smaller element
                lastSmaller = nums[i];
            }
            // Update the longest sequence length if the current sequence is longer
            longest = Math.max(longest, cnt);
        }

        // Return the length of the longest consecutive sequence
        return longest;
    }


    /*
    * Optimal :
    *
    *
    * We will use two variables: cnt to store the length of the current sequence and longest to store the maximum length found.
First, place all the array elements into a set data structure to allow efficient lookups for consecutive numbers.
For each element x that can start a sequence (i.e., x - 1 does not exist in the set), we follow these steps:
Initialize cnt to 1, indicating the starting element of a new sequence.
Use the set to search for consecutive elements such as x + 1, x + 2, and so on, to determine the maximum possible length of the current sequence. Update cnt accordingly.
Compare cnt with longest and update longest to hold the maximum value: longest = max(longest, cnt).
Finally, longest will contain the length of the longest consecutive sequence found in the array.
    * */

    public int longestConsecutiveOptimal(int[] nums) {
        // Get the length of the array
        int n = nums.length;

        // If the array is empty, no sequence exists
        if (n == 0) return 0;

        // Variable to store the longest sequence length found
        int longest = 1;

        // HashSet to store unique elements for O(1) lookup
        Set<Integer> st = new HashSet<>();

        // Add all elements to the set to remove duplicates
        for (int i = 0; i < n; i++) {
            st.add(nums[i]);
        }

        /* Loop through each element in the set to find
           the starting point of consecutive sequences */
        for (int it : st) {
            // If there is no number before 'it', it’s the start of a sequence
            if (!st.contains(it - 1)) {
                // Start the count for this sequence
                int cnt = 1;
                // Store the current number
                int x = it;

                // Keep checking for the next consecutive number
                while (st.contains(x + 1)) {
                    // Move to the next number in sequence
                    x = x + 1;
                    // Increment the length of current sequence
                    cnt = cnt + 1;
                }

                // Update the longest sequence length if needed
                longest = Math.max(longest, cnt);
            }
        }

        // Return the length of the longest sequence
        return longest;
    }
    @Override
    public void solve() {

        int[] a = {100, 4, 200, 1, 3, 2};



        // Call the function to get the longest consecutive sequence length
        int ans = longestConsecutive(a);

        // Print the result
        System.out.println("The longest consecutive sequence is " + ans);
    }
}
