package common;

import java.util.*;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */

public class Solution36 {

    private ArrayList<TreeNode> convertArr(LinkedList<TreeNode> S){
        ArrayList<TreeNode> list = new ArrayList<>();
        for (int i=0; i<S.size(); i++){
            list.add(S.get(i));
        }
        return list;
    }

    private TreeNode postorder(TreeNode root, TreeNode s, TreeNode t){
        LinkedList<TreeNode> S = new LinkedList<>();
        TreeNode p = root;
        TreeNode r = null;
        ArrayList< ArrayList<TreeNode>> list = new ArrayList<>();
        while (p!=null || S.size()!=0){
            if (p!=null){
                S.addLast(p);
                p = p.left;
            }
            else{
                p = S.getLast();
                if (p.right!=null && p.right!=r){
                    p = p.right;
                    S.addLast(p);
                    p = p.left;
                }
                else{
                    if (S.getLast() == s || S.getLast() == t){
                        list.add(convertArr(S));
                    }
                    p = S.removeLast();
                    r = p;
                    p = null;
                }
            }
        }
        ArrayList<TreeNode> x = list.get(0);
        ArrayList<TreeNode> y = list.get(1);
        for (int i=0;i<x.size()&&i<y.size();i++){
            if (x.get(i) != y.get(i))   return x.get(i-1);
        }
        if (x.size()<=y.size()) return x.get(x.size()-1);
        else return y.get(y.size()-1);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return postorder(root, p, q);
    }
}
