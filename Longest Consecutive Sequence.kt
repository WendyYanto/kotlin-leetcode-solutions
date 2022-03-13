class Solution {
  fun longestConsecutive(nums: IntArray): Int {
      if (nums.size == 0) {
          return 0
      }
      
      val numbers = nums.distinct().sorted()
      
      var lastIndex = 0
      var maxLength = 1
      
      for (i in 1 .. numbers.size - 1) {
          if (Math.abs(numbers[i] - numbers[i - 1]) == 1) {
              maxLength = maxOf(maxLength, i - lastIndex + 1)
              continue
          } else {
              lastIndex = i
          }
      }
      
      return maxLength
  }

  // Better
  fun longestConsecutive(nums: IntArray): Int {
    val numberSet = nums.toMutableSet()
    var result = 0
    
    for (num in numberSet) {
        if (numberSet.contains(num-1).not()) {
            var count = 1
            var curr = num
            
            while (numberSet.contains(curr + 1)) {
                count++
                curr++
            }
            
            result = maxOf(result, count)
        }
    }
    
    return result
}
}