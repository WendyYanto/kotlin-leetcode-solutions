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
  private val cachedNode: MutableMap<Int, MutableList<Int>> = mutableMapOf()
  
  fun findLeaves(root: TreeNode?): List<List<Int>> {
      groupByHeight(root)
      
      var height = 1
      var results: MutableList<List<Int>> = mutableListOf()
      while (cachedNode[height] != null) {
          results.add(cachedNode[height].orEmpty())
          height++
      }
      
      return results
  }
  
  private fun groupByHeight(root: TreeNode?): Int {
      if (root == null) {
          return 0
      }
      
      val height = 1 + maxOf(groupByHeight(root?.left), groupByHeight(root?.right))
      
      val nodes = cachedNode.getOrPut(height) { mutableListOf() }
      
      nodes.add(root?.`val` ?: 0)
      
      return height
  }
}