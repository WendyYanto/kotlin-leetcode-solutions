class Solution {
  private val uniqueNumbers: MutableList<Int> = mutableListOf()
  private val countMap: MutableMap<Int, Int> = mutableMapOf()
  
  fun topKFrequent(nums: IntArray, k: Int): IntArray {
      for (num in nums) {
          val value = countMap.getOrPut(num) { 0 }
          if (value == 0) {
              uniqueNumbers.add(num)
          }
          countMap[num] = value + 1
      }
      
      val startIndex = quickSelect(0, uniqueNumbers.size - 1, uniqueNumbers.size - k)
      
      return (startIndex .. uniqueNumbers.size - 1)
          .map { index ->  uniqueNumbers[index] }
          .toIntArray()
  }
  
  private fun quickSelect(left: Int, right: Int, target: Int): Int {
      if (left == right) {
          return left
      }
      
      val mid = partition(left, right)
      
      if (mid == target) {
          return mid
      } else if (mid > target) {
          return quickSelect(left, mid - 1, target)
      } else {
          return quickSelect(mid + 1, right, target)
      }
  }
  
  private fun partition(left: Int, right: Int): Int {
      var leftIndex = left
      
      val pivot = countMap[uniqueNumbers[right]]!!
      
      for (i in left .. right - 1) {
          if (countMap[uniqueNumbers[i]]!! <= pivot) {
              swap(i, leftIndex)
              leftIndex++
          }
      }
      
      swap(right, leftIndex)
      
      return leftIndex
  }
  
  private fun swap(left: Int, right: Int) {
      val temp = uniqueNumbers[left]
      uniqueNumbers[left] = uniqueNumbers[right]
      uniqueNumbers[right] = temp
  }
}