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
  private val cacheDepth: MutableMap<TreeNode, Int> = mutableMapOf()
  
  fun isBalanced(root: TreeNode?): Boolean {
      return _isBalanced(root, 1)
  }
  
  fun _isBalanced(root: TreeNode?, depth: Int): Boolean {
      if (root == null) {
          return true
      }
      
      val leftDepth = getDepth(root?.left, depth)
      val rightDepth = getDepth(root?.right, depth)
      
      if (Math.abs(rightDepth - leftDepth) > 1) {
          return false
      }
      
      return _isBalanced(root?.left, depth + 1) && _isBalanced(root?.right, depth + 1)
  }
  
  
  fun getDepth(root: TreeNode?, depth: Int): Int {
      if (root == null) {
          return depth - 1
      }
      
      if (cacheDepth.containsKey(root!!)) {
          return cacheDepth[root!!]!!
      }
      
      if (root?.left == null && root?.right == null) {
          cacheDepth[root!!] = depth
          return depth
      }
      
      val result = Math.max(getDepth(root?.left, depth + 1), getDepth(root?.right, depth + 1))
      cacheDepth[root!!] = result
      return result
  }
}