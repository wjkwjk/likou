package common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 */
public class Solution994 {
    public int orangesRotting(int[][] grid) {
        int allorange = 0;
        Queue<int[]> Q = new LinkedList<>();
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if (grid[i][j] == 2)    Q.offer(new int[]{i,j});
                if (grid[i][j] != 0)    allorange++;
            }
        }
        int n = Q.size();
        int time = -1;
        while (!Q.isEmpty()){
            int[] p = Q.poll();
            allorange--;
            n--;
            if (p[0] > 0 && grid[p[0]-1][p[1]]==1){
                grid[p[0]-1][p[1]] = 2;
                Q.offer(new int[]{p[0]-1, p[1]});
            }
            if (p[0] < grid.length-1 && grid[p[0]+1][p[1]]==1){
                grid[p[0]+1][p[1]] = 2;
                Q.offer(new int[]{p[0]+1, p[1]});
            }
            if (p[1] > 0 && grid[p[0]][p[1]-1]==1){
                grid[p[0]][p[1]-1] = 2;
                Q.offer(new int[]{p[0], p[1]-1});
            }
            if (p[1] < grid[p[0]].length-1 && grid[p[0]][p[1]+1]==1){
                grid[p[0]][p[1]+1] = 2;
                Q.offer(new int[]{p[0], p[1]+1});
            }
            if (n==0){
                n = Q.size();
                time++;
            }
        }
        if (allorange == 0 && time == -1) return 0;
        else if (allorange == 0)  return time;
        return -1;
    }
}
