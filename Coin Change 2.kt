class Solution {
  private val memo = Array(305) { IntArray(5005) { -1 } }
  private lateinit var coins: IntArray
  
  fun change(amount: Int, coins: IntArray): Int {
      this.coins = coins
      return dp(0, amount)
  }
  
  private fun dp(index: Int, amount: Int): Int {
      if (amount == 0) {
          return 1
      } else if (amount < 0) {
          return 0
      }
      if (memo[index][amount] != -1) {
          return memo[index][amount]
      }
      
      var count = 0
      for (i in index .. coins.size - 1) {
         if (amount - coins[i] < 0) {
             continue
         }
         
         count += dp(i, amount - coins[i])
      }
      
      memo[index][amount] = count
      return count
  }
}