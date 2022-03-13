class Solution {
  private lateinit var days: IntArray
  private lateinit var costs: IntArray
  private var memo = IntArray(366) { Int.MAX_VALUE }
  private lateinit var daySet: Set<Int>
  
  fun mincostTickets(days: IntArray, costs: IntArray): Int {
      this.days = days
      this.costs = costs
      
      daySet = days.toSet()
      
      return dp(1)
  }
  
  private fun dp(day: Int): Int {
      // already pass the last day
      if (day > days.last()) {
          return 0
      }
      
      if (memo[day] != Int.MAX_VALUE) {
          return memo[day]
      }
      
      val smallest = if (daySet.contains(day)) {
          // I travel today
          minOf(costs[0] + dp(day + 1), 
                costs[1] + dp(day + 7), 
                costs[2] + dp(day + 30))
      } else {
          // I don't travel today
          dp(day + 1)
      }
      
      memo[day] = minOf(smallest, memo[day])
      
      return memo[day]
  }
}