package common;

import java.util.*;

/**
 * 365. 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 */
public class Solution365 {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Queue<int[]> Q = new LinkedList<>();
        HashSet<Long> Set = new HashSet<>();
        int[] t = new int[]{0, 0};
        Q.offer(t);
        while (!Q.isEmpty()){
            int[] p = Q.poll();
            if (Set.contains(hash(p)))  continue;
            Set.add(hash(p));
            int remain1 = p[0];
            int remain2 = p[1];
            if (remain1==targetCapacity || remain2==targetCapacity || remain2+remain1==targetCapacity){
                return true;
            }
            Q.offer(new int[]{jug1Capacity, remain2});
            Q.offer(new int[]{remain1, jug2Capacity});
            Q.offer(new int[]{0, remain2});
            Q.offer(new int[]{remain1, 0});
            if (remain1 <= (jug2Capacity - remain2)){
                Q.offer(new int[]{0, remain2 + remain1});
            }else {
                Q.offer(new int[]{remain1 - (jug2Capacity - remain2), jug2Capacity});
            }
            if (remain2 <= (jug1Capacity - remain1)){
                Q.offer(new int[]{remain2 + remain1, 0});
            }else {
                Q.offer(new int[]{jug1Capacity, remain2 - (jug1Capacity - remain1)});
            }
        }
        return false;
    }

    long hash(int[] p){
        return (long) p[0] * 1000001 + p[1];
    }

}
