class Solution {
  private val numbersCount: MutableMap<Int, Int> = mutableMapOf()
  
  fun distinctNumbers(nums: IntArray, k: Int): IntArray {
      val results: MutableList<Int> = mutableListOf()
      
      for (i in 0 .. k - 1) {
          val value = numbersCount.getOrPut(nums[i]) { 0 }
          numbersCount[nums[i]] = value + 1
      }
      
      results.add(numbersCount.keys.size)
      
      for (i in k .. nums.size - 1) {
          val decrementValue = numbersCount.getOrPut(nums[i - k]) { 0 }
          numbersCount[nums[i - k]] = decrementValue - 1
          
          if (numbersCount[nums[i - k]] == 0) {
              numbersCount.remove(nums[i - k])
          }
          
          val incrementValue = numbersCount.getOrPut(nums[i]) { 0 }
          numbersCount[nums[i]] = incrementValue + 1
          
          results.add(numbersCount.keys.size)
      }
      
      return results.toIntArray()
  }
}