class Solution {
  fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
      val patternMap: MutableMap<String, MutableList<String>> = mutableMapOf()
      
      for (word in words) {
          val wordPattern = getPattern(word)
          val data = patternMap.getOrPut(wordPattern) { mutableListOf() }
          data.add(word)
      }
      
      return patternMap[getPattern(pattern)] ?: emptyList()
  }
  
  private fun getPattern(word: String): String {
      val colorTable = IntArray(26) { 0 }
      var color = 1
      
      for (character in word) {
          if (colorTable[character - 'a'] == 0) {
              colorTable[character - 'a'] = color
              color++
          } 
      }
      
      val stringBuilder = StringBuilder()
      for (character in word) {
          stringBuilder.append(colorTable[character - 'a'])
          stringBuilder.append("#")
      }
      
      return stringBuilder.toString()
  }
}