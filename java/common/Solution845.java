package common;

import java.util.Map;

/**
 * 845. 数组中的最长山脉
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 */
public class Solution845 {

    /**
     * 思路就是在数组中寻找先升序再降序的子数组
     * 使用flag表示当前正在寻找的是升序还是降序
     * @param arr
     * @return
     */

    public int longestMountain(int[] arr) {
        int flag = 1;
        int start = 0;
        int mid = 0;
        int maxlen = 0;
        for (int i=0;i<arr.length-1;i++){
            if (flag == 1){    //正在寻找升序
                if (arr[i+1] < arr[i]){ //如果后一个数小于当前数
                    if (i <= start){ //因为数组长度必须要大于等于3，防止出现子数组整个为升序或者降序
                        start = i+1;
                        continue;
                    }
                    mid = i;
                    flag = 0;
                }else if (arr[i+1] == arr[i])   start = i+1;
            }else { //正在寻找降序
                if (arr[i+1] >= arr[i]){
                    if (i > mid)    maxlen = Math.max(maxlen, i - start + 1);
                    start = i--;
                    flag = 1;
                }
            }
        }
        if (mid > start && mid < arr.length - 1)    maxlen = Math.max(maxlen, arr.length - start);
        return maxlen;
    }
}
