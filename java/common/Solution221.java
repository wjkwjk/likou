package common;

import java.util.Arrays;

/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int[][] right = new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=matrix[i].length-1;j>=0;j--){
                if (matrix[i][j] == '1'){
                    if (j == matrix[i].length-1)    right[i][j] = 1;
                    else    right[i][j] = right[i][j+1] + 1;
                }
            }
        }
        int w, h, len = 0;
        int maxLen = 0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j] == '1'){
                    w = right[i][j]; h = 1;
                    len = 1;
                    for (int k=i+1;k<matrix.length;k++){
                        if (matrix[k][j] == '0')  break;
                        w = Math.min(w, right[k][j]);
                        h++;
                        if (w >= h) len = h;
                        else break;
                    }
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen * maxLen;
    }
}
