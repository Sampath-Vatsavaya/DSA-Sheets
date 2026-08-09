package arrays.basic;

import arrays.ArrayProblem;
import arrays.Run;

/*
* Find Second Smallest and Second Largest Element in an array
Problem Statement: Given an array, find the second smallest and second largest element in the array. Print ‘-1’ in the event that either of them doesn’t exist.
Problem Link : https://takeuforward.org/data-structure/find-second-smallest-and-second-largest-element-in-an-array
*
* * */

@Run
public class SecondSmallerAndSecondLargest implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Find Second Smallest and Second Largest Element in an array";
    }




    /*
    * Algorithm
    We will need four variables: small, second_small, large, and second_large. Initialize small and second_small to INT_MAX, and large and second_large to INT_MIN.
    Second Smallest Algorithm:
    If the current element is smaller than 'small', update the values of second_small and small.
    Else if the current element is smaller than 'second_small', update the value of second_small.
    After traversing the array, the second smallest element will be stored in the variable second_small.
    Second Largest Algorithm:
    If the current element is larger than 'large', update the values of second_large and large.
    Else if the current element is larger than 'second_large', update the value of second_large.
    After traversing the array, the second largest element will be stored in the variable second_large.
    *
    * Complexity Analysis
    Time Complexity: O(N), we do two linear traversals in our array.

    Space Complexity: O(1), as we are using a constant
    *
    *
    * */

    public void getRequiredElements(int[] arr)
    {
        int maxElement = Integer.MIN_VALUE;
        int secondMaxElement = Integer.MIN_VALUE;
        int minElement = Integer.MAX_VALUE;
        int secondMinElement = Integer.MAX_VALUE;
        if(arr.length >1) {
            for(int i: arr)
            {
                if (i > maxElement) {
                    secondMaxElement = maxElement;
                    maxElement = i;
                }
                else if (i > secondMaxElement && i != maxElement) {
                    secondMaxElement = i;
                }

                if(i< minElement)
                {
                    secondMinElement = minElement;
                    minElement = i;
                }
                if(i<secondMinElement && i!=minElement)
                {
                    secondMinElement = i;
                }



            }
        }
        else{
            secondMinElement = -1;
            secondMaxElement = -1;
        }
        System.out.printf("Second Max Element - %d , Second Min Element - %d ",secondMaxElement,secondMinElement);


    }


    @Override
    public void solve() {
        int[] arr = {1, 2, 4, 6, 7, 5};
        getRequiredElements(arr);
    }
}
