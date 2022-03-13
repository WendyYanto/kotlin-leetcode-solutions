class Solution {
  fun numPairsDivisibleBy60(times: IntArray): Int {
      val remainder = IntArray(65) { 0 }
      
      var result = 0
      for (time in times) {
          if (time % 60 == 0) {
              result += remainder[0]    
          } else {
              val remainderOfTime = time % 60
              
              result += remainder[60 - remainderOfTime]
          }
          
          remainder[time%60]++
      }
      
      return result
  }
}