package Arrays.Easy;

class BestTimetoBuyandSellStock {
    // Function to calculate maximum profit
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Initialize to a very high value
        int maxProfit = 0; // Initialize profit to zero

        // Loop through all prices
        for (int price : prices) {
            if (price < minPrice) {
                // Update minPrice if a lower price is found
                minPrice = price;
            } else {
                // Calculate profit and update maxProfit if it's higher
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit; // Return the maximum profit found
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4}; // Sample prices
        System.out.println(maxProfit(nums)); // Output: 5 (buy at 1, sell at 6)
    }
}


/*


 **Problem Statement**
The task is to determine the maximum profit that can be achieved by buying and selling a stock given its price on different days, represented by an array.
- **Constraints**:
  - You may complete at most one transaction (buy one day and sell one day later).
  - If no profit can be achieved, return 0.



 **Approach**
The approach involves iterating through the array of prices while tracking two variables:
1. **`minPrice`**: The lowest price seen so far to simulate a "buy".
2. **`maxProfit`**: The maximum profit observed so far by selling after the current `minPrice`.

**Steps:*
1. Initialize `minPrice` to `Integer.MAX_VALUE` and `maxProfit` to 0.
2. For each price in the array:
   - If the price is less than `minPrice`, update `minPrice`.
   - Otherwise, calculate the profit for the current price (`price - minPrice`) and update `maxProfit` if this profit is greater.
3. Return `maxProfit` after the loop.

This greedy approach ensures the solution is optimal and efficient.


 **Complexity Analysis**
1. **Time Complexity**:
   - **O(n)**: The loop runs once through the array, where `n` is the number of elements in `prices`.

2. **Space Complexity**:
   - **O(1)**: Constant extra space is used for the variables `minPrice` and `maxProfit`.


 */