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
  fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
      val nodes: MutableList<ListNode?> = mutableListOf()
      var curr = head
      while (curr != null) {
          nodes.add(curr)
          curr = curr?.next
      }
      val nodeArray: Array<ListNode?> = Array(k) { null } 
      
      if (nodes.size <= k) {            
          nodes.forEachIndexed { index, value ->
              value?.next = null
              nodeArray[index] = value
          }
          
          return nodeArray
      }
      
      val remaining = nodes.size % k
      val count = nodes.size / k
      val nodeSize: IntArray = IntArray(k) { 0 }
      
      for (i in 0..k-1) {
          nodeSize[i] = count
      }
      
      for (i in 0..remaining-1) {
          nodeSize[i]++
      }
      
      var index = 0
      
      for (i in 0..k-1) {
          val count = nodeSize[i]
          val lastIndex = index + count - 1
          nodes.get(lastIndex)?.next = null
          nodeArray[i] = nodes.get(index)
          
          index = lastIndex + 1
      }
      
      return nodeArray
  }
}