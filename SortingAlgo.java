import java.util.Arrays;

public class SortingAlgo {


    static void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    /*
    * Algorithm:
    * First, we will select the range of the unsorted array using a loop (say i) that indicates the starting index of the range. The loop will run forward from 0 to n-1. The value i = 0 means the range is from 0 to n-1, and similarly, i = 1 means the range is from 1 to n-1, and so on. (Initially, the range will be the whole array starting from the first index.)
      Now, in each iteration, we will select the minimum element from the range of the unsorted array using an inner loop.
      After that, we will swap the minimum element with the first element of the selected range(in step 1).
      Finally, after each iteration, we will find that the array is sorted up to the first index of the range.
    *
    *
    * */
    static void selectionSort(int[] nums)
    {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            int minIndex=i;
            for(int j=i+1;j<n;j++)
            {
                if(nums[j]<nums[minIndex])
                {
                    minIndex =j;
                }
            }
            swap(nums,minIndex,i);
        }

    }


    /*
    * Algorithm:
    * The best case occurs if the given array is already sorted. We can reduce the time complexity to O(N) by just adding a small check inside the loops.
        We will check in the first iteration if any swap is taking place. If the array is already sorted no swap will occur and we will break out from the loops.
    Thus the iteration of the outer loop will be just 1. And our overall time complexity will be O(N).
    *
    * */
    static void bubbleSort(int[] arr)
    {

        int n=arr.length;
        for (int i = n - 1; i >= 0; i--) {  //Use two nested loops to iterate over the array
            boolean didSwap = false;
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];  //Swap arr[j+1] with arr[i]
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    didSwap = true;
                }
            }
            if (!didSwap) {
                break;
            }
        }

    }

    static void bubbleSortFromZero(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean didSwap = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    didSwap = true;
                }
            }

            if (!didSwap) {
                break;
            }
        }
    }

    /*
    * In each iteration, select an element from the unsorted part of the array using an outer loop.
Place this selected element in its correct position within the sorted part of the array.
Use an inner loop to shift the remaining elements, if necessary, to accommodate the selected element. This involves shifting elements by one position until the selected element can be placed in the correct position.
Continue this process until the entire array is sorted.
    *
    *
    * */

    private static void insertionSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j = i;
            int curr = arr[i];

            while (j > 0 && arr[j - 1] > curr) {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = curr;
        }
    }

    static void main() {

        int[] arrSel = {13, 46, 24, 52, 20, 9};
        int[] arrBubble1 = {13, 46, 24, 52, 20, 9};
        int[] arrBubble2 = {13, 46, 24, 52, 20, 9};
        int[] arrIns = {13, 46, 24, 52, 20, 9};

        System.out.println("Selection Sort");
        selectionSort(arrSel);
        System.out.println(Arrays.toString(arrSel));

        System.out.println("Bubble Sort");
        bubbleSort(arrBubble1);
        System.out.println(Arrays.toString(arrBubble1));
        bubbleSortFromZero(arrBubble2);
        System.out.println(Arrays.toString(arrBubble2));


        System.out.println("Insertion Sort");
        insertionSort(arrIns);
        System.out.println(Arrays.toString(arrIns));

    }


}
