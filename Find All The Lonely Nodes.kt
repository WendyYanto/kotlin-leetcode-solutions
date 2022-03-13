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
    
  fun getLonelyNodes(root: TreeNode?): List<Int> {
      val output: MutableList<Int> = mutableListOf()
      traverse(root, true, output)
      return output
  }
  
  private fun traverse(root: TreeNode?, hasTwoChild: Boolean, output: MutableList<Int>) {
      if (root == null) {
          return
      }
      
      if (hasTwoChild.not()) {
          output.add(root?.`val` ?: 0)
      }
      
      val hasTwoChild = root?.left != null && root?.right != null
      
      traverse(root?.left, hasTwoChild, output)
      traverse(root?.right, hasTwoChild, output)
  }
}