class Solution {
  fun myPow(x: Double, n: Int): Double {
      val absoluteN: Long = if (n > 0) {
          n.toLong()
      } else {
          0L - n.toLong()
      }
      
      val result = calculatePow(x, absoluteN)
      
      if (n < 0) {
          return 1 / result
      } 
      return result
  }
  
  private fun calculatePow(x: Double, n: Long): Double {
      if (n == 0L) {
          return 1.0
      } else if (n == 1L) {
          return x
      } 
      
      if (n%2 == 0L) {
          val a = calculatePow(x, n/2)
          return a * a
      } 
      
      return x * calculatePow(x, n-1)
  }
}