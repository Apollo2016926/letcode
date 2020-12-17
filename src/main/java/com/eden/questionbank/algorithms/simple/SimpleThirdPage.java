package com.eden.questionbank.algorithms.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 简单 page 3  size 100
 * @Author: gexx
 * @Date: 2020/12/16
 **/
public class SimpleThirdPage {
    /**
     * @Description: 比较含退格的字符串
     * @Author: gexx
     * @Date: 2020/12/16
     **/
    public static boolean backspaceCompare(String S, String T) {
        int sL = S.length();
        int tL = T.length();
        boolean eq;
        StringBuilder sbs = new StringBuilder();
        for (int i = 0; i < sL; i++) {
            if (S.charAt(i) == '#' && sbs.length() != 0) {
                sbs.deleteCharAt(sbs.length() - 1);
            } else {
                sbs.append(S.charAt(i));
            }
        }
        StringBuilder sbl = new StringBuilder();
        for (int i = 0; i < tL; i++) {
            if (T.charAt(i) == '#' && sbl.length() != 0) {
                sbl.deleteCharAt(sbl.length() - 1);
            } else {
                sbl.append(T.charAt(i));
            }
        }
        eq = sbs.toString().replace("#", "").equals(sbl.toString().replace("#", ""));

        return eq;
    }

    /**
     * @Description: 山脉数组的峰顶索引
     * @Author: gexx
     * @Date: 2020/12/16
     **/
    public static int peakIndexInMountainArray(int[] arr) {
        int top = -1;
        int topIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > top) {
                top = arr[i];
                topIndex = i;
            } else {
                return topIndex;
            }


        }
        return topIndex;
    }

    /**
     * @Description: 859. 亲密字符串
     * @Author: gexx
     * @Date: 2020/12/16
     **/
    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;

            for (int c : count)
                if (c > 1) return true;
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < A.length(); ++i) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }

            return (second != -1 && A.charAt(first) == B.charAt(second) &&
                    A.charAt(second) == B.charAt(first));
        }
    }


    /**
     * @Description: 867. 转置矩阵
     * @Author: gexx
     * [1,2,3]     [1,4,7]
     * [4,5,6]     [2,5,8]
     * [7,8,9]     [3,6,9]
     * <p>
     * [1,2,3] [1,4]
     * [4,5,6] [2,5]
     * [3,6]
     * @Date: 2020/12/17
     **/
    public int[][] transpose(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] ans = new int[C][R];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                ans[c][r] = A[r][c];
            }
        return ans;

    }


    /**
     * @Description: 868. 二进制间距
     * @Author: gexx
     * @Date: 2020/12/17
     **/
    public static int binaryGap(int n) {
        String binaryString = Integer.toBinaryString(n);
        List<Integer> list = new ArrayList();
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            if (c == '1') {
                list.add(i);
            }
        }
        if (list.size() <= 1) return 0;
        int max = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            max = Math.max(list.get(i + 1) - list.get(i), max);
        }
        return max;

    }

    public static void main(String[] args) {
        binaryGap(22);
        peakIndexInMountainArray(new int[]{0, 1, 0});
        buddyStrings("ab", "ba");
    }
}
