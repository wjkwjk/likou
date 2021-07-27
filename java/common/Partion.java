package common;

public class Partion {
    int partion(int low, int high, int[] nums, int privot){
        int l=low, h=high;
        while (l < h){
            while (nums[h] >= nums[privot] && l<h) h--;
            while (nums[l] <= nums[privot] && l<h) l++;
            if (l<h){
                int temp = nums[l];
                nums[l] = nums[h];
                nums[h] = temp;
            }
        }
        int temp = nums[l];
        nums[l] = nums[privot];
        nums[privot] = temp;
        return l;
    }

    public static void main(String[] args) {
        Partion s = new Partion();
        int[] nums = new int[]{4,5,5,6};
        System.out.println(s.partion(0,3,nums, 2));
        System.out.println("==");
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
