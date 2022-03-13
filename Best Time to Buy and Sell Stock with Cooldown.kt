class Solution {
  private lateinit var prices: IntArray
  private val memo = Array(5005) { IntArray(2) { -1 } }
  
  fun maxProfit(prices: IntArray): Int {
      this.prices = prices
      return dp(0, 0)
  }
  
  private fun dp(index: Int, hasStockFlag: Int): Int {
      if (index >= prices.size) {
          return 0
      }
      if (memo[index][hasStockFlag] != -1) {
          return memo[index][hasStockFlag]
      }
      
      // do nothing
      val doNothing = dp(index + 1, hasStockFlag)
      
      val doSomething = if (hasStockFlag == 1) {
          prices[index] + dp(index + 2, 0)
      } else {
          -prices[index] + dp(index + 1, 1)            
      }
      
      val result = maxOf(doNothing, doSomething)
      memo[index][hasStockFlag] = result
      
      return result
  }
}