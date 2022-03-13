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
  fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
      val reversedHead = reversedNode(head)
      
      var prev: ListNode? = null
      var curr: ListNode? = reversedHead
      
      for (i in 2..n) {
          prev = curr
          curr = curr?.next
      }
      
      if (prev == null) {
          curr = curr?.next
          return reversedNode(curr)
      } else {
          prev?.next = curr?.next   
      }
      
      return reversedNode(reversedHead)
  }
  
  fun reversedNode(head: ListNode?): ListNode? {
      var curr: ListNode? = head
      var prev: ListNode? = null
      
      while(curr != null) {
          val temp = curr?.next
          
          curr?.next = prev
          prev = curr
          
          curr = temp
      }
      
      return prev
  }
}