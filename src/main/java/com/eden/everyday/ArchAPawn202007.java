package com.eden.everyday;

/**
 * @Description: 每日一题
 * @Author gexx
 * @Date 2020/7/17
 * @Version V1.0
 **/
public class ArchAPawn202007 {
    /**
     * @Description: 搜索插入位置
     * @Author: gexx
     * @Date: 2020/7/17
     **/
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            } else if (target > nums[i] && i < nums.length - 1 && target < nums[i + 1]) {
                return i + 1;
            }
        }

        return 1;
    }

    /**
     * @Description 交错字符串
     *
     * @Author gexx
     * @Date 2020/7/18
     **/
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[] f = new boolean[m + 1];

        f[0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[j] = f[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    f[j] = f[j] || (f[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[m];
    }
}
