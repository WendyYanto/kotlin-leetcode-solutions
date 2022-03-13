class Solution {
  fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
      val priorityQueue = PriorityQueue<Int>()
      
      for (numbers in matrix) {
          for (number in numbers) {
              priorityQueue.add(number)
          }
      }
      
      var count = k - 1
      
      while (count > 0) {
          priorityQueue.poll()
          count--
      }
      
      return priorityQueue.peek()
  }
}

// M * N * log (k)
class Solution {
  M * N * log k
  fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
      val priorityQueue = PriorityQueue<Int>(compareByDescending { it })
      
      for (numbers in matrix) {
          for (number in numbers) {
              if (priorityQueue.size < k) {
                  priorityQueue.add(number)   
              } else {
                  if (priorityQueue.peek() > number) {
                      priorityQueue.poll()
                      priorityQueue.add(number)
                  }
              }
          }
      }
      
      return priorityQueue.peek()
  }
}