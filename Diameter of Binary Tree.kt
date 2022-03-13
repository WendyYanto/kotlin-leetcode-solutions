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
  var maxNumber = -1
  
  fun diameterOfBinaryTree(root: TreeNode?): Int {
      maxDepth(root)
      
      return maxNumber
  }
  
  private fun maxDepth(root: TreeNode?): Int {
      if (root == null) {
          return 0
      }
      
      val leftDepth = maxDepth(root?.left)
      val rightDepth = maxDepth(root?.right)
      
      maxNumber = Math.max(leftDepth + rightDepth, maxNumber)
      
      return 1 + Math.max(leftDepth, rightDepth)
  }
}