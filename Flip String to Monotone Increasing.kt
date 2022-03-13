class Solution {    
  fun minFlipsMonoIncr(s: String): Int {
      val totalZeroFromRight = IntArray(s.length) { 0 }
      val totalOneFromLeft = IntArray(s.length) { 0 }
      
      var totalZero = 0
      var totalOne = 0
      
      for (i in 0 .. s.length - 1) {
          if (s[i] == '1') {
              totalOne++
          }
          // totalOne in currentIndex to left
          totalOneFromLeft[i] = totalOne
      }
  
      
      for (i in (s.length - 1) downTo 0) {
          if (s[i] == '0') {
              totalZero++
          } 
          // totalZero in currentIndex to right
          totalZeroFromRight[i] = totalZero
      }
      
      var minFlip = Int.MAX_VALUE
      var sum = 0
      
      for (i in 0 .. s.length) {
          if (i == 0) {
              // total flip to change all into zero
              sum = totalZeroFromRight[i]
          } else if (i == s.length) {
              // total flip to change all into one
              sum = totalOneFromLeft[i-1]
          } else {
              // total flip to change all zero from right
              // total flip to change all one from left
              sum = totalZeroFromRight[i] + totalOneFromLeft[i-1]
          }
          
          minFlip = minOf(minFlip, sum)
      }
      
      return minFlip
  }
}

// should not be '1' from the left of the last '0'
// should not be '0' from the right of the first '1' 