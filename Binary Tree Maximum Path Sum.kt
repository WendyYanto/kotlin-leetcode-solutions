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
  var maxNumber = Int.MIN_VALUE
  
  fun maxPathSum(root: TreeNode?): Int {
      maxNodeSum(root)
      return maxNumber
  }
  
  private fun maxNodeSum(root: TreeNode?): Int {
      if (root == null) {
          return 0
      }
      
      // if negative , no need to add it
      val leftMax = maxOf(maxNodeSum(root?.left), 0)
      val rightMax = maxOf(maxNodeSum(root?.right), 0)
      
      val curr = root?.`val` ?: 0
      
      maxNumber = maxOf(maxNumber, curr + leftMax + rightMax)
      
      return curr + maxOf(leftMax, rightMax)
  }
}