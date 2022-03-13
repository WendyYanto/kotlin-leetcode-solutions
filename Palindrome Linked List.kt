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
  fun isPalindrome(curr: ListNode?): Boolean {
      var word = mutableListOf<Int>()
      var head = curr
      
      while (head != null) {
         word.add(head!!.`val`)
         head = head?.next
      }
      
      var isPalindrome = true
      val length = word.size
      
      for (i in 0..((length - 1) / 2)) {
          if (i == length - 1 - i) {
              break
          }
          if (word[i] != word[length - 1 - i]) {
              return false
          }
      }
      
      return isPalindrome
  }

  // Reverse LinkedList
  fun isPalindrome(curr: ListNode?): Boolean {
    var count = 1
    var head = curr
    
    while (head != null) {
      head = head?.next
      count++
    }
    
    count -= 1
    
    if (count == 1) {
        return true
    }
    
    var isOdd = count % 2 == 1 
    val stopCount: Int = (count - 1)/2
    
    head = curr

    count = 0
    
    var prev: ListNode? = null
    while (head != null) {
      if (stopCount < count) {
          println(head?.`val`)
          if (isOdd) {
              isOdd = false
              
          } else {
              // reverse node
              val currHead = head
              val nextHead = head?.next
              
              currHead?.next = prev
              prev = currHead
              
              head = nextHead
          }
          
          continue
      }
      
      head = head?.next
      count++
    }

    head = curr
    while (head != null && prev != null) {    
        if (head?.`val` != prev?.`val`) {
            return false
        }
        
        head = head?.next
        prev = prev?.next
    }
    
    return true
}
}