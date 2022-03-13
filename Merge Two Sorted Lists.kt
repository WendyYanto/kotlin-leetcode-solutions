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
  var curr: ListNode? = null
  var head: ListNode? = null
  
  fun mergeTwoLists(firstL1: ListNode?, secondL2: ListNode?): ListNode? {
      
      var l1 = firstL1
      var l2 = secondL2
      
      while (l1 != null && l2 != null) {
          val firstNodeValue = l1?.`val` ?: 0
          val secondNodeValue = l2?.`val` ?: 0
          
          if (firstNodeValue < secondNodeValue) {
              updateNode(firstNodeValue)
              l1 = l1?.next

          } else {
              updateNode(secondNodeValue)
              l2 = l2?.next
          }
      }
      
      while (l1 != null) {
          val nodeValue = l1?.`val` ?: 0
          updateNode(nodeValue)
          l1 = l1?.next
      }
      
      while (l2 != null) {
          val nodeValue = l2?.`val` ?: 0
          updateNode(nodeValue)
          l2 = l2?.next
      }
      
      return head
  }
  
  private fun updateNode(value: Int) {
      curr?.let { safeCurr ->
          safeCurr.next = ListNode(value)
          curr = safeCurr.next
      } ?: run {
          curr = ListNode(value) 
          head = curr
      } 
  }
}