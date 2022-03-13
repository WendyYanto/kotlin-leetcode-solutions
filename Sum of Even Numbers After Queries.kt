class Solution {
  fun sumEvenAfterQueries(nums: IntArray, queries: Array<IntArray>): IntArray {
      var evenSum = 0
      val output = IntArray(queries.size) { 0 }
      
      for (number in nums) {
          if (number % 2 == 0) {
              evenSum += number
          }
      }
      
      for (i in 0..queries.size - 1) {
          val query = queries[i]
          val index = query[1]
          val value = query[0]
          val result = value + nums[index]
          
          // even
          if (nums[index] % 2 == 0) {
              if (result % 2 == 0) {
                  evenSum += value
              } else {
                  evenSum -= nums[index]
              }
          } else if (result % 2 == 0) {
              evenSum += result
          }
          
          nums[index] = result
          output[i] = evenSum 
      }
      
      return output
  }
}
