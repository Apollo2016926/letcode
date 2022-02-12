package com.eden.explore.datastructure.arrayandstring;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 二维数组简介
 * @Author gexx
 * @Date 2019/12/25
 * @Version V1.0
 **/
public class Instroduction22Arrays {
    /**
     * @Description: 对角线遍历
     * @Param: [matrix]
     * @Return: int[]
     * @Author: gexx
     * @Date: 2019/12/25
     **/
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] newArray = new int[m * n];
        int[][] trans = {{-1, 1}, {1, -1}};
        int raw = 0;
        int col = 0;
        int k = 0;
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = matrix[raw][col];
            raw += trans[k][0];
            col += trans[k][1];

            if (col > n - 1) {
                col = n - 1;
                raw += 2;
                k = 1 - k;
            }
            if (raw > m - 1) {
                raw = m - 1;
                col += 2;
                k = 1 - k;
            }
            if (col < 0) {
                col = 0;
                k = 1 - k;
            }
            if (raw < 0) {
                raw = 0;
                k = 1 - k;
            }
        }
        return newArray;
    }

    /**
     * @Description: 螺旋矩阵
     * @Param: [matrix]
     * @Return: java.util.List<java.lang.Integer>
     * @Author: gexx
     * @Date: 2019/12/25
     **/
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> arrayList = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return arrayList;
        }

        int rowNum = matrix.length, colNum = matrix[0].length;
        int left = 0, right = colNum - 1, up = 0, down = rowNum - 1;
        int sumNum = rowNum * colNum;
        int num = 0;
        while (num < sumNum) {
            for (int i = left; i <= right; i++) {
                arrayList.add(matrix[up][i]);
                num++;
                if (num == sumNum) {
                    break;
                }
            }
            if (num == sumNum) {
                break;
            }
            up++;
            for (int i = up; i <= down; i++) {
                arrayList.add(matrix[i][right]);
                num++;
                if (num == sumNum) {
                    break;
                }
            }
            if (num == sumNum) {
                break;
            }
            right--;
            for (int i = right; i >= left; i--) {
                arrayList.add(matrix[down][i]);
                num++;
                if (num == sumNum) {
                    break;
                }
            }
            if (num == sumNum) {
                break;
            }
            down--;
            for (int i = down; i >= up; i--) {
                arrayList.add(matrix[i][left]);
                num++;
                if (num == sumNum) {
                    break;
                }
            }
            if (num == sumNum) {
                break;
            }
            left++;
        }
        return arrayList;


    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };


        spiralOrder(matrix);
    }
}
