class Solution {
  private val memo = Array(1005) { IntArray(1005) { -1 } }
  
  fun findLength(nums1: IntArray, nums2: IntArray): Int {
      return dp(0, 0, nums1, nums2)
  }
  
  private fun dp(nums1Index: Int, nums2Index: Int, nums1: IntArray, nums2: IntArray): Int {
      if (nums1Index == nums1.size || nums2Index == nums2.size) {
          return 0
      }
      
      if (memo[nums1Index][nums2Index] != -1) {
          return memo[nums1Index][nums2Index]
      }
      
      var count = 0
      var currNum1 = nums1Index
      var currNum2 = nums2Index
      
      if (nums1[currNum1] == nums2[currNum2]) {
          while (currNum1 < nums1.size && currNum2 < nums2.size 
                 && (nums1[currNum1] == nums2[currNum2])) {
              count++
              currNum1++
              currNum2++
          }
      }
      
      val result = maxOf(count, dp(nums1Index + 1, nums2Index, nums1, nums2), dp(nums1Index, nums2Index + 1, nums1, nums2))
      
      memo[nums1Index][nums2Index] = result
      
      return result
  }
}