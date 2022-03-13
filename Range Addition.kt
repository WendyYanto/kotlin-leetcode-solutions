class Solution {
  fun getModifiedArray(length: Int, updates: Array<IntArray>): IntArray {
      val counts = IntArray(length) { 0 }
      
      for (update in updates) {
          val startIndex = update[0]
          val endIndex = update[1]
          val value = update[2]
          
          counts[startIndex] += value
          
          if (endIndex + 1 < length) {
              counts[endIndex + 1] -= value
          }
      }
      
      var sum = 0
      
      for (i in 0 .. length - 1) {
          sum += counts[i]
          counts[i] = sum
      }
      
      return counts
  }
}
