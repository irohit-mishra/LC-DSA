//peak vally approch
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int i = 0;
        int valley, peak;
        
        while (i < prices.length - 1) {
            // Find valley
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            
            // Find peak
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            
            // Calculate profit from valley to peak and add to maxProfit
            maxProfit += peak - valley;
        }
        
        return maxProfit;
    }
}
