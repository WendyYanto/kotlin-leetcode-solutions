class Solution {
  fun dietPlanPerformance(calories: IntArray, k: Int, lower: Int, upper: Int): Int {
      var count = 0
      var index = 0
      var size = calories.size
      
      var currentCount = 0
      while (index < k) {
          currentCount += calories[index]
          index++
      }
      
      if (currentCount > upper) {
          count++
      } else if (currentCount < lower) {
          count--
      }
      
      while (index < size) {
          currentCount -= calories[index - k]
          currentCount += calories[index]
          index++
          
          if (currentCount > upper) {
              count++
          } 
          if (currentCount < lower) {
              count--
          }
      }
      
      return count
  }
}