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
  fun reorderList(head: ListNode?): Unit {
      val nodes: MutableList<ListNode?> = mutableListOf()
      
      var curr = head
      while (curr != null) {
          nodes.add(curr)
          curr = curr?.next
      }
      
      var left = 0
      var right = nodes.lastIndex
      
      var prev: ListNode? = null
      
      while (left <= right) {
          if (left == right) {
              prev?.next = nodes[left]
              nodes[left]?.next = null
              
          } else {
              prev?.next = nodes[left]
              nodes[left]?.next = nodes[right]
              nodes[right]?.next = null
              
              prev = nodes[right]
          }
          
          left++
          right--
      }
  }
}