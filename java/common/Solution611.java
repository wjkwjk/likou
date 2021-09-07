package common;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 */
public class Solution611 {

    private boolean isTriangle(int a, int b, int c){
        return a+b>c;
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.print(num);
            System.out.print(" ");
        }
        int s = 0;
        for (int i=0;i<nums.length-2;i++){
            for (int l=i+1,h=nums.length-1;l<h;){
                if (isTriangle(nums[i], nums[l], nums[h])){
                    s += (h - l + 1) * (h - l) / 2;
                    break;
                }else{
                    for (int k = l+1;k<h;k++){
                        if (isTriangle(nums[i], nums[l], nums[k]))  s++;
                    }
                    for (int k = h-1;k>l;k--){
                        if (isTriangle(nums[i], nums[k], nums[h]))  s++;
                    }
                    l++;
                    h--;
                }
            }
        }
        return s;
    }

    public int triangleNumber2(int[] nums){
        Arrays.sort(nums);
        int s = 0;
        for (int i=0;i<nums.length-2;i++){
            int h = i + 1;
            for (int l = i + 1;l<nums.length-1;l++){
                while (h+1<nums.length && isTriangle(nums[i], nums[l], nums[h+1]))    h++;
                s += Math.max(h - l, 0);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Solution611 s = new Solution611();
        System.out.println(s.triangleNumber2(new int[]{48,66,61,46,94,75}));
    }
}
