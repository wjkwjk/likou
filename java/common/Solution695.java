package common;

/**
 * 695. 岛屿的最大面积
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 *
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 */
public class Solution695 {

    private int dfs(int[][] grid, int[][] visited, int x, int y){
        int sum = 0;
        if (visited[x][y] == 1 || grid[x][y] == 0)  return sum;
        visited[x][y] = 1;
        if (x > 0)  sum += dfs(grid, visited, x-1, y);
        if (x < grid.length-1) sum += dfs(grid, visited, x+1, y);
        if (y > 0) sum += dfs(grid, visited, x, y-1);
        if (y < grid[x].length-1)   sum += dfs(grid, visited, x, y+1);
        return sum + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxv = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                maxv = Math.max(maxv, dfs(grid, visited, i, j));
            }
        }
        return maxv;
    }
}
