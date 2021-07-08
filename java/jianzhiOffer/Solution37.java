package jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 */

/**
 * 一个简单的方式：序列化时使用完全二叉树的形式进行序列化
 * 我主要想尝试下如何从力扣的序列化格式中恢复树
 */

public class Solution37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.offer(root);
        String s = "";
        while (!Q.isEmpty()){
            TreeNode p = Q.poll();
            if (p==null){
                if (p==root)    s+="_";
                else    s+=" _";
            }
            else{
                if (p==root)    s = s + Integer.toString(p.val);
                else    s = s + " " + Integer.toString(p.val);
                Q.offer(p.left);
                Q.offer(p.right);
            }
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] node = data.split(" ");
        if (node.length==0 || node[0].equals("_")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(node[0]));
        Queue<TreeNode> last_level = new LinkedList<TreeNode>();
        last_level.offer(root);
        for (int i=1;i<node.length;i+=2) {
            TreeNode left = null, right = null;
            if (!node[i].equals("_")) {
                left = new TreeNode(Integer.parseInt(node[i]));
                last_level.offer(left);
            }
            if (i + 1 < node.length) {
                if (!node[i+1].equals("_")) {
                    right = new TreeNode(Integer.parseInt(node[i + 1]));
                    last_level.offer(right);
                }
            }
            TreeNode p = last_level.poll();
            p.left = left;
            p.right = right;
        }
        return root;
    }
}
