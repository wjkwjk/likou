package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 210. 课程表 II
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 */

public class Solution210_2 {

    //使用toDegree数组，每次找到入度为0的元素
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] toDegree = new int[numCourses];
        HashMap<Integer, LinkedList<Integer>> G = new HashMap<>();
        for (int i=0;i<prerequisites.length;i++){
            toDegree[prerequisites[i][0]]++;
            if (!G.containsKey(prerequisites[i][1]))    G.put(prerequisites[i][1], new LinkedList<>());
            G.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int index = 0;
        int[] result = new int[numCourses];

        for (int i=0;i<numCourses;i++){
            int j = 0;
            for (;j<toDegree.length;j++){
                if (toDegree[j]==0){
                    result[index++] = j;
                    toDegree[j] = -1;
                    break;
                }
            }
            if (j==toDegree.length) return new int[0];
            if (G.containsKey(j)){
                for (int k=0;k<G.get(j).size();k++){
                    toDegree[G.get(j).get(k)]--;
                }
            }

        }
        return result;
    }

    //使用DFS
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        int[] toDegree = new int[numCourses];
        HashMap<Integer, LinkedList<Integer>> G = new HashMap<>();
        for (int i=0;i<prerequisites.length;i++){
            toDegree[prerequisites[i][0]]++;
            if (!G.containsKey(prerequisites[i][1]))    G.put(prerequisites[i][1], new LinkedList<>());
            G.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int index = 0;
        int[] result = new int[numCourses];

        for (int i=0;i<numCourses;i++){
            int j = 0;
            for (;j<toDegree.length;j++){
                if (toDegree[j]==0){
                    result[index++] = j;
                    toDegree[j] = -1;
                    break;
                }
            }
            if (j==toDegree.length) return new int[0];
            if (G.containsKey(j)){
                for (int k=0;k<G.get(j).size();k++){
                    toDegree[G.get(j).get(k)]--;
                }
            }

        }
        return result;
    }

    void dfs(HashMap<Integer, LinkedList<Integer>> G, int[] toDegree, int start){

    }


}
