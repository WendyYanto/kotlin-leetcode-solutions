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
  var totalCount = 0
  
  fun rotateRight(head: ListNode?, k: Int): ListNode? {
      if (head == null || k == 0) {
          return head
      }
      
      var curr: ListNode? = head
      
      while (curr != null) {
          totalCount++
          curr = curr?.next
      }
      
      var loopCounter = totalCount - (k%totalCount)
      
      var prev: ListNode? = null
      curr = head
      
      while (loopCounter > 0) {
          prev = curr
          curr = curr?.next
          loopCounter--
      }
      
      // if loopCounter == size of node
      // then no need to rotate
      if (curr == null) {
          return head
      }
      
      prev?.next = null
      var newHead = curr
      while(curr != null) {
          prev = curr
          curr = curr?.next
      }
      
      prev?.next = head
      
      return newHead
  }
}