class Solution {
  private lateinit var jobDifficulty: IntArray
  private val memo = Array(305) { IntArray(15) { -1 } } 
  
  fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
      this.jobDifficulty = jobDifficulty
      val result = dp(0, d)
      if (result >= 400000) {
          return -1
      } else {
          return result
      }
  }
  
  private fun dp(index: Int, day: Int): Int {
      if (index == jobDifficulty.size) {
          if (day == 0) {
              return 0
          } else {
              return 400000
          }
      } else if (day == 0) {
          return 400000
      }
      
      if (memo[index][day] != -1) {
          return memo[index][day]
      }
      
      var currentMax = -1
      var result = 400000
      
      for (i in index .. jobDifficulty.size - 1) {
          currentMax = maxOf(currentMax, jobDifficulty[i])
          result = minOf(result, currentMax + dp(i + 1, day - 1))
      }
      
      memo[index][day] = result
      
      return result
  }
}