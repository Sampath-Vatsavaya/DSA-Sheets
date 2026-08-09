package arrays.basic;

import arrays.ArrayProblem;
import arrays.Run;

import java.util.*;


/*
* Union of Two Sorted Arrays
Problem Statement: Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of two sorted arrays.
The union of two arrays can be defined as the common and distinct elements in the two arrays.
* Link: https://takeuforward.org/data-structure/union-of-two-sorted-arrays
*
* */
public class UnionOfTwoSortedArrays implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Union of Two Sorted Arrays";
    }


    /*
    * Using a set we can find the distinct elements because the set does not hold any duplicates. Hence we can find the union of arr1 and arr2.
    Initialize an empty set.
    Insert all elements from the first array into set.
    Insert all elements from the second array into set.
    Convert the set into a list/array to get the result.
    If required in sorted order, sort the list before returning.
    Return/print the union result.
    *
    * */
    public List<Integer> setBasedSolution(int[] arr1, int[] arr2)
    {
        Set<Integer> st = new TreeSet<>();

        // Insert elements from first array
        for (int num : arr1) {
            st.add(num);
        }

        // Insert elements from second array
        for (int num : arr2) {
            st.add(num);
        }

        // Convert set to list
        return new ArrayList<>(st);
    }

    /*
    * Merge Sort
    * Algorithm:
    * Since both arrays are sorted, we can efficiently find their union by iterating through them simultaneously. Using two pointers, one for each array, we compare elements and add the smaller one to the result (skipping duplicates). If elements are equal, add once and move both pointers. This way, we merge the arrays like in merge sort, avoiding extra space for maps or sets and achieving linear time complexity.
        Initialize two pointers at the start of both arrays.
        While neither pointer has reached the end:
        If element pointed by first pointer is smaller, add it to result if not duplicate, move first pointer.
        If element pointed by second pointer is smaller, add it to result if not duplicate, move second pointer.
        If both elements are equal, add one to result if not duplicate, move both pointers.
        After exiting loop, append remaining elements from either array, skipping duplicates.
        Return the result array containing the union.
    *
    * */
    // Function to find union of two sorted arrays using two pointers
    public List<Integer> findUnion(int[] arr1, int[] arr2) {
        // List to store union elements
        int n = arr1.length;
        int m=arr2.length;
        List<Integer> Union = new ArrayList<>();

        // Initialize pointers
        int i = 0, j = 0;

        // Iterate while both arrays have elements
        while (i < n && j < m) {
            // If element in arr1 is smaller
            if (arr1[i] < arr2[j]) {
                // Add if empty or not duplicate
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;  // Move pointer in arr1
            }
            // If element in arr2 is smaller
            else if (arr2[j] < arr1[i]) {
                // Add if empty or not duplicate
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr2[j])
                    Union.add(arr2[j]);
                j++;  // Move pointer in arr2
            }
            else {
                // Elements are equal, add once if not duplicate
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++; j++;  // Move both pointers
            }
        }

        // Append remaining elements from arr1
        while (i < n) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }

        // Append remaining elements from arr2
        while (j < m) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }

        // Return the union list
        return Union;
    }

    @Override
    public void solve() {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {2, 3, 4, 4, 5, 11, 12};
        System.out.println(setBasedSolution(arr1,arr2));
    }
}
