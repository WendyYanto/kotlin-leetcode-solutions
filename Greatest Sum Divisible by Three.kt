class Solution {
  fun maxSumDivThree(nums: IntArray): Int {
      var dp: Array<IntArray> = Array(nums.size + 1) { IntArray(3) { 0 } }
      
      // value is not needed
      dp[0][1] = Integer.MIN_VALUE
      dp[0][2] = Integer.MIN_VALUE
      
      for (i in 1 .. nums.size) {
          for (j in 0..2) {
              val num = nums[i - 1]
              
              if (num%3 == 0) {
                  dp[i][0] = maxOf(dp[i-1][0], dp[i-1][0] + num)
                  dp[i][1] = maxOf(dp[i-1][1], dp[i-1][1] + num)
                  dp[i][2] = maxOf(dp[i-1][2], dp[i-1][2] + num)
              } else if (num%3 == 1) {
                  dp[i][0] = maxOf(dp[i-1][0], num + dp[i-1][2])
                  dp[i][1] = maxOf(dp[i-1][1], num + dp[i-1][0])
                  dp[i][2] = maxOf(dp[i-1][2], num + dp[i-1][1])
              } else {
                  dp[i][0] = maxOf(dp[i-1][0], num + dp[i-1][1])
                  dp[i][1] = maxOf(dp[i-1][1], num + dp[i-1][2])
                  dp[i][2] = maxOf(dp[i-1][2], num + dp[i-1][0])
              }
          }
      }
      
      return dp[nums.size][0]
  }
}