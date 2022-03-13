class Solution {
  fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<String> {
      if (nums.size == 0) {
          if (upper - lower == 0) {
              return listOf("${lower}")
          } else {
              return listOf("${lower}->${upper}")
          }
      }
      
      val results: MutableList<IntArray> = mutableListOf()
      
      if (lower < nums[0]) {
          results.add(intArrayOf(lower, nums[0] - 1))
      }
      
      for (i in 1 .. nums.size - 1) {
          if (nums[i] - nums[i-1] > 1) {
              results.add(intArrayOf(nums[i-1] + 1, nums[i] - 1))
          }
      }
      
      if (upper > nums[nums.lastIndex]) {
          results.add(intArrayOf(nums[nums.lastIndex] + 1, upper))
      }
      
      return results.map { 
          if (it[1] - it[0] == 0) {
              it[0].toString()
          } else {
              "${it[0]}->${it[1]}"
          }
      }
  }
}