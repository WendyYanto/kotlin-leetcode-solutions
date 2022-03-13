class Solution {
  fun pivotIndex(nums: IntArray): Int {
      val leftSum = IntArray(nums.size) { 0 }
      val rightSum = IntArray(nums.size) { 0 }
      
      leftSum[0] = nums[0]
      for (i in 1 .. nums.size - 1) {
          leftSum[i] = nums[i] + leftSum[i-1]
      }
      
      rightSum[nums.size - 1] = nums[nums.size - 1]
      for (i in nums.size - 2 downTo 0) {
          rightSum[i] = nums[i] + rightSum[i+1]
      }
      
      for (i in 0 .. nums.size - 1) {
          val getLeft = if (i-1 >= 0) {
              leftSum[i-1]
          } else {
              0
          }
          
          val getRight = if (i + 1 <= nums.size - 1) {
              rightSum[i+1]
          } else {
              0
          }
          
          if (getLeft == getRight) {
              return i
          }
      }
      
      return -1
  }
}