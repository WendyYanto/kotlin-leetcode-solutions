class Solution {
  fun minSwaps(numbers: IntArray): Int {
      var totalOnes = 0
      for (number in numbers) {
          if (number == 1) {
              totalOnes++
          }
      }
      
      var minSwap = numbers.size
      var count = 0
      for (i in 0 .. totalOnes - 1) {
          count += numbers[i]
      }
      
      minSwap = minOf(minSwap, totalOnes - count)
      
      for (i in totalOnes .. numbers.size - 1) {
          count -= numbers[i - totalOnes]
          count += numbers[i]
          
          minSwap = minOf(minSwap, totalOnes - count)
      }
      
      return minSwap
  }
}