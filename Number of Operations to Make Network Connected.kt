class Solution {
  val parent = IntArray(100005) 
  
  fun makeConnected(n: Int, connections: Array<IntArray>): Int {
      if (connections.size < n - 1) {
          return -1
      }
      
      for (i in 0 .. n - 1) {
          parent[i] = i
      }
      var maxEdges = n - 1
      var count = 0
      
      for (connection in connections) {
          if (!isSameParent(connection[0], connection[1])) {
              count++
              merge(connection[0], connection[1])
          }
      }
      
      return maxEdges - count
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
      parent[findParent(first)] = parent[second]
  }
}