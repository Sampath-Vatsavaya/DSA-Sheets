package arrays.basic;

import arrays.ArrayProblem;
import arrays.Run;


public class ReverseArray implements ArrayProblem {

    @Override
    public String getProblemTitle() {
        return "Reverse an Array";
    }

    @Override
    public void solve() {

        int[] arr = {1, 2, 3, 4, 5};

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        System.out.println("Reversed array:");
        System.out.println(java.util.Arrays.toString(arr));
    }
}