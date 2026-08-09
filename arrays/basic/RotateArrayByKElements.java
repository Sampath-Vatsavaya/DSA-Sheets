package arrays.basic;

import arrays.ArrayProblem;
import arrays.Run;

@Run
public class RotateArrayByKElements implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Rotate Given Array By K Elements";
    }

    /*
    *
    * Instead of simulating each rotation one by one, we can get the rotated array in-place by reversing specific parts of the array. This works because rotating is just rearranging sections of the array.
For Right Rotation by k steps:
Reverse the entire array
Reverse the first k elements
Reverse the remaining n - k elements
For Left Rotation by k steps:
Reverse the first k elements
Reverse the remaining n - k elements
Reverse the entire array
Normalize k by doing k = k % N
If direction is "right":
Reverse the entire array
Reverse the first k elements
Reverse the rest (from k to end)
If direction is "left":
Reverse the first k elements
Reverse the rest (from k to end)
Reverse the entire array
    *
    * Time Complexity: O(N), We reverse parts of the array each reverse takes linear time. So total work is 3 × O(N) = O(N).
      Space Complexity: O(1) All modifications are done in-place, using only a few temporary variables.
    * */
    void reverseArray(int[] nums, int start, int end) {
        // Swap elements until start meets end
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Function to rotate array left or right by k steps
    public int[] rotateArray(int[] nums, int k, String direction) {
        // Get array length
        int n = nums.length;

        // Edge case: do nothing if array is empty or k is 0
        if (n == 0 || k == 0) return nums;

        // Normalize k if greater than n
        k = k % n;

        // If rotation is to the right
        if (direction.equals("right")) {
            // Step 1: reverse entire array
            reverseArray(nums, 0, n - 1);

            // Step 2: reverse first k elements
            reverseArray(nums, 0, k - 1);

            // Step 3: reverse remaining n-k elements
            reverseArray(nums, k, n - 1);
        }
        // If rotation is to the left
        else if (direction.equals("left")) {
            // Step 1: reverse first k elements
            reverseArray(nums, 0, k - 1);

            // Step 2: reverse remaining n-k elements
            reverseArray(nums, k, n - 1);

            // Step 3: reverse entire array
            reverseArray(nums, 0, n - 1);
        }

        // Return the rotated array
        return nums;
    }



    @Override
    public void solve() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        String direction = "right";
        // Call rotateArray and store result
        int[] result = rotateArray(nums, k, direction);

        // Print rotated array
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
