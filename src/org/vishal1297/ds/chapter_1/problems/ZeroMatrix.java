package org.vishal1297.ds.chapter_1.problems;

import java.util.HashSet;

public class ZeroMatrix {

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println("\nInput : ");
        printMatrix(arr);
        zeroMatrix(arr);
        System.out.println("\nOutput : ");
        printMatrix(arr);
    }

    public static void zeroMatrix(int[][] matrix) {
        HashSet<Integer> row_set = new HashSet<>();
        HashSet<Integer> col_set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row_set.add(i);
                    col_set.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (row_set.contains(i) || col_set.contains(j)) {
                    matrix[i][j] = 0;
                }
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
