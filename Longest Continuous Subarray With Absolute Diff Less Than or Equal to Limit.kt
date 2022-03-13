class Solution {
  fun longestSubarray(nums: IntArray, limit: Int): Int {
      val sortedSet = TreeSet<Int>()
      val numbersCount: MutableMap<Int, Int> = mutableMapOf()
      var left = 0
      var right = 0
      var maxLength = 0
      
      while (right < nums.size) {
          sortedSet.add(nums[right])
          val count = numbersCount.getOrPut(nums[right]) { 0 }
          numbersCount[nums[right]] = count + 1
          
          while (Math.abs(sortedSet.first() - sortedSet.last()) > limit) {
              val leftCount = numbersCount.getOrPut(nums[left]) { 0 }
              numbersCount[nums[left]] = leftCount - 1
              
              if (leftCount - 1 == 0) {
                  sortedSet.remove(nums[left])
              }
              
              left++
          }
          
          maxLength = maxOf(maxLength, right - left + 1)
          right++
      }
      
      return maxLength
  }
}