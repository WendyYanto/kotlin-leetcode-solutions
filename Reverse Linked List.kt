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
  fun reverseList(head1: ListNode?): ListNode? {
    var head = head1
    var prev: ListNode? = null
    
    while (head != null) {
        val headNext = head?.next
        
        head?.next = prev
        prev = head
        
        head = headNext
    }
    
    return prev
}