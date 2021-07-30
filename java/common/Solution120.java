package common;

import com.sun.javafx.collections.MappingChange;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */

public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i=1;i<triangle.size();i++){
            for (int j=0;j<triangle.get(i).size();j++){
                int a = j-1>=0 ? triangle.get(i-1).get(j-1) : Integer.MAX_VALUE;
                int b = j<triangle.get(i-1).size() ? triangle.get(i-1).get(j) : Integer.MAX_VALUE;
                triangle.get(i).set(j, Math.min(a,b) + triangle.get(i).get(j));
            }
        }
        int r = Integer.MAX_VALUE;
        for (int i=0;i<triangle.get(triangle.size()-1).size();i++){
            r = Math.min(r, triangle.get(triangle.size()-1).get(i));
        }
        return r;
    }
}
