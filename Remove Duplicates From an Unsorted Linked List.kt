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
  private val cached: MutableMap<Int, Int> = mutableMapOf()
  private val dummyHead = ListNode()
  
  fun deleteDuplicatesUnsorted(head: ListNode?): ListNode? {
      var curr = head
      
      while (curr != null){
          val key = curr?.`val` 
          
          key?.let { safeKey ->
              val value = cached.getOrPut(safeKey) { 0 }
              cached[safeKey] = 1 + value 
          }
          
          curr = curr?.next
      }
      
      curr = head
      var dummyCurr = dummyHead  
      while (curr != null) {
          val key = curr?.`val` ?: -1
          
          if (cached[key] == 1) {
              dummyCurr?.next = curr
              dummyCurr = dummyCurr?.next
          }
          
          curr = curr?.next
      }
      
      dummyCurr?.next = null
      
      return dummyHead.next
  }
}