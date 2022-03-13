class Solution {
  fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
      if (intervals.size == 0) {
          return true
      }
      
      val sortedIntervals = intervals.map { interval ->
          interval[0] to interval[1]
      }.sortedBy { it.first }
      
      var startInterval = sortedIntervals.first().first
      var endInterval = sortedIntervals.first().second
      
      for (i in 1 .. sortedIntervals.size - 1) {
          val currentInterval = sortedIntervals[i]
          
          val currentStartInterval = currentInterval.first
          val currentEndInterval = currentInterval.second
          
          if (endInterval > currentStartInterval) {
              return false
          } else {
              startInterval = currentStartInterval
              endInterval = maxOf(currentEndInterval, endInterval)
          }
      }
      
      return true
  }
}