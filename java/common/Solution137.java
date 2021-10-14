package common;

/**
 * 137. 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
public class Solution137 {

    /**
     * 使用位运算
     * 因为是int数组，因此我们将每个int值按位相加，然后都模3，因为除了一个数之外，其余的都出现3次，因此按位相加后再模3，最后结果就是只出现一次的那个数
     * @param nums
     * @return
     */

    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            String b = Integer.toBinaryString(num);
            for (int j=b.length()-1, k=bits.length-1;j>=0;j--,k--){
                bits[k] += b.charAt(j) - '0';
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<bits.length;i++){
            bits[i] = bits[i] % 3;
            stringBuilder.append(bits[i]);
        }
        return (int) Long.parseLong(stringBuilder.toString(),2);
    }

    public static void main(String[] args) {
        Solution137 s = new Solution137();
        System.out.println(s.singleNumber(new int[]{2,2,3,2}));
    }
}
