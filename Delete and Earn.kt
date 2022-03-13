class Solution {
  fun deleteAndEarn(nums: IntArray): Int {
      val count: MutableMap<Int, Int> = mutableMapOf()
      for (num in nums) {
          val value = count.getOrPut(num) { 0 }
          count[num] = num + value
      }
      val dp = IntArray(10005) { 0 }
      
      dp[0] = 0
      dp[1] = count[1] ?: 0
      
      for (i in 2 .. 10001) {
          dp[i] = maxOf(dp[i-1], dp[i-2] + (count[i] ?: 0))
      }
      
      return dp[10001]
  }
}