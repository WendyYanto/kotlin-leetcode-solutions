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
  private val cachedList: MutableMap<Int, MutableList<Int>> = mutableMapOf()
  private var left = 0
  private var right = 0
  
  fun verticalOrder(root: TreeNode?): List<List<Int>> {
      if (root == null) {
          return emptyList()
      }
      
      traverse(root, 0)
      
      return (left..right).map { value ->
              cachedList[value].orEmpty()
          }
          .orEmpty()
  }
  
  private fun traverse(root: TreeNode?, column: Int) {
      val nodeQueue: Queue<Pair<TreeNode?, Int>> = LinkedList()
      
      nodeQueue.add(root to column)
      
      while (nodeQueue.isNotEmpty()) {
          val topNode = nodeQueue.poll()
          val column = topNode.second
          
          left = minOf(left, column)
          right = maxOf(right, column)
          
          val nodes = cachedList.getOrPut(column) { mutableListOf() }
          
          val safeValue = topNode.first?.`val` ?: 0
          nodes.add(safeValue)
          
          val leftNode = topNode?.first?.left 
          if (leftNode != null) {
              nodeQueue.add(leftNode to column - 1)
          }
          
          val rightNode = topNode?.first?.right
          if (rightNode != null) {
              nodeQueue.add(rightNode to column + 1)
          }
      }
  }
}