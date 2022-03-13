class Solution {
  fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
      // get shortest end time
      val sortedIntervals = intervals.map { value ->
          value[0] to value[1]
      }.sortedBy { it.second }
      
      var currStartInterval: Int? = null
      var currEndInterval: Int? = null
      
      var nonOverlapCount = 0
      
      for (interval in sortedIntervals) {
          if (currStartInterval == null && currEndInterval == null) {
              currStartInterval = interval.first
              currEndInterval = interval.second
              nonOverlapCount++
          } else {
              val startInterval = interval.first
              val endInterval = interval.second
              
              val safeCurrStartInterval = currStartInterval ?: 0
              val safeCurrEndInterval = currEndInterval ?: 0
              
              // take maximum of non overlap count
              if (startInterval >= safeCurrEndInterval) {
                  currEndInterval = maxOf(endInterval, safeCurrEndInterval)
                  nonOverlapCount++
              } 
          }
      }
      
      return sortedIntervals.size - nonOverlapCount
  }
}