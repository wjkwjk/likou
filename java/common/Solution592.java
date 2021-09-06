package common;

/**
 * 592. 分数加减运算
 * 给定一个表示分数加减运算表达式的字符串，你需要返回一个字符串形式的计算结果。
 * 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，
 * 例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
 */
public class Solution592 {

    private static int cal(int a, int b){    //计算公倍数
        for (int i=1;i<=a;i++){
            if (i * b % a == 0) return i * b;
        }
        return a * b;
    }

    private static String f(int a, int b){     //分子分母进行约分
        StringBuilder r = new StringBuilder();
        for (int i=Math.min(a,b);i>=1;i--){
            if (a%i == 0 && b%i == 0){
                r.append(a/i);
                r.append("/");
                r.append(b/i);
                break;
            }
        }
        return r.toString();
    }

    public static String fractionAddition(String expression) {
        if (expression.charAt(0) != '+' && expression.charAt(0) != '-') expression = "+" + expression;
        int up = 0, down = 1;
        StringBuilder s = new StringBuilder();
        int f = 0;
        if (expression.charAt(0) == '+')    f=1;
        expression = expression + "+";
        for (int i=1;i<expression.length();i++){
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-'){
                int upt = Integer.parseInt(s.toString().split("/")[0]);
                int downt = Integer.parseInt(s.toString().split("/")[1]);
                int pub = cal(down, downt);
                if (f == 1) up = up * pub / down + upt * pub / downt;
                else up = up * pub / down - upt * pub / downt;
                down = pub;
                s = new StringBuilder();
                if (expression.charAt(i) == '+') f=1;
                if (expression.charAt(i) == '-') f=0;
            }
            else s.append(expression.charAt(i));
        }
        if (up == 0){
            return "0/1";
        }
        StringBuilder r = new StringBuilder();
        if (up < 0) r.append("-");
        r.append(f(Math.abs(up), down));
        return r.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionAddition("5/3+1/3"));
    }
}
