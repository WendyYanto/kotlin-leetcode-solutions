class Solution {
  private val graph: MutableMap<Int, MutableList<Int>> = mutableMapOf()
  private val visited = BooleanArray(2005) { false }
  
  fun countComponents(n: Int, edges: Array<IntArray>): Int {
      val vertexes: MutableSet<Int> = mutableSetOf()
      
      for (edge in edges) {
          val fromNeighbors = graph.getOrPut(edge[0]) { mutableListOf() }
          val toNeighbors = graph.getOrPut(edge[1]) { mutableListOf() }
          
          fromNeighbors.add(edge[1])
          toNeighbors.add(edge[0])
          
          vertexes.add(edge[0])
          vertexes.add(edge[1])
      }
      
      var count = 0
      
      for (i in 0 .. n - 1) {
          if (!visited[i]) {
              count++
              floodfill(i)
          }
      }
      
      return count
  }
  
  private fun floodfill(vertex: Int) {
      visited[vertex] = true
      
      val safeNeighbors = graph[vertex] ?: mutableListOf()
      
      for (neighbor in safeNeighbors) {
          if (visited[neighbor].not()) {
              floodfill(neighbor)
          }
      }
  }
}