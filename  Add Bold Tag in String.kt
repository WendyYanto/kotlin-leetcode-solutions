class Solution {
  fun addBoldTag(s: String, words: Array<String>): String {
      val finalIntervals: MutableList<Pair<Int, Int>> = mutableListOf()
      
      for (word in words) {
          finalIntervals.addAll(getIntervals(s, word))
      }
      
      val sortedIntervals = finalIntervals.sortedBy { it.first }
      
      val intervals = mergeIntervals(sortedIntervals).map { 
          listOf(it.first, it.second)
      }
      
      val stringArray = s.toCharArray().map { it -> it.toString() }.toTypedArray()
      
      for (interval in intervals) {
         stringArray[interval[0]] = "<b>" + stringArray[interval[0]]
         stringArray[interval[1]] = stringArray[interval[1]] + "</b>"
      }
      
      return stringArray.joinToString("")
  }
  
  private fun mergeIntervals(intervals: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
      val results: MutableList<Pair<Int, Int>> = mutableListOf()
      
      for (interval in intervals) {
          if (results.size == 0) {
              results.add(interval)
          } else {
              val lastInterval = results.last()
              
              if ((interval.first <= lastInterval.second) || 
                  interval.first - lastInterval.second == 1) {
                  val newInterval = lastInterval.first to maxOf(interval.second, lastInterval.second)
                  results[results.lastIndex] = newInterval
                  
              } else {
                  results.add(interval)
              }
          }
      }
      
      return results
  }
  
  private fun getIntervals(word: String, search: String): List<Pair<Int, Int>> {
      var searchIndex = 0
      var offset = 0
      val results: MutableList<Pair<Int, Int>> = mutableListOf()
      
      while (searchIndex != -1) {
          searchIndex = word.indexOf(search, offset)
          
          if (searchIndex != -1) {
              val lastIndex = searchIndex + search.length - 1
              results.add(searchIndex to lastIndex)
              offset++
          }
      }
      
      return results
  }
}