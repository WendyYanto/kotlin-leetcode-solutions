class Solution {
  val cachedValue = BooleanArray(105) { false }
  
  fun checkValid(matrix: Array<IntArray>): Boolean {
      var size = matrix.size
      

      for (i in 0..matrix.size - 1) {
          // check row
          for (j in 0 .. matrix[i].size - 1) {
              cachedValue[matrix[i][j]] = true
          }
          for (i in 1 .. size) {
              if (!cachedValue[i]) {
                  return false
              } 
              cachedValue[i] = false
          }
          
          // check column
          for (j in 0..matrix[i].size - 1) {
              cachedValue[matrix[j][i]] = true
          }

          for (i in 1 .. size) {
              if (!cachedValue[i]) {
                  return false
              } 
              cachedValue[i] = false
          }
      }
      
      return true
  }
}