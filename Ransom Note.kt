class Solution {
  fun canConstruct(ransomNote: String, magazine: String): Boolean {
      val dictionaries = IntArray(26) { 0 }
      
      for (character in ransomNote) {
          dictionaries[character - 'a']--
      }
      
      for (character in magazine) {
          dictionaries[character - 'a']++
      }
      
      for (character in 'a' .. 'z') {
          if (dictionaries[character - 'a'] < 0) {
              return false
          }
      }
      
      return true
  }
}