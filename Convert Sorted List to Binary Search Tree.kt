/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
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
  fun sortedListToBST(head: ListNode?): TreeNode? {
      return constructNode(head)
  }
  
  private fun constructNode(root: ListNode?): TreeNode? {
      if (root == null) {
          return null
      }
      
      var prevSlow: ListNode? = null
      var slow = root
      var fast = root
      
      while (fast?.next != null && fast != null) {
          prevSlow = slow
          slow = slow?.next
          fast = fast?.next?.next
      }
      
      prevSlow?.next = null
      
      val value = slow?.`val` ?: 0
      
      val currentNode = TreeNode(value)
      
      if (slow == root) {
          return currentNode
      }
      
      currentNode?.left = constructNode(root)
      currentNode?.right = constructNode(slow?.next)
      
      return currentNode
  }
}