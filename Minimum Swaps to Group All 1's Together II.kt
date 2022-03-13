class Solution {
  fun minSwaps(nums: IntArray): Int {
      var totalOnes = 0
      
      for (num in nums) {
          if (num == 1) {
              totalOnes++
          }
      }
      
      var index = 0
      var maxLength = nums.size * 2
      var count = 0
      var minSwap = maxLength
      
      for (i in 0 .. totalOnes - 1) {
         count += nums[i] 
      }
      
      minSwap = minOf(minSwap, totalOnes - count)
      
      for (i in totalOnes .. maxLength - 1) {
          count -= nums[(i - totalOnes) % nums.size]
          count += nums[i % nums.size]
          
          minSwap = minOf(minSwap, totalOnes - count)
      }
      
      return minSwap
  }
}