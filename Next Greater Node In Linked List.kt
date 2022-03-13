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
  fun nextLargerNodes(head: ListNode?): IntArray {
      var curr = head
      val results: MutableList<Int> = mutableListOf()
      val valueStack = Stack<Pair<Int, Int>>()
      
      while (curr != null) {
          val value = curr?.`val` ?: 0
          
          while (valueStack.size > 0 && valueStack.peek().first < value) {
              results[valueStack.peek().second] = value
              valueStack.pop()
          }
          
          results.add(0)
          valueStack.push(value to results.lastIndex)
          
          curr = curr?.next
      }
      
      
      return results.toIntArray()
  }
}
