class Solution {
  private lateinit var numbers: IntArray
  
  fun sortArray(nums: IntArray): IntArray {
      numbers = nums
      mergeSort(0, nums.size - 1)
      
      return numbers
  }

  private fun heapSort() {
    // build maxHeap
    val n = numbers.size
    val start = (n / 2) - 1
    
    for (i in start downTo 0) {
        heapify(n, i)
    }
    
    for (i in n - 1 downTo 0) {
        swap(i, 0)
        
        heapify(i, 0)
    }
}

private fun heapify(n: Int, i: Int) {
    var largestIndex = i
    val left = 2 * i + 1
    val right = 2 * i + 2
    
    if (left < n && numbers[left] > numbers[largestIndex]) {
        largestIndex = left
    }
    
    if (right < n && numbers[right] > numbers[largestIndex]) {
        largestIndex = right
    }
    
    if (largestIndex != i) {
        swap(largestIndex, i)
        heapify(n, largestIndex)
    }
}

private fun swap(left: Int, right: Int) {
    val temp = numbers[left]
    numbers[left] = numbers[right]
    numbers[right] = temp
}
  
  private fun mergeSort(left: Int, right: Int) {
      if (left >= right) {
          return
      }
      
      val mid = left + (right - left)/2
      mergeSort(left, mid)
      mergeSort(mid+1, right)
  
      merge(left, mid, right)
  }
  
  private fun merge(left: Int, mid: Int, right: Int) {
      val leftSortedArray: MutableList<Int> = mutableListOf()
      val rightSortedArray: MutableList<Int> = mutableListOf()

      for (i in left..mid) {
          leftSortedArray.add(numbers[i])
      }
      
      for (i in mid+1..right) {
          rightSortedArray.add(numbers[i])
      }
      
      var currLeft = left
      var leftIndex = 0
      var rightIndex = 0
      
      var leftSize = leftSortedArray.size
      var rightSize = rightSortedArray.size

      while (leftIndex < leftSize && rightIndex < rightSize) {
          if (leftSortedArray[leftIndex] < rightSortedArray[rightIndex]) {
              numbers[currLeft] = leftSortedArray[leftIndex]
              leftIndex++
          } else {
              numbers[currLeft] = rightSortedArray[rightIndex]
              rightIndex++
          }
          currLeft++
      }
      
      while (leftIndex < leftSize) {
          numbers[currLeft] = leftSortedArray[leftIndex]
          leftIndex++
          currLeft++
      }
      
      while (rightIndex < rightSize) {
          numbers[currLeft] = rightSortedArray[rightIndex]
          rightIndex++
          currLeft++
      }
  }
}