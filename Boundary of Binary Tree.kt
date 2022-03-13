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
  private val left: MutableList<Int> = mutableListOf()
  private val right: MutableList<Int> = mutableListOf()
  private val leaves: MutableList<Int> = mutableListOf()
  
  fun boundaryOfBinaryTree(root: TreeNode?): List<Int> {
      if (root?.left == null && root?.right == null) {
          return listOf(root?.`val` ?: 0)
      }
      
      traverse(root)
      getLeaves(root)
      
      return listOf(root?.`val` ?: 0) + left + leaves + right.reversed()
  }
  
  private fun getLeaves(root: TreeNode?) {
      if (root == null) {
          return
      }
      
      if (root?.left == null && root?.right == null) {
          leaves.add(root?.`val` ?: 0)
      }
      
      getLeaves(root?.left)
      getLeaves(root?.right)
  }
  
  private fun traverse(root: TreeNode?) {
      val nodeQueue: Queue<TreeNode?> = LinkedList<TreeNode?>()
      nodeQueue.add(root?.left)
      nodeQueue.add(root?.right)
      
      var hasFoundRightLeaves = false
      var hasFoundLeftLeaves = false
      
      while (nodeQueue.isNotEmpty()) {
          var size = nodeQueue.size
          
          val nodes: MutableList<TreeNode?> = mutableListOf()
          
          while (size > 0) {
              val topNode = nodeQueue.poll()
              
              nodes.add(topNode)
              
              if (topNode?.left != null) {
                  nodeQueue.add(topNode?.left)
              }
              
              if (topNode?.right != null) {
                  nodeQueue.add(topNode?.right)
              }
              
              size--
          }
          
          if (nodes.isNotEmpty()) {
              if (nodes.first()?.left != null || nodes.first()?.right != null) {
                  if (hasFoundLeftLeaves == false) {
                      left.add(nodes.first()?.`val` ?: 0)
                  }
              } else {
                  hasFoundLeftLeaves = true
              }
              
              if (nodes.last()?.left != null || nodes.last()?.right != null) {
                  if (hasFoundRightLeaves == false) {
                      right.add(nodes.last()?.`val` ?: 0)                        
                  }
              } else {
                  hasFoundRightLeaves = true
              }
          }
      }
  }
}