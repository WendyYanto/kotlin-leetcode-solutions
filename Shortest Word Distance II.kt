class WordDistance(wordsDict: Array<String>) {

  private val wordDictIndex: MutableMap<String, MutableList<Int>> = mutableMapOf()
  
  init {
      for (i in 0..wordsDict.size - 1) {
          val words = wordDictIndex.getOrPut(wordsDict[i]) { mutableListOf() }
          words.add(i)
      }
  }
  
  fun shortest(word1: String, word2: String): Int {
      val firstWords = wordDictIndex[word1].orEmpty()
      val secondWords = wordDictIndex[word2].orEmpty()
      
      var firstIndex = 0
      var secondIndex = 0
      
      var result = Int.MAX_VALUE
      
      while (firstIndex < firstWords.size && secondIndex < secondWords.size) {
          if (firstWords[firstIndex] > secondWords[secondIndex]) {
              result = minOf(result, firstWords[firstIndex] - secondWords[secondIndex])
              secondIndex++
          } else {
              result = minOf(result, secondWords[secondIndex] - firstWords[firstIndex])
              firstIndex++
          }
      }
      
      return result
  }

}

/**
* Your WordDistance object will be instantiated and called as such:
* var obj = WordDistance(wordsDict)
* var param_1 = obj.shortest(word1,word2)
*/
