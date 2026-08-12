package arrays.medium;

import arrays.ArrayProblem;
import arrays.Run;

/*
*
* Rotate Matrix by 90 Degrees
* Link: https://leetcode.com/problems/rotate-image/description/
* You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
*
*Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
* */
@Run
public class RotateMatrixBy90 implements ArrayProblem {

    @Override
    public String getProblemTitle() {
        return "Rotate Matrix by 90 Degrees";
    }

    /*
    * In a 90-degree clockwise rotation, each element in the matrix moves from its original position to a new position based on a specific pattern. The first column becomes the first row (in reverse order) and second column becomes the second row, and so on.
We can simulate this movement by using a new matrix. For each element at position (i, j) in the original matrix, we calculate its new position in the rotated matrix as (j, n - i - 1) where n is the size of the matrix.
Initialize an empty matrix of the same size (n x n).
Loop through every element of the original matrix using two nested loops.
For each element at position (i, j), place it in the new matrix at position (j, n - i - 1).
After completing the placement for all elements, return or copy the new matrix.
    *
    * */
    public void rotateInPlaceFormula(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                result[j][n - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = result[i][j];
            }
        }

    }

    /*
    * To rotate a matrix 90 degrees clockwise in-place (without using extra space), we use two key matrix operations:
Step 1: Transpose the matrix: swap elements across the diagonal. This converts rows into columns.
Step 2: Reverse each row: this turns the new columns into the final rotated rows.

This works because:
Transposing moves elements from (i, j) to (j, i), effectively rotating across the diagonal.
Reversing the rows repositions the elements in each row, finalizing the clockwise rotation.
Get the size of the square matrix (number of rows or columns).
Start the first phase: Transpose the matrix
For each row starting from the top to bottom:
For each column starting from the diagonal element (excluding already visited elements):
Swap the current element with the element that is diagonally opposite across the main diagonal.
This effectively flips the matrix over its top-left to bottom-right diagonal, converting rows into columns.
Move to the second phase: Reverse each row
For every row in the matrix:
Reverse the order of the elements in that row (first element becomes last, second becomes second last, and so on).
This realigns the columns to their correct position for the clockwise rotation.
Once both phases are done, the matrix will have been rotated 90 degrees clockwise in-place.*/
    public void rotateByTransposeAndReverse(int[][] matrix) {

        int n = matrix.length;
        // Transpose Whole Matrix
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int temp = matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        // Reverse elements in every row
        for (int i = 0; i < n; i++) {

            for (int j = n - 1; j >= n / 2; j--) {

                int temp = matrix[i][j];

                matrix[i][j] = matrix[i][n - 1 - j];

                matrix[i][n - 1 - j] = temp;
            }
        }

    }

    @Override
    public void solve() {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotateByTransposeAndReverse(matrix);

        // Print rotated matrix
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
