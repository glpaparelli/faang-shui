package problems.array.easy;
/*
 * LEETCODE 121: Best Time to Buy and Sell Stocks
 * You are given an array "prices" where prices[i] is the price of a given 
 * stock on the i-th day.
 * 
 * You want to maximize your profit by choosing a single day to buy one
 * stock and choosing a different day in the future to sell that stock.
 * 
 * Return the maxmimum profit you can achieve from this transaction. 
 * If you cannot achieve any profit, return 0. 
 * 
 * SOLUTIONS: 
 * - Dynamic Programming Solution: O(n^2)
 *   dp[i][j] = profit if buy at i-th and sell at j-th
 *   if j >= i then dp[i][j] = 0. Once its full find the max
 * 
 * - Sliding Window Wolution: O(n)
 *   Use buy (left) and sell (right) pointer, buy = 0, sell = 1. 
 *   Sell will always be after buy.
 *   Go though prices with while (sell < prices.length)
 *       - if prices[buy] < prices[sell] 
 *             - then there may be a profit, 
 *               maxProfit = max(maxProfit, prices[sell]-prices[buy])
 *             - else buy = sell, shift the left side of the window
 *       - right++, make the window shift to the right
 * 
 * - Optimal Solution: O(n), beats 99%
 *   We just need to find the smallest element that is followed by 
 *   the biggest one. 
 *   We keep track of the current minimum price while inspecting every
 *   price. If the current price is not smaller than the min price we 
 *   check if it improves our profit.
 */

public class BTtBaSS {
   public static void main(String[] args) {
      System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
      System.out.println(maxProfit(new int[]{1,2}));
      System.out.println(maxProfit(new int[]{7,6,4,3,1}));
   }  

   public static int dpMaxProfit(int[] prices) {
      int dp[][] = new int[prices.length][prices.length];
      int maxProfit = 0;

      for (int i = 0; i < prices.length; i++) 
         for (int j = 0; j < prices.length; j++)
            if (j <= i)
               dp[i][j] = 0;
            else {
               dp[i][j] = prices[j] - prices[i];
               maxProfit = Integer.max(maxProfit, dp[i][j]);
            }
         
      return maxProfit;
   }

   public static int swMaxProfit(int[] prices) {
      int buy = 0; 
      int sell = 1;
      int maxProfit = 0;

      while (sell < prices.length) {
         if (prices[buy] < prices[sell]) 
            maxProfit = Integer.max(maxProfit, prices[sell] - prices[buy]);
         else 
            buy = sell;
         
         sell++;
      }

      return maxProfit;
   }

   public static int maxProfit(int[] prices) {
      int minPrice = Integer.MAX_VALUE;
      int maxProfit = 0;

      // we go through every price
      for(int currentPrice : prices)
         // we keep track of the current minimum price
         if(currentPrice < minPrice)
            minPrice = currentPrice;

         // if the current price is not the minimum price then 
         // it could be the maximum, and it is surely after the 
         // minimum price: this price improve my profit?
         else
            maxProfit = Math.max(maxProfit, currentPrice - minPrice);
         
      return maxProfit;
   } 
 }