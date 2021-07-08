package jianzhiOffer;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */

class Binary_Search_Node{
    public int val;
    public Binary_Search_Node left;
    public Binary_Search_Node right;

    public Binary_Search_Node() {}

    public Binary_Search_Node(int _val) {
        val = _val;
    }

    public Binary_Search_Node(int _val,Binary_Search_Node _left,Binary_Search_Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}


public class Solution36 {


    Binary_Search_Node get_two_way_list(Binary_Search_Node root){
        if (root!=null){
            Binary_Search_Node small = get_two_way_list(root.left);
            Binary_Search_Node big = get_two_way_list(root.right);
            if (small==null){
                small = root;
            }
            else{
                root.left = small.left;
                small.left.right = root;
            }
            if (big==null){
                big = root;
                big.right = small;
                small.left = big;
            }
            else{
                root.right = big;
                small.left = big.left;
                big.left.right = small;
                big.left = root;
            }
            return small;
        }
        return null;
    }

    public Binary_Search_Node treeToDoublyList(Binary_Search_Node root) {
        return get_two_way_list(root);
    }
}
