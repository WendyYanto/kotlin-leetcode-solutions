class Solution {
  private val timestamp = IntArray(1000005) { 0 }
  
  fun minMeetingRooms(intervals: Array<IntArray>): Int {
      var smallest = Int.MAX_VALUE
      var largest = Int.MIN_VALUE
      
      for (interval in intervals) {
          smallest = minOf(smallest, interval[0])
          largest = maxOf(largest, interval[1])
          
          timestamp[interval[0]] += 1
          timestamp[interval[1]] -= 1
      }
      
      var count = 0
      var result = 0
      
      for (i in smallest..largest) {
          count += timestamp[i]
          result = maxOf(result, count)
      }
      
      return result
  }
}