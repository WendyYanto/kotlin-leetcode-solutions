class Solution {
  fun findUnsortedSubarray(nums: IntArray): Int {
      if (nums.size == 1) {
          return 0
      }
      
      val sortedNumbers = nums.mapIndexed { index, value ->
          value to index
      }.sortedBy { it.first }
      
      var left = 0
      var right = sortedNumbers.size - 1
      
      while (left == sortedNumbers[left].second && (left + 1) <= sortedNumbers.size - 1) {
          left++
      }
      while (right == sortedNumbers[right].second && right - 1 >= 0) {
          right--
      }
  
      
      return Math.max(right - left + 1, 0)
  }
}