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
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        val nodes = mutableListOf<ListNode>()
        
        var curr = head
        while (curr != null) {
            nodes.add(curr)
            curr = curr.next
        }
        
        val firstNode = nodes[k-1]
        val lastNode = nodes[nodes.size - k]
        
        if (firstNode != lastNode) {
            val lastValue = lastNode.`val`
            val firstValue = firstNode.`val`
            
            firstNode.`val` = lastValue
            lastNode.`val` = firstValue
        }
        
        return head
    }
}