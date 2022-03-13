class Solution {
  fun targetIndices(nums: IntArray, target: Int): List<Int> {
      // sort numbers
      val numbers = nums.toMutableList()
      
      quickSort(numbers, 0, numbers.size - 1)
      
      val results: MutableList<Int> = mutableListOf()
      
      for (i in 0 .. numbers.size - 1) {
          if (numbers[i] == target) {
              results.add(i)
          }
      }
      
      return results
  }
  
  private fun quickSort(numbers: MutableList<Int>, left: Int, right: Int) {
      if (left >= right) {
          return
      }
      
      val pivot = getPartitions(numbers, left, right)
      
      quickSort(numbers, left, pivot - 1)
      quickSort(numbers, pivot + 1, right)
  }
  
  private fun getPartitions(numbers: MutableList<Int>, left: Int, right: Int): Int {
      val pivot = numbers[right]
      
      var i = left
      for (j in left .. right - 1) {
          if (numbers[j] <= pivot) {
              swapNumber(numbers, i, j)
              i++
          } 
      }
      
      swapNumber(numbers, right, i)
      
      return i
  }
  
  private fun swapNumber(numbers: MutableList<Int>, firstIndex: Int, secondIndex: Int) {
      val temp = numbers[firstIndex]
      numbers[firstIndex] = numbers[secondIndex]
      numbers[secondIndex] = temp
  }
}