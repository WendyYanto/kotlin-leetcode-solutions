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
    
  fun deleteMiddle(head: ListNode?): ListNode? {
      val dummyHead = ListNode(-1)
      dummyHead?.next = head
      
      var slow: ListNode? = dummyHead
      var fast: ListNode? = dummyHead
      var prevSlow: ListNode? = null
      
      while (fast?.next != null) {
          fast = fast?.next?.next
          prevSlow = slow
          slow = slow?.next
      }
      
      if (fast == null) {
          prevSlow?.next = slow?.next
      } else {
          slow?.next = slow?.next?.next
      }
      
      return dummyHead?.next
  }
}