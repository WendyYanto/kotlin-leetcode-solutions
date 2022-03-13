class Solution {
  fun minimumDeletions(s: String): Int {
      // total B from left
      val bCounts = IntArray(s.length) { 0 }
      val aCounts = IntArray(s.length) { 0 }
      
      var count = 0
      
      for (i in 0..s.length - 1) {
          bCounts[i] = count
          val character = s[i]
          
          if (character == 'b') {
              count++
          }
      }
      
      count = 0
      
      for (i in s.length - 1 downTo 0) {
          aCounts[i] = count
          val character = s[i]
          if (character == 'a') {
              count++
          }
      }
      
      var minCount = Int.MAX_VALUE
      
      for (i in 0 .. s.length - 1) {
          minCount = minOf(minCount, aCounts[i] + bCounts[i])
      }
      
      return minCount
  }
}
