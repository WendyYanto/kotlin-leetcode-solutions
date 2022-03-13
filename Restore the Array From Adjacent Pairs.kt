class Solution {
    
  val graph: MutableMap<Int, MutableList<Int>> = mutableMapOf()
  val visited: MutableMap<Int, Boolean> = mutableMapOf()
  
  fun restoreArray(adjacentPairs: Array<IntArray>): IntArray { 
      
      for (adjacentPair in adjacentPairs) {
          if (graph[adjacentPair[0]] == null) {
              graph[adjacentPair[0]] = mutableListOf()
          } 
          if (graph[adjacentPair[1]] == null) {
              graph[adjacentPair[1]] = mutableListOf()
          }
          
          graph[adjacentPair[0]]?.add(adjacentPair[1])
          graph[adjacentPair[1]]?.add(adjacentPair[0])
          
          visited[adjacentPair[0]] = false
          visited[adjacentPair[1]] = false
      }
      
      val start = graph
          .asIterable()
          .first { (key, value) -> value.size == 1 }
          .key
      
      return dfs(start, mutableListOf()).toIntArray()
  }
  
  private fun dfs(start: Int, output: MutableList<Int>): MutableList<Int>  {
      visited[start] = true
      output.add(start)
      
      graph[start]?.filter { neighBour ->
        visited[neighBour] == false
      }?.forEach { neighBour ->
        dfs(neighBour, output)
      }
      
      return output
  }
}
