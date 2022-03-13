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
  fun oddEvenList(head: ListNode?): ListNode? {
      val firstOddNode = head
      val firstEvenNode = head?.next
      
      var currEvenNode = firstEvenNode
      var currOddNode = firstOddNode
      
      var curr = firstEvenNode
      
      while (curr != null) {
          val nextOdd = curr?.next
          val nextEven = nextOdd?.next
          
          currOddNode?.next = nextOdd
          currEvenNode?.next = nextEven
          
          currOddNode = if (currOddNode?.next != null) {
              currOddNode?.next
          } else {
              currOddNode
          }
          
          currEvenNode = if (currEvenNode?.next != null) {
              currEvenNode?.next
          } else {
              currEvenNode
          }
          
          curr = nextOdd?.next
      }
      
      currOddNode?.next = firstEvenNode
      
      return firstOddNode
  }
}