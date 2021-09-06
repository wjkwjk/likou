package common;

import java.util.ArrayList;
import java.util.List;

public class Solution593 {

    private Double calLen(int[] vector){
        return Math.sqrt(Math.pow(vector[0], 2) + Math.pow(vector[1], 2));
    }

    private boolean validSingle(int[] p1, int[] p2, int[] p3, int[] p4){
        int[] vector1 = new int[]{p1[0] - p2[0], p1[1] - p2[1]};
        int[] vector2 = new int[]{p3[0] - p4[0], p3[1] - p4[1]};
        double len1 = calLen(vector1);
        double len2 = calLen(vector2);
        if (len1 != len2)   return false;
        double cos = (vector1[0] * vector2[0] + vector1[1] * vector2[1]) / (len1 * len2);
        if (cos != 0)   return false;
        return (p1[0] + p2[0] == p3[0] + p4[0]) && (p1[1] + p2[1] == p3[1] + p4[1]);
    }

    private boolean f(List<int[]> list, int[] visited, List<int[]> r){
        if (r.size() == list.size()){
            return validSingle(r.get(0), r.get(1), r.get(2), r.get(3));
        }
        for (int i=0;i<list.size();i++){
            if (visited[i]==0){
                r.add(list.get(i));
                visited[i] = 1;
                if (f(list, visited, r)) return true;
                visited[i] = 0;
                r.remove(r.size()-1);
            }
        }
        return false;
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<int[]> list = new ArrayList<>();
        list.add(p1);list.add(p2);list.add(p3);list.add(p4);
        int[] visited = new int[4];
        List<int[]> r = new ArrayList<>();
        return f(list, visited, r);
    }
}
