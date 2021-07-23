package jianzhiOffer;


import java.util.ArrayList;

public class Solution26 {

    boolean pre_traversal(TreeNode A, TreeNode B){
        if (A!=null){
            if (A.val == B.val){
                if (pre_traversal2(A,B))    return true;
            }
            boolean l = pre_traversal(A.left, B);
            if (l)  return true;
            return pre_traversal(A.right, B);
        }
        return false;
    }

    Boolean pre_traversal2(TreeNode A_B, TreeNode B){
        if (A_B!=null && B!=null){
            if (A_B.val != B.val)   return false;
            boolean l = pre_traversal2(A_B.left, B.left);
            if (!l) return false;
            boolean r = pre_traversal2(A_B.right, B.right);
            if (!r) return false;
        }
        else if (A_B==null && B==null)  return true;
        else if (A_B == null && B!=null)    return false;
        return true;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B==null) return false;
        return pre_traversal(A, B);
    }
}
