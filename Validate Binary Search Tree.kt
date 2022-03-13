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
  fun isValidBST(root: TreeNode?): Boolean {
      return _isValidBST(root)
  }
  
  private fun _isValidBST(root: TreeNode?, smallest: Int? = null, largest: Int? = null): Boolean {
      if (root == null) {
          return true
      }
      
      val safeValue = root?.`val` ?: 0
      
      val isSmallerAndValid = smallest?.let { safeSmallest ->
          safeSmallest < safeValue
      } ?: true
      
      val isLargerAndValid = largest?.let { safeLargest ->
          safeLargest > safeValue
      } ?: true
      
      if (isSmallerAndValid.not() || isLargerAndValid.not()) {
          return false
      }
      
      return _isValidBST(root?.left, smallest, safeValue) && 
            _isValidBST(root?.right, safeValue, largest)
  }
}