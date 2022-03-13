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

  var output = 0
  
  fun equalToDescendants(root: TreeNode?): Int {
      traverse(root)
      
      return output
  }
  
  private fun traverse(root: TreeNode?): Int {
      if (root == null) {
          return 0
      }
      
      val count = traverse(root?.left) + traverse(root?.right)
      
      val value = root?.`val` ?: 0
      if (count == value) {
          output++
      }
      
      return count + value
  }    
}