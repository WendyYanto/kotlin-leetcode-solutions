class Solution {
  fun getAverages(nums: IntArray, k: Int): IntArray {
      val results = IntArray(nums.size) { -1 }
      
      // startIndex
      if (2*k >= nums.size) {
          return results
      }
      
      var sum = 0L
      // perform initial index of slidingWindow
      for (i in 0 .. 2*k) {
          sum += nums[i]
      }
      
      results[k] = (sum / (2*k + 1)).toInt()
      
      val startIndex = 2*k + 1
      val maxIndex = nums.size - 1
      
      for (i in startIndex .. maxIndex) {
          sum -= nums[i - 2*k - 1]
          sum += nums[i]
          
          results[i - k] = (sum / (2*k + 1)).toInt()
      }
      
      return results
  }
}