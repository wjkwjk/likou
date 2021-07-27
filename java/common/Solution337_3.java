package common;

import java.util.*;

/**
 * 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 */
public class Solution337_3 {
    /**
     * 使用递归，超时
     * @param root
     * @return
     */
    public int getChildSum(TreeNode root){
        if (root!=null){
            int l = root.left!=null ? getChildSum(root.left.left)+getChildSum(root.left.right) : 0;
            int r = root.right!=null ? getChildSum(root.right.left)+getChildSum(root.right.right) : 0;
            int r1 = l + r + root.val;

            l = root.left!=null ? getChildSum(root.left) : 0;
            r = root.right!=null ? getChildSum(root.right) : 0;
            int r2 = l + r;

            return Math.max(r1, r2);
        }
        return 0;
    }

    public int rob(TreeNode root) {
        return getChildSum(root);
    }

    public int rob2(TreeNode root) {
        int result = 0;
        HashMap<TreeNode, parent> map = new HashMap<>();
        parent pa = new parent(null, -1);
        map.put(root, pa);
        map.put(null, pa);
        Queue<TreeNode> Q = new LinkedList<>();
        preorder(root, map, Q);


        while (!Q.isEmpty()){
            TreeNode p = Q.poll();
            if(p==null) continue;
            TreeNode p_parent = map.get(p).parentNode;
            if(map.get(p_parent).sum==-1 && p_parent!=null){
                Q.offer(p_parent);
                map.get(p_parent).sum = 0;
            }
            int r1 = 0;
            r1 += p.val;
            if (p.left!=null)    r1 += map.get(p.left.left).sum + map.get(p.left.right).sum;
            if (p.right!=null)   r1 += map.get(p.right.left).sum + map.get(p.right.right).sum;
            int r2 = 0;
            r2 += map.get(p.left).sum + map.get(p.right).sum;
            map.get(p).sum = Math.max(r1, r2);
            result = Math.max(map.get(p).sum, result);
        }
        return result;
    }

    class parent{
        public TreeNode parentNode;
        public int sum;

        public parent(TreeNode parentNode, int sum) {
            this.parentNode = parentNode;
            this.sum = sum;
        }
    }

    void preorder(TreeNode root, Map<TreeNode, parent> map, Queue<TreeNode> Q){
        if (root!=null){
            parent p = new parent(root, -1);
            if (root.left!=null)    map.put(root.left, p);
            if (root.right!=null)   map.put(root.right, p);
            if (root.left==null && root.right==null){
                Q.offer(root);
                map.get(root).sum = 0;
            }
            preorder(root.left, map, Q);
            preorder(root.right, map, Q);
        }
    }

    public static void main(String[] args) {
        Solution337_3 s = new Solution337_3();
        TreeNode a = new TreeNode(3,null,null);
        TreeNode b = new TreeNode(2,null,a);
        TreeNode c = new TreeNode(1,null,null);
        TreeNode d = new TreeNode(3,null,c);
        TreeNode e = new TreeNode(3,b,d);
        s.rob2(e);
    }
}
