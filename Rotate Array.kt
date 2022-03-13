class Solution {
  fun rotate(nums: IntArray, k: Int): Unit {
      val indexStart = k % nums.size
      
      val secondNums: MutableList<Int> = mutableListOf()
      val firstNums: MutableList<Int> = mutableListOf()
      
      val maxSecondNums = nums.size - indexStart
      var index = 0
      
      while (index < maxSecondNums) {
          secondNums.add(nums[index])
          index++
      }
      
      while (index < nums.size) {
          firstNums.add(nums[index])
          index++
      }
      
      index = 0
      val results = firstNums + secondNums
      
      while (index < nums.size) {
          nums[index] = results[index]
          index++
      }
  }
}