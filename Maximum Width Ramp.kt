class Solution {
  fun maxWidthRamp(nums: IntArray): Int {
      val decreasingNumbers: MutableList<Pair<Int, Int>> = mutableListOf()
      var maxLength = 0
      
      for (i in 0 .. nums.size - 1) {
          if (decreasingNumbers.isEmpty() || decreasingNumbers.last().first > nums[i]) {
              decreasingNumbers.add(nums[i] to i)
          } else {
              var left = 0
              var right = decreasingNumbers.size - 1
              
              while (left < right) {
                  val mid = left + (right - left) / 2
                  val middle = decreasingNumbers[mid].first
                  
                  if (middle <= nums[i]) {
                      right = mid
                  } else {
                      left = mid + 1
                  }
              }
              
              maxLength = maxOf(maxLength, i - decreasingNumbers[left].second)
          }
      }
      
      return maxLength
  }
}