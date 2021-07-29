package common;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 1514. 概率最大的路径
 * 给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，其中 edges[i] = [a, b] 表示连接节点 a 和 b 的一条无向边，且该边遍历成功的概率为 succProb[i] 。
 *
 * 指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。
 *
 * 如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。
 */

public class Solution1514 {

    class Node{
        int anotherNode;
        double prob;

        public Node(int anotherNode, double prob) {
            this.anotherNode = anotherNode;
            this.prob = prob;
        }
    }

    class Graph{
        LinkedList<Node> nodes = new LinkedList<>();
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Graph[] graph = new Graph[n];
        for (int i=0;i<graph.length;i++)    graph[i] = new Graph();
        for (int i=0; i<succProb.length; i++){
            graph[edges[i][0]].nodes.add(new Node(edges[i][1], succProb[i]));
            graph[edges[i][1]].nodes.add(new Node(edges[i][0], succProb[i]));
        }
        return dijkstra(start, end, graph);
    }

    public double dijkstra(int start, int end, Graph[] graph){
        int nowstart = start;
        double[] lengths = new double[graph.length];
        int[] visited = new int[graph.length];
        lengths[nowstart] = 1;
        for (int i=0;i<graph.length;i++){
            visited[nowstart] = 1;
            for (int j=0; j<graph[nowstart].nodes.size(); j++){
                if (visited[graph[nowstart].nodes.get(j).anotherNode] == 0){
                    if (lengths[nowstart] * graph[nowstart].nodes.get(j).prob > lengths[graph[nowstart].nodes.get(j).anotherNode]){
                        lengths[graph[nowstart].nodes.get(j).anotherNode] = lengths[nowstart] * graph[nowstart].nodes.get(j).prob;
                    }
                }
            }
            double maxl = Double.MIN_VALUE;
            int maxi = -1;
            for (int j=0;j<lengths.length;j++){
                if (visited[j] == 0){
                    if (lengths[j] != 0 && lengths[j] > maxl){
                        maxl = lengths[j];
                        maxi = j;
                    }
                }
            }
            if (maxi == -1) break;
            nowstart = maxi;
        }

        return lengths[end];

    }

}
