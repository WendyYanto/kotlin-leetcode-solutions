class Solution {
  fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val results: MutableList<Int> = mutableListOf()
    val sortedSet = TreeSet<Int>()
    val numbersCount: MutableMap<Int, Int> = mutableMapOf()
    var left = 0
    var right = 0
    var totalCount = 0
    
    while (right < nums.size) {
        sortedSet.add(nums[right])
        totalCount++
        val count = numbersCount.getOrPut(nums[right]) { 0 }
        numbersCount[nums[right]] = count + 1
        
        while (totalCount > k) {
            val leftCount = numbersCount.getOrPut(nums[left]) { 0 }
            numbersCount[nums[left]] = leftCount - 1
            totalCount--
            
            if (leftCount - 1 == 0) {
                sortedSet.remove(nums[left])
            }
            
            left++
        }
        
        if (totalCount == k) {
            results.add(sortedSet.last())
        }
        
        right++
    }
    
    return results.toIntArray()
  }
}

// Better solution
class Solution {
  fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
      val maxDequeIndex = ArrayDeque<Int>()
      var left = 0
      val results: MutableList<Int> = mutableListOf()
      
      for (i in 0 .. nums.size - 1) {
          val number = nums[i]
          
          // check if current first index is smaller than lowest window index
          val lowestIndex = i - k + 1
          while (maxDequeIndex.size > 0 && maxDequeIndex.peekFirst() < lowestIndex) {
              maxDequeIndex.pollFirst()
          }
          
          // make sure peekFirst() is always maximum
          while (maxDequeIndex.size > 0 && nums[maxDequeIndex.peekLast()] < number) {
              maxDequeIndex.pollLast()
          }
          
          maxDequeIndex.offer(i)
          val totalCount = i - left + 1
          
          if (totalCount == k) {
              // maximum always at the left
              // descending 
              results.add(nums[maxDequeIndex.peekFirst()])
              left++
          }
      }
      
      return results.toIntArray()
  }
}

