package common;

import java.util.*;

/**
 * 652. 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 */
public class Solution652 {

    private String preTree(TreeNode root, Map<String, Integer> map, List<TreeNode> list){
        if (root != null){
            String s = root.val + "/" + preTree(root.left, map, list) + "/" +preTree(root.right, map, list);
            if (map.containsKey(s)){
                if (map.get(s) == 1){
                    list.add(root);
                    map.put(s, 2);
                }
            }
            else map.put(s, 1);
            return s;
        }
        return "#";
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        preTree(root, map, list);
        return list;
    }

    class TreeNode {
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
