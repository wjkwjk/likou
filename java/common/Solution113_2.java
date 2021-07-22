package common;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 */


/**
 * 注意：
 * 泛型踩坑：
 *  Integer，Double继承于Number
 *  但是ArrayList<Integer>，ArrayList<Double>与ArrayList<Number>是并列关系，因此不能用ArrayList<Integer>返回ArrayList<Number>
 *
 * 本题中，返回类型为List<List<Integer>>，因此不能用ArrayList<ArrayList<Integer>>返回，而要用ArrayList<List<Integer>>返回
 * 总结，泛型中的类型不影响继承关系，继承关系只看原始类型，如果原始类型存在继承关系，同时泛型类型相同（存在继承关系也没用），才会使得整个类型存在继承关系
 */

public class Solution113_2 {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode() {
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    void preorder(TreeNode root, int nowSum, int targetSum, ArrayList<Integer> L, ArrayList<List<Integer>> r){
        if (root != null){
            L.add(root.val);
            if (root.left==null && root.right==null && nowSum+root.val==targetSum){
                ArrayList<Integer> newL = new ArrayList<>();
                for (int i=0;i<L.size();i++){
                    newL.add(L.get(i));
                }
                r.add(newL);
            }
            preorder(root.left, nowSum+root.val, targetSum, L, r);
            preorder(root.right, nowSum+root.val, targetSum, L, r);
            L.remove(L.size()-1);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<List<Integer>> r = new ArrayList<>();
        preorder(root, 0, targetSum, new ArrayList<Integer>(), r);
        return r;
    }


}
