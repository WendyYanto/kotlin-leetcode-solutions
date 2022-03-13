class Solution {
  fun numberOfSubstrings(s: String): Int {
      val counts = IntArray(3) { 0 }
      var left = 0
      var sum = 0
      
      for (i in 0 ..  s.length - 1) {
          counts[s[i] - 'a']++
          
          while (counts[0] > 0 && counts[1] > 0 && counts[2] > 0) {
              counts[s[left] - 'a']--
              left++
          }
          
          sum += left
      }
      
      return sum
  }
}

