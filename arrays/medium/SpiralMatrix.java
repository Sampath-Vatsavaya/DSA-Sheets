package arrays.medium;

import arrays.ArrayProblem;
import arrays.Run;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/*
* Spiral Matrix
* Link: https://leetcode.com/problems/spiral-matrix/description/
* Given an m x n matrix, return all elements of the matrix in spiral order.
Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]*/
@Run
public class SpiralMatrix implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Spiral Matrix";
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List result = new ArrayList<>();

        // Initialize boundaries
        int top = 0;                        // Starting row
        int bottom = matrix.length - 1;     // Ending row
        int left = 0;                       // Starting column
        int right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {

            // Traverse the top row from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Move the top boundary downward

            // Traverse the right column from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move the right boundary leftward

            // Traverse the bottom row from right to left (only if rows remain)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary upward
            }

            // Traverse the left column from bottom to top (only if columns remain)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move the left boundary rightward
            }
        }

        // Return the spiral order result
        return result;// Ending column

    }

    @Override
    public void solve() {
        // Input matrix
        int[][] matrix = {
                { 1,  2,  3,  4 },
                { 5,  6,  7,  8 },
                { 9, 10, 11, 12 },
                { 13,14, 15, 16 }
        };

        // Call spiralOrder function
        List ans = spiralOrder(matrix);

        // Print result
        System.out.println(ans);
    }
}
