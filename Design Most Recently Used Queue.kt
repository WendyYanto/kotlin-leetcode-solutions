class MRUQueue(private val n: Int) {
    
  private var head: Node? = null
  private var tail: Node? = null
  
  init {
      var curr: Node? = null
      for (i in 1..n) {
          if (head == null) {
              head = Node(value = i)
              curr = head
          } else {
              curr?.next = Node(value = i)
              curr = curr?.next
          }
      }
      tail = curr
  }
  
  fun fetch(k: Int): Int {
      var curr = head
      var prev: Node? = null
      var counter = 1
              
      while (counter < k) {
          prev = curr
          curr = curr?.next
          counter++
      }

      if (curr == tail) {
          return curr?.value ?: 0
      }
      
      if (curr == head) {
          head = curr?.next
      } else {
          prev?.next = curr?.next
      }
      
      tail?.next = curr
      curr?.next = null
      
      tail = curr
      
      return curr?.value ?: 0
  }
}

data class Node(
var value: Int = 0,
var next: Node? = null
)

/**
* Your MRUQueue object will be instantiated and called as such:
* var obj = MRUQueue(n)
* var param_1 = obj.fetch(k)
*/