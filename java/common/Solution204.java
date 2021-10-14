package common;

/**
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 */
public class Solution204 {
    /**
     * 暴力枚举，列出每个数，然后判断是否是质数
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int sum = 0;
        int flag;
        for (int i=2;i<n;i++){
            flag = 1;
            for (int j=2;j<=(int)Math.sqrt(i);j++){
                if (i % j == 0){
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)  sum++;
        }
        return sum;
    }

    /**
     * 若当前为x，那么x的整数倍都不是质数，因此，将visited[2x],visited[3x],...都置为1，表示非质数
     * 如果遍历的x对应的visited[x]=0，表示没有不存在小于x的数，使得其倍数为x，也就是x为质数
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        int[] visited = new int[n];
        int sum = 0;
        for (int i=2;i<n;i++){
            if (visited[i] == 0)    sum++;
            else continue;
            for (int j=2;i*j<n;j++){
                visited[i*j] = 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution204 s = new Solution204();
        s.countPrimes2(10);
    }
}
