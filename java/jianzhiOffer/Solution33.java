package jianzhiOffer;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class Solution33 {

    /**
     * 基于暴力循环
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        for (int i=postorder.length-1;i>0;i--){
            int flag=0;
            for (int j = i-1;j>=0;j--){
                if (flag==1 && postorder[j]>=postorder[i])  return false;
                if (postorder[j]<postorder[i]){
                    flag=1;
                }
            }
        }
        return true;
    }

    /**
     * 基于递归分治
     * @param start
     * @param end
     * @param postorder
     * @return
     */
    boolean dfs(int start, int end, int[] postorder){
        if (start>=end) return true;
        int mid = start+1;
        int flag=0;
        for (int i=start; i<end; i++){
            if (flag==1 && postorder[i]<=postorder[end])  return false;
            if (postorder[i]>=postorder[end] && flag==0){
                flag=1;
                mid = i;
            }
        }
        if (flag==0)    mid = end;
        return dfs(start, mid-1, postorder) && dfs(mid, end-1, postorder);

    }

    public boolean verifyPostorder2(int[] postorder) {
        return dfs(0, postorder.length-1, postorder);
    }

    public static void main(String[] args) {
        int[] postorder = new int[]{4, 8, 6, 12, 16, 14, 10};
        Solution33 s = new Solution33();
        System.out.println(s.verifyPostorder2(postorder));
        System.out.println();
    }
}
