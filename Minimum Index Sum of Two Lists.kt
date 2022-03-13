class Solution {
  fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
      val wordIndex: MutableMap<String, Int> = mutableMapOf()
      var words: MutableList<String> = mutableListOf()
      
      for (i in 0..list1.size - 1) {
          wordIndex[list1[i]] = i
      }
      
      var minCount = 2500
      
      for (i in 0..list2.size - 1) {
          val word = list2[i]
          if (wordIndex.contains(word)) {
              val count = i + (wordIndex[word] ?: 0)
              
              if (count < minCount) {
                  words.clear()
                  words.add(word)
                  minCount = count
              } else if (count == minCount) {
                  words.add(word)
              }
          }
      }
  
      return words.toTypedArray()
  }
}