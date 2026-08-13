package arrays.medium;

import arrays.ArrayProblem;
import arrays.Run;

/*
*
* Best Time to Buy and Sell Stock
    * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
* You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*
* Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

*
* */
@Run
public class BuySellStock1 implements ArrayProblem {
    @Override
    public String getProblemTitle() {
        return "Best Time to Buy and Sell Stock";
    }


    /*
    * The idea is to track the minimum price so far while traversing the array and calculate the profit if we sold today. This way, we can constantly update the maximum profit without using nested loops. We’re basically simulating:
What’s the lowest price we’ve seen so far?
What’s the profit if we sold today?
Is it better than our best so far?
Initialize a variable to store the minimum price so far, set it to a very large value initially.
Initialize a variable to store the maximum profit seen so far, set it to 0 initially.
Loop through each price in the array.
Update the minimum price if the current price is smaller.
Calculate the profit if the stock were bought at the minimum price and sold at the current price.
Update the maximum profit if this new profit is higher.
Return the maximum profit after the loop ends.
    * */
    public int getMaxProfit(int[] prices)
    {
        int minimumPrice = prices[0];
        int maxProfit =0;
        int n = prices.length;
        for(int i=1;i<n;i++)
        {
            int profit = prices[i] - minimumPrice;
            maxProfit = Math.max(profit,maxProfit);
            minimumPrice = Math.min(minimumPrice,prices[i]);
        }
        return maxProfit;
    }


    /*
    * 1. Convert prices into daily differences
For:
        [7, 1, 5, 3, 6, 4]
        Calculate the change between consecutive days:
        [-6, +4, -2, +3, -2]
        Now the problem becomes:
        Find the maximum-sum contiguous subarray of these differences.
        That's exactly Kadane's algorithm.
        For example:
        +4 + (-2) + 3 = 5
        So the maximum profit is 5.
    *
    * */
    int maxProfitKadaneBasedGPT(int[] prices) {
        int current = 0;
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];

            current = Math.max(0, current + profit);
            max = Math.max(max, current);
        }

        return max;
    }

    @Override
    public void solve() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(getMaxProfit(prices));
        System.out.println(maxProfitKadaneBasedGPT(prices));
    }
}
