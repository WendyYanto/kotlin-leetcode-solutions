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
  fun mergeKLists(lists: Array<ListNode?>): ListNode? {
      if (lists.size <= 1) {
          return if (lists.isEmpty()) {
              null
          } else {
              lists.first()
          }
      }
      
      val mid = lists.size/2
      val firstList = mutableListOf<ListNode?>()
      val secondList = mutableListOf<ListNode?>()
  
      for (i in 0..mid-1) {
          firstList.add(lists[i])
      }
      
      for (i in mid..lists.size-1) {
          secondList.add(lists[i])
      }
      
      val firstResult = mergeKLists(firstList.toTypedArray())
      val secondResult = mergeKLists(secondList.toTypedArray())
      
      return merge(firstResult, secondResult)
  }
  
  private fun merge(tempFirstList: ListNode?, tempSecondList: ListNode?): ListNode? {
      var result: ListNode? = null
      var head: ListNode? = null
      
      var firstList = tempFirstList
      var secondList = tempSecondList
      
      while (firstList != null && secondList != null) {
          var minValue = 0
          if (firstList?.`val` < secondList?.`val`) {
              minValue = firstList?.`val` ?: 0
              firstList = firstList?.next
          } else {
              minValue = secondList?.`val` ?: 0
              secondList = secondList?.next
          }
          
          if (result == null) {
              result = ListNode(minValue)
              head = result
          } else {
              result?.next = ListNode(minValue)
              result = result?.next
          }
      }
      
      while (firstList != null) {
          var minValue = firstList?.`val` ?: 0
          
          if (result == null) {
              result = ListNode(minValue)
              head = result
          } else {
              result?.next = ListNode(minValue)
              result = result?.next
          }
          
          firstList = firstList?.next
      }
      
      while (secondList != null) {
          var minValue = secondList?.`val` ?: 0
          
          if (result == null) {
              result = ListNode(minValue)
              head = result
          } else {
              result?.next = ListNode(minValue)
              result = result?.next
          }
          
          secondList = secondList?.next
      }
      
      return head
  }
}