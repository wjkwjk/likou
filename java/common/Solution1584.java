package common;

import java.util.ArrayList;
import java.util.List;

/**
 * 1584. 连接所有点的最小费用
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 */

/**
 * prim算法
 */

public class Solution1584 {

    int[] prim(int[][] points, int start){
        int[] length = new int[points.length];
        int[] visited = new int[points.length];

        for (int i=0;i<length.length;i++)   length[i] = Integer.MAX_VALUE;
        length[start] = 0;

        for (int m=0;m<points.length;m++){
            visited[start] = 1;
            for (int i = 0;i<points.length;i++){
                /**
                 * 这里是prim算法和dijkstra算法的唯一区别
                 */
                int len = Math.abs(points[start][0] - points[i][0]) + Math.abs(points[start][1] - points[i][1]);
                if (visited[i] == 0 && len < length[i]){
                    length[i] = len;
                }
            }
            int minlen = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i=0;i<points.length;i++){
                if (visited[i] == 0 && length[i] < minlen){
                    minlen = length[i];
                    minIndex = i;
                }
            }
            if (minIndex == -1) break;
            start = minIndex;
        }
        return length;
    }

    public int minCostConnectPoints(int[][] points) {

        int[] length = prim(points, 0);
        int sum = 0;
        for (int i=0;i<length.length;i++){
            sum += length[i];
        }
        return sum;
    }
}
