package arrays.medium;

import arrays.ArrayProblem;
import arrays.Run;

/*
* Set Matrix Zeroes
* Link : https://leetcode.com/problems/set-matrix-zeroes/description/
* Solution: https://youtu.be/dSxt3ZCbIqA?si=qMWh-V7GYS_MIyq8
* Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.
Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
* */
@Run
public class SetMatrixZero implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Set Matrix Zero";
    }

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRow=false;
        boolean firstCol=false;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    if(i==0) firstRow=true;
                    if(j==0) firstCol=true;
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(matrix[i][0] ==0 || matrix[0][j]==0)
                {
                    matrix[i][j]=0;
                }
            }
        }


        if(firstRow)
        {
            for(int j=0;j<n;j++)
            {
                matrix[0][j]=0;
            }
        }
        if(firstCol)
        {
            for(int i=0;i<m;i++)
            {
                matrix[i][0]=0;
            }
        }
    }

    @Override
    public void solve() {

        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }
}
