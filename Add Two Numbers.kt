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
  fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
      var currFirstNode = l1
      var currSecondNode = l2
      
      var shouldReturnL1 = true
      
      if (isLarger(l1, l2) == l2) {
          currFirstNode = l2
          currSecondNode = l1
          shouldReturnL1 = false
      }
      
      var prev: ListNode? = null
      
      var remainder = 0
  
      while (currFirstNode != null && currSecondNode != null) {
          val firstValue = currFirstNode?.`val` ?: 0
          val secondValue = currSecondNode?.`val` ?: 0
          
          var sum = firstValue + secondValue + remainder
          if (sum >= 10) {
              remainder = sum / 10
              sum = sum % 10
          } else {
              remainder = 0
          }
          
          currFirstNode?.`val` = sum
          
          prev = currFirstNode
          
          currFirstNode = currFirstNode?.next
          currSecondNode = currSecondNode?.next
      }
      
      while (currFirstNode != null) {
          val firstValue = currFirstNode?.`val` ?: 0
          
          var sum = firstValue + remainder
          if (sum >= 10) {
              remainder = sum / 10
              sum = sum % 10
          } else {
              remainder = 0
          }
          
          currFirstNode?.`val` = sum
          prev = currFirstNode
          
          currFirstNode = currFirstNode?.next
      }
      
      if (remainder != 0) {
          prev?.next = ListNode(remainder)
      }
      
      return if (shouldReturnL1) {
          l1
      } else {
          l2
      }
  }
  
  private fun isLarger(l1: ListNode?, l2: ListNode?): ListNode? {
      var currL1 = l1
      var currL2 = l2
      
      while (currL1 != null && currL2 != null) {
          currL1 = currL1?.next
          currL2 = currL2?.next
      }
      
      if (currL1 == null && currL2 == null) {
          return l1
      } else if (currL1 == null) {
          return l2
      } else {
          return l1
      }
  }
}