class Solution {
  fun numIdenticalPairs(nums: IntArray): Int {
      val cached: MutableMap<Int, Int> = mutableMapOf()
      for (num in nums) {
          cached[num] = (cached[num] ?: 0) + 1
      }
      
      return cached.values
          .filter { value -> value >= 2 }
          .map(::getTotalCombinations)
          .sum()
  }
  
  private fun getTotalCombinations(totalNum: Int): Int {
      return ((totalNum) * (totalNum-1)) / 2
  }
}