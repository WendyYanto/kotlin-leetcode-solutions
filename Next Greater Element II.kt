class Solution {
  fun nextGreaterElements(nums: IntArray): IntArray {
      val prevStack = ArrayDeque<Pair<Int, Int>>()
      val results = IntArray(nums.size) { -1 }
      
      for (i in 0.. (2 * nums.size - 1)) {
          val num = nums[i % nums.size]
          while (prevStack.size > 0 && prevStack.peek().first < num) {
              results[prevStack.poll().second % nums.size] = num
          }
          
          prevStack.push(num to i)
      }
      
      return results
  }
}