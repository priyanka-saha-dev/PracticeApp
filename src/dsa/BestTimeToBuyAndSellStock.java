package dsa;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int maxProfit = maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(maxProfit);
    }

    private static int maxProfit(int[] prices) {
        int stockBuyPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1 ; i < prices.length ; i++) {

            if(stockBuyPrice > prices[i]) {
                stockBuyPrice = prices[i];
            }
            int profit = Math.subtractExact(prices[i], stockBuyPrice);
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

}
