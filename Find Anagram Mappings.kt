class Solution {
  fun anagramMappings(nums1: IntArray, nums2: IntArray): IntArray {
      val indexToValueMap: MutableMap<Int, Queue<Int>> = mutableMapOf()
      
      for (i in 0..nums2.size - 1) {
          val indexQueue = indexToValueMap.getOrPut(nums2[i]) { LinkedList<Int>() }
          indexQueue.add(i)
      }
      
      return nums1.map { value ->
          indexToValueMap[value]?.poll() ?: 0
      }.toIntArray()
  }
}