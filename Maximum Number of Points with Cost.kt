class Solution {
  fun maxPoints(points: Array<IntArray>): Long {
      val height = points.size
      val width = points[0].size
      
      val dp = Array(height + 5) { LongArray(width + 5) { 0L } }
      
      // setup bottom
      for (i in 0 .. width - 1) {
          dp[height - 1][i] = points[height - 1][i].toLong()
      }
      
      var maxResult = 0L
      
      for (i in height - 2 downTo 0) {
          val leftMax = LongArray(width + 5) { 0L }
          val rightMax = LongArray(width + 5) { 0L }
          
          leftMax[0] = dp[i+1][0]
          
          for (j in 1 .. width - 1) {
              leftMax[j] = maxOf(leftMax[j-1] - 1, dp[i+1][j])
          }
          
          rightMax[width - 1] = dp[i+1][width - 1]
          
          for (j in width - 2 downTo 0) {
              rightMax[j] = maxOf(rightMax[j+1] - 1, dp[i+1][j])
          }
          
          for (j in 0 .. width - 1) {
              dp[i][j] = maxOf(dp[i][j], points[i][j] + maxOf(leftMax[j], rightMax[j]))
          }
      }
      
      for (i in 0 .. width - 1) {
          maxResult = maxOf(maxResult, dp[0][i])
      }
      
      return maxResult
  }
}