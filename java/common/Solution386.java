package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 386. 字典序排数
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 *
 * 例如，
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 *
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 */
public class Solution386 {

    /**
     * 使用java自带的Arrays.sort进行排序
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder(int n) {
        String[] S = new String[n];
        for (int i=1;i<=n;i++){
            S[i-1] = Integer.toString(i);
        }
        Arrays.sort(S);
        ArrayList<Integer> L = new ArrayList<>();
        for (int i=0;i<S.length;i++)    L.add(Integer.parseInt(S[i]));
        return L;
    }

    /**
     * 将字典序抽象为一棵树
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder2(int n) {
        int[] tree = new int[n+1];
        
    }

}
