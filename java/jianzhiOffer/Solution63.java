package jianzhiOffer;

/**
 * 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */

public class Solution63 {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxmoney = 0;
        for (int i=0;i<prices.length;i++){
            if (prices[i]>=minprice) maxmoney = Math.max(maxmoney, prices[i]-minprice);
            else    minprice = prices[i];
        }
        return maxmoney;
    }
}
