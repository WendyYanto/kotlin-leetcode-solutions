class Solution {
  fun mySqrt(x: Int): Int {
      
      if (x == 1) {
          return 1
      }
      
      val longX = x.toLong()
      var left: Long = 1
      var right: Long = longX
      
      while (left <= right) {
          val mid = left + (right - left)/2
          
          if (mid*mid == longX) {
              return mid.toInt()
          } else if (mid*mid > longX) {
              right = mid - 1
          } else {
              left = mid + 1
          }
      }
      
      return right.toInt()
  }
}