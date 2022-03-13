class Solution {
  fun findErrorNums(nums: IntArray): IntArray {
      val totalNums = nums.sum()
      val correctTotalNums = List(nums.size, { it + 1 }).sum()
      
      val diffNum = correctTotalNums - totalNums
      
      val duplicateNum = nums
          .toList()
          .groupingBy { it }
          .eachCount()
          .filter { number -> number.value > 1 }
          .toList()
          .first()
          .first
              
      return listOf(duplicateNum, duplicateNum + diffNum).toIntArray()
  }
}