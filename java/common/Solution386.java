package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

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
     * 将字典序抽象为一棵树, 十叉树
     * @return
     */

    public void preorder(int[] TenTree, int root, List<Integer> L, String str){
        str += Integer.toString(TenTree[root]);
        if (root * 10 >= TenTree.length){
            L.add(Integer.parseInt(str));
        }
        for (int i=0;i<10 && root*10+i<TenTree.length;i++){
            preorder(TenTree, root*10+i, L, str);
        }
    }

    public List<Integer> lexicalOrder2(int n) {

        int[] TenTree = new int[n+2];

        int x = 0;
        for (int i=1;i<TenTree.length;i++){
            if (i<11){
                TenTree[i] = i - 1;
            }
            else{
                TenTree[i] = x;
                x = x==9 ? 0 : x+1;
            }
        }
        return null;
    }

}
