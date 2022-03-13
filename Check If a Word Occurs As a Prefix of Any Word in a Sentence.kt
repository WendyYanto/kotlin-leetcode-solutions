class Solution {
  companion object {
      private const val SPACE = " "
  }
  
  
  fun isPrefixOfWord(sentence: String, searchWord: String): Int {
      val words = sentence.split(SPACE)
      val result = words.indexOfFirst { word -> word.startsWith(searchWord) }
      
      if (result < 0) {
          return result
      }
      
      return 1 + result
  }
}