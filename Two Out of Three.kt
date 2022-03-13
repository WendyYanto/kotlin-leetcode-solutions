class Solution {
  fun twoOutOfThree(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> {
      val data = nums1 + nums2 + nums3
      val uniqueData = data.toSet()
      
      val nums1Map = nums1.toList().groupingBy { it }.eachCount()
      val nums2Map = nums2.toList().groupingBy { it }.eachCount()
      val nums3Map = nums3.toList().groupingBy { it }.eachCount()
      
      return uniqueData.filter { num -> 
          var count = 0
          
          if (nums1Map.containsKey(num)) {
              count++
          }
          if (nums2Map.containsKey(num)) {
              count++
          } 
          if (nums3Map.containsKey(num)) {
              count++
          } 
          
          return@filter count >= 2
      }
  }
}