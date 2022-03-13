class Solution {
  private var characterCount = IntArray(27) { 0 }
  private val originCount = IntArray(27) { 0 }
  
  fun checkInclusion(s1: String, s2: String): Boolean {
      if (s1.length > s2.length) {
          return false
      }
      
      for (i in 0 .. s1.length - 1) {
          originCount[s1[i] - 'a']++
      }
      
      var shortStringCount = s1.length
      
      for (i in 0 .. shortStringCount - 1) {
          characterCount[s2[i] - 'a']++
      }
      
      if (isValid()) {
          return true
      }
      
      // sliding window
      for (i in shortStringCount .. s2.length - 1) {
          characterCount[s2[i - shortStringCount] - 'a']--
          characterCount[s2[i] - 'a']++
          
          if (isValid()) {
              return true
          }
      }
      
      return false
  }
  
  private fun isValid(): Boolean {
      for (i in 0 .. 25) {
          if (characterCount[i] != originCount[i]) {
              return false
          }
      }
      
      return true
  }
}