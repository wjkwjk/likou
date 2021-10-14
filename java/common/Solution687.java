package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 687. 最长同值路径
 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。

 注意：两个节点之间的路径长度由它们之间的边数表示。
 */
public class Solution687 {

    public int postorder(TreeNode root, List<Integer> list){
        if (root != null){
            int left = postorder(root.left, list);
            int right = postorder(root.right, list);
            int s = 1;
            int r = 0;
            if (root.left!=null && root.left.val==root.val){
                s+=left;
                r = Math.max(r, left);
            }
            if (root.right!=null && root.right.val==root.val){
                s+=right;
                r = Math.max(r, right);
            }
            if (list.isEmpty()) list.add(s);
            else    list.set(0, Math.max(list.get(0), s));
            return r + 1;
        }
        return 0;
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)   return 0;
        List<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list.get(0);
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
