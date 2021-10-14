package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 802. 找到最终的安全状态
 * 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
 *
 * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
 *
 * 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 *
 * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
 */
public class Solution802 {

    private boolean dfs(int[][] graph, int[] visited, int start){
        visited[start] = 1;
        for (int i=0;i<graph[start].length;i++){
            if (visited[graph[start][i]] == 0){
                visited[graph[start][i]] = 1;
                if (!dfs(graph, visited, graph[start][i]))  return false;
                visited[graph[start][i]] = 0;
            }else return false;
        }
        return true;
    }

    //暴力，对每个节点使用dfs,判断是否有回路
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> r = new ArrayList<>();
        int[] visited = new int[graph.length];
        for (int i=0;i<graph.length;i++){
            Arrays.fill(visited, 0);
            if (dfs(graph, visited, i)) r.add(i);
        }
        return r;
    }

    /************************************************************************ */

    //时间复杂为O(n)，即每次以当前开始做DFS，然后将遍历的到的所有点都进行标记，标记为1该顶点不是安全点，标记为-1表示该节点为安全点，标记为0表示该节点还未遍历
    //遍历时，首先将当前节点标记为1，此时的作用表示该节点位于当前DFS的路径上，如果当前节点相连的其他所有节点都为安全节点，则再将当前节点标记为-1
    private boolean dfs2(int[][] graph, int[] visited, int start){
        if (visited[start] == 1)   return false;
        if (visited[start] == -1)   return true;
        visited[start] = 1;
        for (int i=0;i<graph[start].length;i++){
            if (visited[graph[start][i]] == 0){
                if (!dfs2(graph, visited, graph[start][i])) return false;
            }else if (visited[graph[start][i]] == 1)    return false;
        }
        visited[start] = -1;
        return true;
    }

    public List<Integer> eventualSafeNodes2(int[][] graph) {
        List<Integer> r = new ArrayList<>();
        int[] visited = new int[graph.length];
        for (int i=0;i<graph.length;i++){
            if (dfs2(graph, visited, i))    r.add(i);
        }
        return r;
    }

}
