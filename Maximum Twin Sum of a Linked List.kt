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
  fun pairSum(head: ListNode?): Int {
      var slow = head
      var fast = head
      
      while (slow != null && fast != null) {
          slow = slow?.next
          fast = fast?.next?.next
      }
      
      var newHead = reverse(slow)
      var maximumResult = 0
      
      var currHead = head
      
      while (newHead != null && currHead != null) {
          val reversedValue = newHead?.`val` ?: 0
          val value = currHead?.`val` ?: 0
          
          maximumResult = maxOf(maximumResult, value + reversedValue)  
          
          newHead = newHead?.next
          currHead = currHead?.next
      }
      
      return maximumResult
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