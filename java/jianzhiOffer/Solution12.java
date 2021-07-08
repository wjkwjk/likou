package jianzhiOffer;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Solution12 {

    public boolean exist_single(char[][] board, boolean[][] visited, String word, int starth, int startw, int n){
        if (n==word.length()-1)   return true;
        boolean r = false;
        if (starth>0 && !visited[starth-1][startw] && board[starth-1][startw]==word.charAt(n+1)){
            visited[starth][startw] = true;
            r = r || exist_single(board, visited, word, starth-1, startw, n+1);
            visited[starth][startw] = false;
            if (r)  return true;
        }
        if (starth<board.length-1 && !visited[starth+1][startw] && board[starth+1][startw]==word.charAt(n+1)){
            visited[starth][startw] = true;
            r = r || exist_single(board, visited, word, starth+1, startw, n+1);
            visited[starth][startw] = false;
            if (r)  return true;
        }
        if (startw>0 && !visited[starth][startw-1] && board[starth][startw-1]==word.charAt(n+1)){
            visited[starth][startw] = true;
            r = r || exist_single(board, visited, word, starth, startw-1, n+1);
            visited[starth][startw] = false;
            if (r)  return true;
        }
        if (startw<board[0].length-1 && !visited[starth][startw+1] && board[starth][startw+1]==word.charAt(n+1)){
            visited[starth][startw] = true;
            r = r || exist_single(board, visited, word, starth, startw+1, n+1);
            visited[starth][startw] = false;
            if (r)  return true;
        }
        return r;
    }

    public boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i=0;i<h;i++){
            for (int j=0;j<w;j++){
                visited[i][j] = false;
            }
        }
        int start = 0;
        for (int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                if (board[i][j] == word.charAt(0))
                    if (exist_single(board, visited, word, i, j, start))
                        return true;
            }
        }
        return false;
    }
}
