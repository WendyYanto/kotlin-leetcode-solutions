class Solution {
  fun largeGroupPositions(s: String): List<List<Int>> {
      val words: MutableList<String> = mutableListOf()
      val startIndexes: MutableList<Int> = mutableListOf()
      
      var word = ""
      var startIndex = 0
      
      for (i in 0..s.length - 1) {
          word += s[i]
          if (i + 1 <= s.length - 1 && s[i] != s[i+1]) {
              words.add(word)
              startIndexes.add(startIndex)
              
              word = ""
              startIndex = i + 1
          }
      }
      
      if (word.length > 0) {
          words.add(word)
          startIndexes.add(startIndex)
      }
      
      return words.mapIndexed { index, word ->
          listOf(startIndexes[index], startIndexes[index] + word.length - 1)
      }.filter { result ->
          result[1] - result[0] >= 2
      }
  }
}