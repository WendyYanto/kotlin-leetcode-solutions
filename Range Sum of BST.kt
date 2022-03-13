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
  private var sum = 0
  
  fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
      traverse(root, low, high)
      
      return sum
  }
  
  private fun traverse(root: TreeNode?, low: Int, high: Int) {
      if (root == null) {
          return
      }
      
      val value = root?.`val` ?: 0
      
      if (value >= low && value <= high) {
          sum += value
      }
      
      traverse(root?.left, low, high)
      traverse(root?.right, low, high)
  }
}