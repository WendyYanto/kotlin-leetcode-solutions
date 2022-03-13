class Solution {
  private val parent = IntArray(10005) { 0 }
  
  fun minimumCost(n: Int, connections: Array<IntArray>): Int {
      val sortedConnections = connections.sortedBy { it[2] }
      
      for (i in 1 .. n) {
          parent[i] = i
      }
      
      var count = 0
      
      for (index in 0 .. sortedConnections.size - 1) {
          val connection = sortedConnections[index]
          
          val from = connection[0]
          val to = connection[1]
          
          if (isSameParent(from, to)) {
              continue
          } else {
              count += connection[2]
              merge(from, to)
          }
      }
      
      var rootCount = 0
      
      for (i in 1 .. n) {
          if (parent[i] == i) {
              rootCount++
          }
      }
      
      if (rootCount == 1) {
          return count
      } else {
          return -1
      }
  }
  
  private fun findParent(n: Int): Int {
      if (parent[n] == n) {
          return parent[n]
      }
      
      return findParent(parent[n])
  }
  
  private fun isSameParent(first: Int, second: Int): Boolean {
      return findParent(first) == findParent(second)
  }
  
  private fun merge(first: Int, second: Int) {
      parent[findParent(first)] = findParent(second)
  }
}