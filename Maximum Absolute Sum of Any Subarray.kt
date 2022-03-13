class Solution {
  private lateinit var numbers: IntArray
  private val memoSmallest = IntArray(100005) { -1000005 }
  private val memoLargest = IntArray(100005) { 1000005 }
  
  fun maxAbsoluteSum(nums: IntArray): Int {
      this.numbers = nums
      
      getSmallest(0)
      getLargest(0)
      
      var maximum = Int.MIN_VALUE
      
      for (i in 0 .. numbers.size - 1) {
          maximum = maxOf(maximum, Math.abs(memoSmallest[i]), Math.abs(memoLargest[i]))
      }
      
      return maximum
  }
  
  private fun getSmallest(index: Int): Int {
      if (index == numbers.size) {
          return 0
      }
      
      if (memoSmallest[index] != -1000005) {
          return memoSmallest[index]
      }
      
      val goToNext = getSmallest(index+1)
      memoSmallest[index] = minOf(numbers[index], numbers[index] + goToNext)
      
      return memoSmallest[index]
  }
  
  private fun getLargest(index: Int): Int {
      if (index == numbers.size) {
          return 0
      }
      
      if (memoLargest[index] != 1000005) {
          return memoLargest[index]
      }
      
      val goToNext = getLargest(index+1)
      memoLargest[index] = maxOf(numbers[index], numbers[index] + goToNext)
      
      return memoLargest[index]
  }
}