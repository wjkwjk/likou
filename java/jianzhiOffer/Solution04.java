package jianzhiOffer;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

/**
 * 使用递归做，每次遍历对角线，找到target所在的子块，然后在子块内递归查找对角线
 * 更快的做法，将矩阵旋转45度，此时就可以将矩阵看成二分排序树，按照二分排序树的查找规则进行查找即可
 */
public class Solution04 {

    public boolean find(int[][] matrix, int target, int leftw, int lefth, int rightw, int righth){
        if (rightw-leftw<0 || righth-lefth<0)   return false;
        int i=lefth,j=leftw;
        for(;i<=righth&&j<=rightw;i++,j++){
            if (target==matrix[i][j])   return true;
            if (target<matrix[i][j]){
                break;
            }
        }
        if (find(matrix, target, leftw, i, j-1, righth) || find(matrix, target, j, lefth, rightw, i-1)) return true;
        return false;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length==0)   return false;
        return find(matrix,target,0,0,matrix[0].length-1,matrix.length-1);
    }


}
