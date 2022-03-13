class Solution {
  fun isThree(n: Int): Boolean {
      var count = 0
      val squareOfN = Math.sqrt(n.toDouble()).toInt()
      
      for (i in 1..squareOfN) {
          if (n%i == 0) {
              if (n == i * i) {
                  count++
              } else {
                  count += 2
              }
          }
      }
      
      return count == 3
  }
}