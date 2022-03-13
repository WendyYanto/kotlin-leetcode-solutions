class Solution {
  fun transpose(matrix: Array<IntArray>): Array<IntArray> {
      val newMatrix = Array(matrix[0].size) { IntArray(matrix.size) { 0 } }
      
      for (i in 0 .. matrix.size - 1) {
          for (j in 0 .. matrix[0].size - 1) {
             newMatrix[j][i] = matrix[i][j] 
          }
      }
      
      return newMatrix
  }
}