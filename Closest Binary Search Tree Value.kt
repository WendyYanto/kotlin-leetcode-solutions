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
  private var minDiff: Double = Double.MAX_VALUE
  private var closestValue = -1
  
  fun closestValue(root: TreeNode?, target: Double): Int {
      traverse(root, target)
      
      return closestValue
  }
  
  private fun traverse(root: TreeNode?, target: Double) {
      if (root == null) {
          return
      }
      
      val value = root?.`val` ?: 0
      
      if (Math.abs(target - value) < minDiff) {
          minDiff = Math.abs(target - value)
          closestValue = value
      }
      
      if (value.toDouble() > target) {
          traverse(root?.left, target)
      } else {
          traverse(root?.right, target)
      }
  }
}