package common;

import java.util.ArrayList;

/**
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 *
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 */
public class Solution654 {

    private TreeNode createTree(int[] nums, int start, int end){
        if (start > end)    return null;
        int max = nums[start];
        int index = start;
        for (int i=start+1;i<=end;i++){
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = createTree(nums, start, index - 1);
        root.right = createTree(nums, index + 1, end);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
