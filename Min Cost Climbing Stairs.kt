class Solution {
  private val memo: IntArray = IntArray(1005) { -1 }
  private lateinit var cost: IntArray
  private var n = 0
  
  // top to bottom
  fun minCostClimbingStairs(cost: IntArray): Int {
      this.cost = cost
      n = cost.size
      return minOf(dp(0), dp(1))
  }
  
  private fun dp(index: Int): Int {
      if (index >= n) {
          return 0
      }
      if (memo[index] != -1) {
          return memo[index];
      }
      val result = cost[index] + minOf(dp(index + 1), dp(index + 2))
      memo[index] = result
      return result
  }

  // bottom to top
  fun minCostClimbingStairs(cost: IntArray): Int {
    val memo: IntArray = IntArray(cost.size + 1) { 0 }
    
    for (i in 2 .. cost.size) {
        val takeTwoStepCost = cost[i-2] + memo[i-2]
        val takeOneStepCost = cost[i-1] + memo[i-1]
        
        memo[i] = minOf(takeOneStepCost, takeTwoStepCost)
    }
    
    return memo[cost.size]
}
}