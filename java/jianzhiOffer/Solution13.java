package jianzhiOffer;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */

public class Solution13 {

    public boolean isK(int x, int y, int k){
        int sum = 0;
        String xs = Integer.toString(x);
        for (int i = 0; i < xs.length(); i++){
            sum += (xs.charAt(i) - '0');
        }

        String ys = Integer.toString(y);
        for (int i = 0; i < ys.length(); i++){
            sum += (ys.charAt(i) - '0');
        }
        return sum <= k;
    }

    int dfs(int[][] M, int startX, int startY, int[][] visited ){
        int t = 0;
        if (startX < M.length && startX >= 0 && startY >= 0 && startY < M[0].length &&
                M[startX][startY] == 1 && visited[startX][startY] == 0){
            visited[startX][startY] = 1;
            t += 1;
            t += dfs(M, startX+1, startY, visited);
            t += dfs(M, startX-1, startY, visited);
            t += dfs(M, startX, startY+1, visited);
            t += dfs(M, startX, startY-1, visited);
        }
        return t;
    }

    public int movingCount(int m, int n, int k) {
        int[][] M = new int[m][n];
        int sum  = 0;
        for (int i = 0; i < M.length; i++){
            for (int j = 0; j < M[i].length; j++){
                if (isK(i, j, k))   M[i][j] = 1;
            }
        }
        int[][] visited = new int[m][n];
        return dfs(M, 0, 0, visited);

    }

}
