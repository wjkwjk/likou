package common;

/**
 * 889. 根据前序和后序遍历构造二叉树
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 *
 *  pre 和 post 遍历中的值是不同的正整数。
 */
public class Solution889 {

    /**
     * 关键在于判断先序遍历第一个元素和后续遍历最后一个元素是否相同，如果相同，则说明当前节点只有一个非null子节点，左右任意，这里我都使用了左节点；
     * 如果不同，则说明有两个非null子节点，其中先序遍历第一个元素为左节点，因为先序遍历先遍历左子树根节点；后序遍历最后一个元素为右节点，因为右节点是后续遍历的最后一个元素
     */

    private void createTree(int[] preorder, int[] postorder, int prestart, int preend, int poststart, int postend, TreeNode root){
        if (prestart > preend || poststart > postend)  return;
        root.right = null;
        if (preorder[prestart] == postorder[postend]){
            root.left = new TreeNode(preorder[prestart]);
            createTree(preorder, postorder, prestart+1, preend, poststart, postend-1, root.left);
        }else {
            root.left = new TreeNode(preorder[prestart]);
            root.right = new TreeNode(postorder[postend]);
            int premid = 0, postmid = 0;
            for (int i=prestart;i<=preend;i++){
                if (preorder[i] == postorder[postend]){
                    premid = i;break;
                }
            }
            for (int i=poststart;i<=postend;i++){
                if (postorder[i] == preorder[prestart]){
                    postmid = i;break;
                }
            }
            createTree(preorder, postorder, prestart+1, premid-1, poststart, postmid-1, root.left);
            createTree(preorder, postorder, premid+1, preend, postmid+1, postend-1, root.right);
        }
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[0]);
        createTree(preorder, postorder, 1, preorder.length-1, 0, postorder.length-2, root);
        return root;
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
