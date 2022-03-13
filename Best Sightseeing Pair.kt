class Solution {
  fun maxScoreSightseeingPair(values: IntArray): Int {
      var maxNumber = 0
      var result = 0
      
      for (value in values) {
          result = maxOf(result, maxNumber + value)
          // always minus one because diff always one in (i+1) after (i)
          maxNumber = maxOf(maxNumber, value) - 1
      }
      
      return result
  }
}