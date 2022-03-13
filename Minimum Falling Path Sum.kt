class Solution {
  fun minFallingPathSum(matrix: Array<IntArray>): Int {
      val memo = Array(matrix.size + 2) { IntArray(matrix.size + 2) { 0 } }
      
      for (i in 0 .. matrix.size + 1) {
          // left and right
          memo[i][0] = Int.MAX_VALUE
          memo[i][matrix.size + 1] = Int.MAX_VALUE
      }
      
      for (i in 0 .. matrix.size + 1) {
         // top
          memo[0][i] = 0
      }
      
      for (i in 1 .. matrix.size) {
          for (j in 1 .. matrix.size) {
              val result = minOf(memo[i-1][j], memo[i-1][j-1], memo[i-1][j+1])
              
              memo[i][j] = matrix[i-1][j-1] + result
          }
      }
      
      var minimumResult = Int.MAX_VALUE
      for (i in 0 .. matrix.size) {
          minimumResult = minOf(minimumResult, memo[matrix.size][i])
      }
      
      return minimumResult
  }
}