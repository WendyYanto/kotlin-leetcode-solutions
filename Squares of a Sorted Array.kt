class Solution {
  fun sortedSquares(nums: IntArray): IntArray {
      var left = 0
      var right = nums.size - 1
      
      val output = IntArray(nums.size)
      var index = nums.size - 1
      
      while (left <= right) {
          val leftNumber = Math.abs(nums[left])
          val rightNumber = Math.abs(nums[right])
          
          if (leftNumber > rightNumber) {
              output[index--] = leftNumber * leftNumber
              left++
          } else {
              output[index--] = rightNumber*rightNumber
              right--
          }
      }
      
      return output
  }
}