package com.eden.explore.datastructure.arrayandstring;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 小结
 * @Author gexx
 * @Date 2020/1/9
 * @Version V1.0
 **/
public class Summary {
    /**
     * @Description: 杨辉三角 II
     * @Param: [rowIndex]
     * @Return: java.util.List<java.lang.Integer>
     * @Author: gexx
     * @Date: 2020/1/8
     **/
    public static List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList<Integer>();
        long nk = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) nk);
            nk = nk * (rowIndex - i) / (i + 1);
        }
        return res;
    }

    /**
     * @Description: 翻转字符串里的单词
     * @Param: [s]
     * @Return: java.lang.String
     * @Author: gexx
     * @Date: 2020/1/9
     **/
    public static String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = split.length - 1; i >= 0; i--) {
            String ss = split[i];
            if (!"".equals(ss)) {
                sb.append(" ").append(ss);
            }
        }
        return sb.toString().trim();
    }
}
