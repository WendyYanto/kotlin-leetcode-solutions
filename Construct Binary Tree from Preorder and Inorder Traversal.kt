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
  private val indexOfValueMap: MutableMap<Int, Int> = mutableMapOf()
  
  private lateinit var preorder: IntArray
  
  private lateinit var inorder: IntArray
  
  private var preorderIndex = 0
  
  fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
      
      this.inorder = inorder
      this.preorder = preorder
      
      inorder.forEachIndexed { index, value ->
          indexOfValueMap[value] = index
      }
      
      return constructNode(0, inorder.size - 1)
  }
  
  private fun constructNode(left: Int, right: Int): TreeNode? {
      if (left > right) {
          return null
      }
      
      val rootValue = preorder[preorderIndex]
      val rootNode = TreeNode(rootValue)
      val index = indexOfValueMap[rootValue] ?: 0
      
      preorderIndex++
      rootNode?.left = constructNode(left, index - 1)
      rootNode?.right = constructNode(index + 1, right)
      
      return rootNode
  }
}