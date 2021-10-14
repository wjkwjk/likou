package common;

/**
 * 470. 用 Rand7() 实现 Rand10()
 * 已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。
 *
 * 不要使用系统的 Math.random() 方法。
 */
public class Solution470 {

    public int rand7(){
        return 1;
    }

    /**
     * 只要使得使得各个数出现的条件的概率相等即可
     * @return
     */
    public int rand10() {
        int a, b;
        while (true){
            a = rand7();
            b = rand7();
            if (a == 1 && b == 1)   return 1;
            else if (a == 1 && b == 2)  return 2;
            else if (a == 1 && b == 3)  return 3;
            else if (a == 1 && b == 4)  return 4;
            else if (a == 1 && b == 5)  return 5;
            else if (a == 1 && b == 6)  return 6;
            else if (a == 1 && b == 7)  return 7;
            else if (a == 2 && b == 4)  return 8;
            else if (a == 3 && b == 3)  return 9;
            else if (a == 2 && b == 5)  return 10;
        }
    }
}
