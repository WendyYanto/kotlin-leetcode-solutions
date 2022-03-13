class Solution {
  fun maximalSquare(matrix: Array<CharArray>): Int {
      val dp = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) { 0 } }
      
      var maxValue = 0
      
      for (i in 1 .. matrix.size) {
          for (j in 1 .. matrix[0].size) {
              val minimumValue = minOf(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])
              
              if (matrix[i-1][j-1] == '1') {
                  dp[i][j] = 1 + minimumValue
              } else {
                  dp[i][j] = 0 
              }
              
              maxValue = maxOf(maxValue, dp[i][j])
          }
      }
      
      return maxValue * maxValue
  }
}