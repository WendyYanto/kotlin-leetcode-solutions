class Solution {
  fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
      val closestPointComparator: Comparator<Pair<Int, IntArray>> = compareBy { it.first }
      
      val closestPointQueue = PriorityQueue<Pair<Int, IntArray>>(closestPointComparator)
      
      for (point in points) {
          val distance = point[0]*point[0] + point[1]*point[1]
          closestPointQueue.add(distance to point)
      }
      
      return (1..k).map { 
        closestPointQueue.poll().second
      }.toTypedArray()
  }
}

// Better Solution

class Solution {
  val distances: MutableList<Pair<Int, IntArray>> = mutableListOf()
  
  fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
      
      for (point in points) {
          val distance = point[0]*point[0] + point[1]*point[1]
          distances.add(distance to point)
      }
      
      quickSelect(0, distances.size - 1, k - 1)
      
      return (0..(k-1)).map { index ->
          distances[index].second
      }.toTypedArray()
  }
  
  private fun quickSelect(left: Int, right: Int, k: Int) {
      if (left >= right) {
          return
      }
      
      val mid = partition(left, right)
      
      if (mid == k) {
          return
      }
      if (mid > k) { 
          quickSelect(left, mid - 1, k)
      } else {
          quickSelect(mid + 1, right, k)
      }
  }
  
  private fun partition(left: Int, right: Int): Int {
      val pivot = distances[right]
      
      var i = left
      var j = left
      
      while (j <= (right - 1)) {
          if (distances[j].first <= pivot.first) {
             swap(i, j)
             i++
          }
          j++
      }
      
      swap(i, right)
      
      return i
  }
  
  private fun swap(firstIndex: Int, secondIndex: Int) {
      val temp = distances[firstIndex]
      distances[firstIndex] = distances[secondIndex]
      distances[secondIndex] = temp
  }
}