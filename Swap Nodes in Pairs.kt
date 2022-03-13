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
  fun swapPairs(head: ListNode?): ListNode? {
      var curr = head
      var newHead: ListNode? = null
      var prev: ListNode? = null
      
      while (curr != null) {
          val nextCurr = curr?.next
          val nextOfNextCurr = nextCurr?.next
          
          // if node only one
          if (prev == null && nextCurr == null) {
              return head
          }
          
          prev?.next = if (nextCurr == null) {
              // if odd
              curr
          } else {
              // if even
              nextCurr
          }
          
          nextCurr?.next = curr
          curr?.next = nextOfNextCurr
          
          if (curr == head) {
              // assign new head
              newHead = nextCurr
          }
          
          prev = curr
          curr = curr?.next
      }
      
      return newHead
  }
}