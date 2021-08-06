package common;

/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 */


import java.util.Stack;

/**
 * 使用单调栈
 */
public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> S = new Stack<>();
        int[] result = new int[nums.length];
        int flag = 0;
        for (int i=0;i<nums.length;i++){
            if (S.empty() && flag == 0){
                S.push(i);
            }else {
                while (!S.empty()){
                    if (nums[i] > nums[S.peek()]){
                        result[S.pop()] = nums[i];
                    }else {
                        if (flag == 0) S.push(i);
                        break;
                    }
                }
                if (S.empty() && flag == 0)  S.push(i);
            }
            if (flag == 0 && i == nums.length - 1){
                i = -1;
                flag = 1;
            }
        }
        while (!S.empty())  result[S.pop()] = -1;
        return result;
    }
}
