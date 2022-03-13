
/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
  private val cache: MutableMap<Int, Node> = mutableMapOf()
  
  fun cloneGraph(node: Node?): Node? {
      if (node == null) {
          return null
      }
      
      val safeValue = node?.`val` ?: 0
      
      if (cache[safeValue] != null) {
          return cache[safeValue]
      }
      
      val cachedNode = cache.getOrPut(safeValue) { Node(safeValue) }
      
      val safeNeighbors = node?.neighbors ?: arrayListOf()
      
      for (neighbor in safeNeighbors) {
          cachedNode.neighbors.add(cloneGraph(neighbor))
      }
      
      return cachedNode
  }
}