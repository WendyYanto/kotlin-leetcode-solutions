class Solution {
  fun minProductSum(nums1: IntArray, nums2: IntArray): Int {
      val sortedNum1 = nums1.sorted()
      val sortedNum2 = nums2.sorted()
      
      var sum = 0
      
      for (i in 0 .. sortedNum1.size - 1) {
          sum += (sortedNum1[i] * sortedNum2[sortedNum2.size - 1 - i])
      }
      
      return sum
  }
}