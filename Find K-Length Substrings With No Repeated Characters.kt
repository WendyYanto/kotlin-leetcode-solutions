class Solution {
  val characterCount = IntArray(26) { 0 }
  
  fun numKLenSubstrNoRepeats(s: String, k: Int): Int {
      if (s.length < k) {
          return 0
      }
      
      // sliding window
      for (i in 0 .. k - 1) {
          characterCount[s[i] - 'a']++
      }
      
      var count = 0
      
      if (isValid()) {
          count++
      }
      
      for (i in k .. s.length - 1) {
          characterCount[s[i - k] - 'a']--
          characterCount[s[i] - 'a']++
          
          if (isValid()) {
              count++
          }
      }
      
      return count
  }
  
  private fun isValid(): Boolean {
      for (character in 'a'..'z') {
          if (characterCount[character - 'a'] > 1) {
              return false
          }
      }
      
      return true
  }
}