class Solution {
  fun minSetSize(arr: IntArray): Int {
      val compareByFrequency: Comparator<Pair<Int, Int>> = compareByDescending { it.first }
      val arrayToRemovedQueue = PriorityQueue<Pair<Int, Int>>(compareByFrequency)
      
      arr.toList()
        .groupingBy { it }
        .eachCount()
        .forEach { key, value -> arrayToRemovedQueue.add(value to key) }
        
      var count = 0
      val halfCount = arr.size / 2
      var number = 0
      
      while (count < halfCount && arrayToRemovedQueue.isNotEmpty()) {
          count += arrayToRemovedQueue.poll().first
          number++
      }
      
      return number
  }
}