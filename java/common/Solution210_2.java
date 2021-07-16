package common;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 210. 课程表 II
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 */

public class Solution210_2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] Q = new LinkedList<Integer>[numCourses];
        int[] result = new int[numCourses];
        int t = 0;
        ArrayList<LinkedList<Integer>> L = new ArrayList<>(numCourses);
        ArrayList<Integer> toDegree = new ArrayList<>(numCourses);
        for (int i=0;i<prerequisites.length;i++){
            toDegree.set(prerequisites[i][0], toDegree.get(prerequisites[i][0])+1);
            L.get(prerequisites[i][1]).addLast(prerequisites[i][0]);
        }

        for (int i=0; i<numCourses; i++){
            for (int j=0; j<numCourses; i++){
                if (toDegree.get(j) == 0){
                    for (int k=0;k<L.get(j).size();k++){
                        toDegree.set(k, toDegree.get(L.get(j).get(k))-1);
                    }
                    toDegree.set(j, -1);
                    result[t++] = j;
                }
            }
        }
        int[] x = new int[0];
        if (t != numCourses)    return x;
        return result;
    }

}
