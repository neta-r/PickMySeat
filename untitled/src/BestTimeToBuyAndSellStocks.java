public class BestTimeToBuyAndSellStocks {
    public static int maxProfit(int[] prices) {
        if ((prices.length == 0) || (prices.length == 2 && prices[1] - prices[0] < 0)) return 0;
        if (prices.length == 2) return prices[1] - prices[0];

        int lastInt = prices[0];
        int startIndex = -1;
        int currMin = -1;
        int currMax = -1;
        int maxProfit = currMax - currMin;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > lastInt) {
                startIndex = i;
                currMax = prices[i];
                currMin = prices[i - 1];
                break;
            } else {
                lastInt = prices[i];
            }
        }
        if (startIndex==-1) return 0;


        for (int i = startIndex; i < prices.length; i++) {
            if (prices[i] > currMin && prices[i] - currMin > maxProfit) {
                currMax = prices[i];
                maxProfit = currMax - currMin;
            }
            if (prices[i] < currMin) {
                currMin = prices[i];
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        maxProfit(prices);
    }
}