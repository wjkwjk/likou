package jianzhiOffer;

public class Solution07 {
    /**
     * 剑指 Offer 07. 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     */

    public TreeNode getTree(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend){
        if (preend<prestart || inend< instart)    return null;
        TreeNode node = new TreeNode(preorder[prestart]);
        for(int i=instart;i<=inend;i++){
            if (inorder[i]==preorder[prestart]){
                node.left = getTree(preorder, inorder, prestart+1,i-instart+prestart,instart,i-1);
                node.right = getTree(preorder, inorder, i-instart+prestart+1, inend-instart+prestart, i+1, inend);
                break;
            }
        }
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return getTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
