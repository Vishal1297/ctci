package org.vishal1297.ds.chapter_1.problems;

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("\nInput : ");
        printMatrix(arr);
        rotate(arr);
        System.out.println("\nOutput : ");
        printMatrix(arr);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1)/2; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n-1-i][n - j - 1];
                matrix[n-1-i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j]= temp;
            }
        }
    }

    public static void printMatrix(int[][] arr) {
        for (int[] row : arr) {
            for (int num: row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
