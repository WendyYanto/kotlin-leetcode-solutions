class Solution {
  fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
      val nextGreaterIndexMap: MutableMap<Int, Int> = mutableMapOf()
      val nextGreaterIndexStack = ArrayDeque<Int>()
      
      nums2.forEachIndexed { index, value ->
        while (nextGreaterIndexStack.isNotEmpty() && 
          nums2[nextGreaterIndexStack.peek()] < value) {
            
            nextGreaterIndexMap[nums2[nextGreaterIndexStack.pop()]] = value
          }
          
        nextGreaterIndexStack.push(index)
      }
      
      return nums1.map { number ->
        nextGreaterIndexMap.getOrDefault(number, -1)
      }.toIntArray()
  }
}