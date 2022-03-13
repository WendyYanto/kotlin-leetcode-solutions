class Solution {
  private lateinit var coins: IntArray
  private val memo = Array(15) { IntArray(10005) { -1 } }
  
  fun coinChange(coins: IntArray, amount: Int): Int {
      this.coins = coins
      val result = dp(0, amount)
      
      if (result >= 1000000) {
          return -1
      } else {
          return result
      }
  }
  
  private fun dp(index: Int, amount: Int): Int {
      if (index == coins.size) {
          return 1000000
      } else if (amount < 0) {
          return 1000000
      } else if (amount == 0) {
          return 0
      }
      
      if (memo[index][amount] != -1) {
          return memo[index][amount]
      }
      
      var result = Int.MAX_VALUE
      for (i in index .. coins.size - 1) {
          result = minOf(result, 1 + dp(i, amount - coins[index]), dp(i + 1, amount))
      }
      
      memo[index][amount] = result
      
      return result
  }
}