class Solution {
  private lateinit var numbers: IntArray
  
  fun findKthLargest(nums: IntArray, k: Int): Int {
      numbers = nums
      // quick select
      return quickSelect(0, nums.size - 1, nums.size - k)
  }
  
  private fun quickSelect(left: Int, right: Int, k: Int): Int {
      if (left == right) {
          return numbers[left]
      }
      
      val mid = partition(left, right)
      if (mid == k) {
          return numbers[mid]
      } else if (mid < k) {
          return quickSelect(mid + 1, right, k)
      } else {
          return quickSelect(left, mid - 1, k)
      }
  }
  
  private fun partition(left: Int, right: Int): Int {
      // pivot
      val pivot = numbers[right]
      
      var i = left
      var j = left
      
      while (j <= right - 1) {
          if (numbers[j] <= pivot) {
              swap(j, i)
              i++
          }
          j++
      }
      
      swap(i, right)
      
      return i
  }
  
  private fun swap(firstIndex: Int, secondIndex: Int) {
      val temp = numbers[firstIndex]
      numbers[firstIndex] = numbers[secondIndex]
      numbers[secondIndex] = temp
  }
}
  
