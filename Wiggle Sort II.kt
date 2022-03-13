class Solution {
  fun wiggleSort(nums: IntArray): Unit {
      val sortedNumbers = nums.sorted()
      
      val mid = (sortedNumbers.size - 1) / 2
      var left = mid
      var right = sortedNumbers.size - 1
      
      var index = 0
      
      while (left >= 0 && right > mid && index < nums.size) {
          nums[index] = sortedNumbers[left]
          left--
          index++
          
          nums[index] = sortedNumbers[right]
          right--
          index++
      }
      
      if (index < nums.size) {
          nums[index] = sortedNumbers[left]
      }
  }
}