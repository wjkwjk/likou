package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 658. 找到 K 个最接近的元素
 * 给定一个排序好的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 *
 * 整数 a 比整数 b 更接近 x 需要满足：
 *
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 */
public class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = -1,r = arr.length;
        int[] re = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            if (x == arr[i]){
                l = i - 1;
                r = i + 1;
                if (k-- > 0)   re[i] = 1;
                break;
            }
            else if (x > arr[i])    l = i;
            else {
                r = i;
                break;
            }
        }

        for (;k>0;k--){
            if (l>=0 && r<arr.length){
                if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)){
                    re[l] = 1;
                    l--;
                }else {
                    re[r] = 1;
                    r++;
                }
            }
            else if (l<0 && r<arr.length){
                re[r] = 1;
                r++;
            }
            else if (r>=arr.length && l>=0){
                re[l] = 1;
                l--;
            }
            else break;

        }
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            if (re[i] == 1) list.add(arr[i]);
        }
        return list;
    }
}
