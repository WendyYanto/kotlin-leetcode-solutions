class Solution {
  fun nextPermutation(nums: IntArray): Unit {
      var index = nums.size - 2
      
      // always look for first decreasing pair
      while (index >= 0) {
          if (nums[index] < nums[index+1]) {
              break
          }
          index--
      }
      
      if (index >= 0) {
          // search for index before pivot that is larger
          var j = nums.size - 1
          
          while (nums[j] <= nums[index]) {
              j--
          }

          swap(nums, index, j)
      }
      
      var reverseIndex = index + 1
      var lastIndex = nums.size - 1
      
      while (reverseIndex < lastIndex) {
          // to the smallest possible
          swap(nums, reverseIndex, lastIndex)
          reverseIndex++
          lastIndex--
      }
  }
  
  private fun swap(nums: IntArray, left: Int, right: Int) {
      val temp = nums[left]
      nums[left] = nums[right]
      nums[right] = temp
  }
}