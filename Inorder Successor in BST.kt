/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
  private var prev: TreeNode? = null
  private var selectedNode: TreeNode? = null
  
  fun inorderSuccessor(root: TreeNode?, p: TreeNode?): TreeNode? {
      traverse(root, p)
      
      return selectedNode
  }
  
  private fun traverse(root: TreeNode?, p: TreeNode?) {
      if (root == null) {
          return
      }
          
      traverse(root?.left, p)

      if (prev == p) {
          selectedNode = root
      }
      
      // save current as prev
      prev = root
      
      traverse(root?.right, p)
  }
}