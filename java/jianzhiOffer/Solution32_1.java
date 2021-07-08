package jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution32_1 {
    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> vals = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode thislevelend = root;
        TreeNode nextlevelend = null;
        TreeNode t = null;
        while (!queue.isEmpty() && queue.peek()!=null){
            t = queue.poll();
            vals.add(t.val);
            if (t.left!=null){
                queue.offer(t.left);
                nextlevelend = t.left;
            }
            if (t.right!=null)   {
                queue.offer(t.right);
                nextlevelend = t.right;
            }
            if (t == thislevelend)  thislevelend = nextlevelend;
        }
        return vals.stream().mapToInt(Integer::intValue).toArray();
    }
}

