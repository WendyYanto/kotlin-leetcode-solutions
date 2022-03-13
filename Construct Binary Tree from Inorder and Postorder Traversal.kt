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
  private val cachedIndex: MutableMap<Int, Int> = mutableMapOf()
  private lateinit var inorderArray: IntArray
  private lateinit var postorderArray: IntArray
  
  private var postOrderIndex = 0
  
  fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
      inorderArray = inorder
      postorderArray = postorder
      
      for (i in 0 .. inorder.size - 1) {
          cachedIndex[inorder[i]] = i 
      }
      
      postOrderIndex = inorder.size - 1
      
      return getRootNode(0, inorder.size - 1)
  }
  
  private fun getRootNode(left: Int, right: Int): TreeNode? {
      if (left > right) {
          return null
      }
      
      val nodeValue = postorderArray[postOrderIndex]
      val node = TreeNode(nodeValue)
      val index = cachedIndex[nodeValue] ?: 0
      
      postOrderIndex--
      
      node?.right = getRootNode(index + 1, right)
      node?.left = getRootNode(left, index - 1)
      
      return node
  }
}

