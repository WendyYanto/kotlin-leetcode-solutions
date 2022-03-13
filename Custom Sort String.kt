class Solution {
  fun customSortString(order: String, s: String): String {
      val characters = IntArray(26) { 0 }
      
      for (character in s) {
          characters[character - 'a']++
      }
      
      var results = StringBuilder()
      
      for (character in order) {
          while (characters[character - 'a'] > 0) {
              results.append(generateString(character, characters[character - 'a']))
              characters[character - 'a'] = 0
          }
      }
      
      for (index in 'a' .. 'z') {
          if (characters[index - 'a'] > 0) {
              results.append(generateString(index, characters[index - 'a']))
          }
      }
      
      return results.toString()
  }
  
  private fun generateString(character: Char, count: Int): String {
      var index = 0
      val stringBuilder = StringBuilder()
      
      while (index < count) {
          stringBuilder.append(character)
          index++
      }
      
      return stringBuilder.toString()
  }
}