class Solution {
  fun thirdMax(nums: IntArray): Int {
      val distinctNumbers = nums.distinct()
      
      var largest = Long.MIN_VALUE
      var secondLargest = Long.MIN_VALUE
      var thirdLargest = Long.MIN_VALUE
      
      for (i in distinctNumbers) {
          val number = i.toLong()
          if (number > largest) {
              thirdLargest = secondLargest
              secondLargest = largest
              largest = number
          } else if (number > secondLargest) {
              thirdLargest = secondLargest
              secondLargest = number
          } else if (number > thirdLargest) {
              thirdLargest = number
          }
      }
      
      return if (thirdLargest != Long.MIN_VALUE) {
          return thirdLargest.toInt()
      } else {
          return largest.toInt()
      }
  }
}