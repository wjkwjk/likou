package common;


/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution105 {

    TreeNode buildTreeByPreIn(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend){
        for (int i=instart;i<=inend;i++){
            if (inorder[i] == preorder[prestart]){
                return new TreeNode(preorder[prestart],
                        buildTreeByPreIn(preorder, inorder, prestart+1, prestart+i-instart, instart, i-1),
                        buildTreeByPreIn(preorder, inorder, prestart+i-instart+1, preend, i+1, inend));
            }
        }
        return null;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeByPreIn(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
}
