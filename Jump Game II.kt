class Solution {
  private lateinit var numbers: IntArray
  private val memo = IntArray(10005) { -1 }
  
  fun jump(nums: IntArray): Int {
      numbers = nums
      return dp(0)
  }
  
  private fun dp(index: Int): Int {
      if (index == numbers.size - 1) {
          return 0
      }
      
      if (memo[index] != -1) {
          return memo[index]
      }
      
      var result = 100000
      
      for (i in 1 .. numbers[index]) {
          if (index + i < numbers.size) {
              result = minOf(result, 1 + dp(index + i))
          }
      }
      
      memo[index] = result
      
      return result
  }
}