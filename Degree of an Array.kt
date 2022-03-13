class Solution {
  fun findShortestSubArray(nums: IntArray): Int {        
      val dict = IntArray(50005) { 0 }
      val leftIndex = IntArray(50005) { -1 }
      val rightIndex = IntArray(50005) { -1 }
      
      var maxCount = 1
      
      for (i in 0 .. nums.size - 1) {
          val num = nums[i]
          dict[num]++
          
          maxCount = Math.max(maxCount, dict[num])
          
          if (leftIndex[num] == -1) {
              leftIndex[num] = i
          } else {
              rightIndex[num] = i
          }
      }

      var minNumber = 100000
      
      val maxCounts: MutableList<Int> = mutableListOf()
      for (num in nums) {
          if (dict[num] == maxCount) {
              maxCounts.add(num)
          }
      }
      
      maxCounts.forEach { num ->
          minNumber = Math.min(minNumber, Math.max(1, rightIndex[num] - leftIndex[num] + 1))
      }
      
      return minNumber
  }
}