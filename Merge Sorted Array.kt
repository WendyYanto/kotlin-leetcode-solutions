class Solution {
  fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
      var indexNum1 = m - 1
      var indexNum2 = n - 1
      
      var currIndex = m + n - 1
      
      while (indexNum1 >= 0 && indexNum2 >= 0) {
          if (nums1[indexNum1] < nums2[indexNum2]) {
              nums1[currIndex] = nums2[indexNum2]
              currIndex--
              indexNum2-- 
          } else {
              nums1[currIndex] = nums1[indexNum1]
              currIndex--
              indexNum1-- 
          }
      }
      
      while(indexNum2 >= 0) {
          nums1[currIndex] = nums2[indexNum2]
          currIndex--
          indexNum2-- 
      }
  }
}