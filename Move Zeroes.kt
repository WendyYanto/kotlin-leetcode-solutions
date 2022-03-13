class Solution {
  fun moveZeroes(nums: IntArray): Unit {
      var left = 0
      var right = nums.size - 1
      var index = 0
      
      while (left <= right) {
          if (nums[left] != 0) {
              nums[index] = nums[left]
              index++
          }
          left++
      }
      
      while (index <= right) {
          nums[index] = 0
          index++
      }
  }
}