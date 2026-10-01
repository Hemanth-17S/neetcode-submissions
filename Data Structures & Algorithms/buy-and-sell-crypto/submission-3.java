class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int pro = 0;

        while(r < prices.length) {
            if(prices[l] < prices[r]){
                int profit = prices[r] - prices[l];
                pro = Math.max(profit, pro);
            } else {
                l = r;
            }
            r++;
        }
        return pro;
    }
}
