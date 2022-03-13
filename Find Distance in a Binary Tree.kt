/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
  private val graph: MutableMap<Int, MutableList<Int>> = mutableMapOf()
  private val visited: MutableMap<Int, Int> = mutableMapOf()
  
  fun findDistance(root: TreeNode?, p: Int, q: Int): Int {
      generateGraph(root)
      
      val graphQueue: Queue<Int> = LinkedList<Int>()
      graphQueue.add(p)
      visited[p] = 0
      
      while (graphQueue.isNotEmpty()) {
          val top = graphQueue.poll()
          val visitedValue = visited[top] ?: 0
          
          if (top == q) {
              return visitedValue
          }
          
          val neighbors = graph[top].orEmpty()
          
          for (neighbor in neighbors) {
              if (!visited.contains(neighbor)) {
                  visited[neighbor] = visitedValue + 1
                  graphQueue.add(neighbor)
              }
          }
      }
      
      return -1
  }
  
  private fun generateGraph(root: TreeNode?) {
      if (root == null) {
          return
      }
      
      val rootValue = root?.`val`
      
      val rootNeighbors = graph.getOrPut(rootValue) { mutableListOf() }
      
      if (root?.left != null) {
          val leftValue = root?.left?.`val` ?: 0
          rootNeighbors.add(leftValue)
          val leftNeighbors = graph.getOrPut(leftValue) { mutableListOf() }
          leftNeighbors.add(rootValue)
      }

      if (root?.right != null) {
          val rightValue = root?.right?.`val` ?: 0
          rootNeighbors.add(rightValue)
          val rightNeighbors = graph.getOrPut(rightValue) { mutableListOf() }
          rightNeighbors.add(rootValue)
      }
          
      generateGraph(root?.left)
      generateGraph(root?.right)
  }
}