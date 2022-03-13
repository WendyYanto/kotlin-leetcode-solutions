class Solution {
  val graphs: MutableMap<Int, MutableList<Int>> = mutableMapOf()
  val visited: MutableList<Boolean> = mutableListOf()
  
  fun validPath(n: Int, edges: Array<IntArray>, start: Int, end: Int): Boolean {
      for (edge in edges) {
          val firstEdges = graphs.getOrDefault(edge[0], mutableListOf<Int>())
          firstEdges.add(edge[1])
          graphs[edge[0]] = firstEdges
          
          val secondEdges = graphs.getOrDefault(edge[1], mutableListOf<Int>())
          secondEdges.add(edge[0])
          graphs[edge[1]] = secondEdges
      }
      
      for (i in 0..n-1) {
          visited.add(false)
      }
      
      val q: Queue<Int> = LinkedList<Int>()
      q.add(start)
      
      while(q.isNotEmpty()) {
          val top = q.poll()
          visited[top] = true
          
          if (top == end) {
              return true
          }
          
          graphs.get(top)?.forEach { neighBours ->
              if (!visited[neighBours]) {
                  q.add(neighBours)
              }
          }
      }
      
      return false
  }
}