class Solution {
  fun areOccurrencesEqual(s: String): Boolean {
      val arrays = IntArray(26) { 0 }
      var maxNum = 0
      
      for (char in s) {
          arrays[char - 'a']++
          maxNum = Math.max(arrays[char - 'a'], maxNum)
      }
      
      for (char in s) {
          if (maxNum != arrays[char - 'a']) {
              return false
          }
      }
      
      return true
  }
}