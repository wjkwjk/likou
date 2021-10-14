package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 */
public class Solution670 {

    public int maximumSwap(int num) {
        List<Integer> nums = new ArrayList<>();
        List<Integer> numscopy = new ArrayList<>();
        while (num > 0){
            nums.add(num - num / 10 * 10);
            numscopy.add(num - num / 10 * 10);
            num /= 10;
        }
        Collections.sort(nums);
        Collections.reverse(nums);
        Collections.reverse(numscopy);
        for (int i=0;i<nums.size();i++){
            if (nums.get(i).equals(numscopy.get(i))) continue;
            for (int j=numscopy.size()-1;j>=0;j--){
                if (numscopy.get(j).equals(nums.get(i))){
                    int t = numscopy.get(i);
                    numscopy.set(i, numscopy.get(j));
                    numscopy.set(j, t);
                    break;
                }
            }
            break;
        }
        int r = 0;
        for (int i=0;i<numscopy.size();i++){
            r += numscopy.get(i) * Math.pow(10, numscopy.size() - 1 - i);
        }
        return r;
    }

    public static void main(String[] args) {
        Solution670 s = new Solution670();
        System.out.println(s.maximumSwap(123));
    }

}
