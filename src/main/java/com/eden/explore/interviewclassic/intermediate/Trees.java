package com.eden.explore.interviewclassic.intermediate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 树和图
 * @Author gexx
 * @Date 2020/5/8
 * @Version V1.0
 **/
public class Trees {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @Description: 二叉树的锯齿形层次遍历
     * @Author: gexx
     * @Date: 2020/5/8
     **/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(root, result, 0);
        return result;
    }

    public void traverse(TreeNode root, List<List<Integer>> result, int level) {
        if (root != null) {
            LinkedList<Integer> list;
            if (result.size() <= level) {
                list = new LinkedList<Integer>();
                result.add(list);
            } else {
                list = (LinkedList<Integer>) result.get(level);
            }

            if (level % 2 == 0) {
                list.addLast(root.val);
            } else {
                list.addFirst(root.val);
            }
            traverse(root.left, result, level + 1);
            traverse(root.right, result, level + 1);
        }
    }

    /**
     * @Description: 二叉搜索树中第K小的元素
     * @Author: gexx
     * @Date: 2020/5/8
     **/
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
