/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
  private val dummyHead = ListNode(0)
  
  fun plusOne(head: ListNode?): ListNode? {
      dummyHead?.next = head
      var curr = dummyHead
      var reversedNode = reverse(curr)
      val originReversedNode = reversedNode
      
      var remainder = 1
      while (reversedNode != null) {
          val value = reversedNode?.`val` ?: 0
          
          var nextValue = value + remainder
          
          if (nextValue >= 10) {
              remainder = nextValue / 10
              nextValue = nextValue % 10
          } else {
              remainder = 0
          }
          
          reversedNode?.`val` = nextValue
          
          reversedNode = reversedNode?.next
      }
      
      val resultNode = reverse(originReversedNode)
      
      if (resultNode?.`val` == 0) {
          return resultNode?.next
      } else {
          return resultNode
      }
  }
  
  private fun reverse(node: ListNode?): ListNode? {
      var curr = node
      var prev: ListNode? = null
      
      while (curr != null) {
          val temp = curr?.next
          curr?.next = prev
          prev = curr
          curr = temp
      }
      
      return prev
  }
}