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
  private lateinit var numbers: IntArray
  
  fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
      numbers = nums
      return constructNode(0, numbers.size - 1)
  }
  
  private fun constructNode(left: Int, right: Int): TreeNode? {
      if (left > right) {
          return null
      }
      
      var largestNumber = -1
      var largestIndex = -1
      
      for (i in left .. right) {
          if (numbers[i] > largestNumber) {
              largestNumber = numbers[i]
              largestIndex = i
          }
      }
      
      val node = TreeNode(largestNumber)
      
      node?.left = constructNode(left, largestIndex - 1)
      node?.right = constructNode(largestIndex + 1, right)
      
      return node
  }
  
}