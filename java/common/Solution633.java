package common;

public class Solution633 {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2147483600));
    }

    public static boolean judgeSquareSum(int c) {
        for (int i=0,j=(int) Math.sqrt(c),t;i<=j;){
            if ((t = (i*i + j*j)) == c) return true;
            else if (t > c || t < 0) j--;     //当两数相加大于int最大值时，结果为负数
            else i++;
        }
        return false;
    }

}
