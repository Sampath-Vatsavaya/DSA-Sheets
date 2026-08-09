package arrays.basic;

import arrays.ArrayProblem;
import arrays.Run;

/*
*
*Find the Missing Number
* Given an array arr[] of size n-1 with distinct integers in the range of [1, n].
* This array represents a permutation of the integers from 1 to n with one element missing.
* Find the missing element in the array
*Input: arr[] = [8, 2, 4, 5, 3, 7, 1]
Output: 6
Explanation: All the numbers from 1 to 8 are present except 6.
Input: arr[] = [1, 2, 3, 5]
Output: 4
Explanation: Here the size of the array is 4, so the range will be [1, 5]. The missing number between 1 to 5 is 4
* */
@Run
public class FindMissingNumberInSeries implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Find the Missing Number ";
    }


    /*
        This approach uses a hash array (or frequency array) to track the presence of each number from 1 to n in the input array. It first initializes a hash array to store the frequency of each element.
        Then, it iterates through the hash array to find the number that is missing (i.e., the one with a frequency of 0).
    * */
    public  int missingNumHash(int[] arr) {
        int n = arr.length + 1;

        // Create hash array of size n+1
        int[] hash = new int[n + 1];

        // Store frequencies of elements
        for (int i = 0; i < n - 1; i++) {
            hash[arr[i]]++;
        }

        // Find the missing number
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    /*
    * Using Sum of n terms Formula - O(n) Time and O(1) Space
    The sum of the first n natural numbers is given by the formula (n * (n + 1)) / 2.
*  The idea is to compute this sum and subtract the sum of all elements in the array from it to get the missing number.
    *
    * */
    public static int missingNumBasedOnSum(int[] arr) {
        long n = arr.length + 1;

        // Calculate the sum of array elements
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // Use long for expected sum to avoid overflow
        long expSum = n * (n + 1) / 2;

        // Return the missing number
        return (int)(expSum - sum);
    }

    /*
    * Using XOR Operation - O(n) Time and O(1) Space
 XOR of a number with itself is 0 i.e. x ^ x = 0 and the given array arr[] has numbers in range [1, n]. This means that the result of XOR of first n natural numbers with the XOR of all the array elements will be the missing number.
 *  To do so, calculate XOR of first n natural numbers and XOR of all the array arr[] elements,
 * x and then our result will be the XOR of both the resultant values.
    *
    *
    * */
    public  int missingNumXOR(int[] arr) {
        int n = arr.length + 1;
        int xor1 = 0, xor2 = 0;

        // XOR all array elements
        for (int i = 0; i < n - 1; i++) {
            xor2 ^= arr[i];
        }

        // XOR all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xor1 ^= i;
        }

        // Missing number is the XOR of xor1 and xor2
        return xor1 ^ xor2;
    }

    @Override
    public void solve() {
        int[] arr = {8, 2, 4, 5, 3, 7, 1};
        int res = missingNumHash(arr);
        System.out.println(res);
        System.out.println(missingNumBasedOnSum(arr));
        System.out.println(missingNumXOR(arr));
    }
}
