package common;

import java.util.ArrayList;
import java.util.List;

public class SplitNumber {
    public static void main(String[] args) {
        for (Integer integer : splitNumber(123)) {
            System.out.println(integer);
        }
    }

    static List<Integer> splitNumber(int num){
        List<Integer> list = new ArrayList<>();
        if (num == 0){
            list.add(num);
            return list;
        }
        while (num > 0){
            list.add(num - num / 10 * 10);
            num /= 10;
        }
        return list;
    }
}
