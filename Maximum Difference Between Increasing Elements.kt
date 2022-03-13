class Solution {
  fun maximumDifference(nums: IntArray): Int {
    
      var currentMax = -1
      var currentMin = nums[0]
      
      for (i in 1..nums.size-1) {
          if (nums[i] < currentMin) {
              currentMin = nums[i]
          }
          
          currentMax = Math.max(currentMax, nums[i] - currentMin)
      }
      
      return if (currentMax == 0) {
          -1
      } else {
          currentMax
      }
  }   
}