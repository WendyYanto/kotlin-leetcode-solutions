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
  var diff = 0
  
  fun maxAncestorDiff(root: TreeNode?): Int {
      val safeValue = root?.`val` ?: 0
      
      getMaxAncestorDiff(root, safeValue, safeValue)
      
      return diff
  }
  
  private fun getMaxAncestorDiff(root: TreeNode?, smallestAncestor: Int, largestAncestor: Int) {
     if (root == null) {
         return
     }
      
      val value = root?.`val` ?: 0

      val smallestDiff = Math.abs(smallestAncestor - value)
      val largestDiff = Math.abs(largestAncestor - value)
      val currentLargestDiff = Math.max(smallestDiff, largestDiff)
          
      diff = Math.max(currentLargestDiff, diff)
      
      val nextSmallestAncestor = Math.min(smallestAncestor, value)
      val nextLargestAncestor = Math.max(largestAncestor, value)
      
      getMaxAncestorDiff(root?.left, nextSmallestAncestor, nextLargestAncestor)
      getMaxAncestorDiff(root?.right, nextSmallestAncestor, nextLargestAncestor)
  }
}