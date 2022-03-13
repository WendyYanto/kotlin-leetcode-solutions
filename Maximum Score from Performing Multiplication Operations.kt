class Solution {
  private lateinit var numbers: IntArray
  private lateinit var multipliers: IntArray
  private var size = 0
  private val memo = Array(1003) { LongArray(1003) { -1 } }
  
  fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
      this.numbers = nums
      this.multipliers = multipliers
      size = numbers.size
      
      return dp(0, 0).toInt()
  }
  
  private fun dp(multiplierIndex: Int, left: Int): Long {
      if (left >= numbers.size) {
          return Long.MIN_VALUE
      }
      if (multiplierIndex == multipliers.size) {
          return 0
      }
      
      val right = size - 1 - (multiplierIndex - left)
      
      if (memo[multiplierIndex][left] != -1L) {
          return memo[multiplierIndex][left]
      }
      
      memo[multiplierIndex][left] = maxOf(multipliers[multiplierIndex] * numbers[left] + dp(multiplierIndex + 1, left + 1), multipliers[multiplierIndex] * numbers[right] + dp(multiplierIndex + 1, left))
      
      return memo[multiplierIndex][left]
  }
}