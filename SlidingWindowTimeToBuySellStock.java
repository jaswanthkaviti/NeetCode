package org.example;

public class SlidingWindowTimeToBuySellStock {
    public static void main(String[] args){
        int[] prices = {10,8,7,5,2};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    private static int maxProfit(int[] prices) {
        int i=0;
        int j=i+1;
        int maxProfit=0;
        while(j<prices.length){
            if(prices[i]>prices[j]){
                i++;
                j++;
            }
            else{
                maxProfit=Math.max(maxProfit,prices[j]-prices[i]);
                j++;
            }
        }
        return maxProfit;
    }
}
