class MyCircularDeque(private val k: Int) {

  var head = Node()
  var tail = Node()
  
  var count = 0
  
  init {
      head?.next = tail
      tail?.prev = head
  }
  
  fun insertFront(value: Int): Boolean {
      if (isFull()) {
          return false
      }
      
      val node = Node(value = value)
      val nextNode = head?.next
      
      head?.next = node
      node?.prev = head
      
      node?.next = nextNode
      nextNode?.prev = node
      
      count++
      
      return true
  }

  fun insertLast(value: Int): Boolean {
      if (isFull()) {
          return false
      }
      
      val node = Node(value = value)
      val prevNode = tail?.prev
      
      prevNode?.next = node
      node?.prev = prevNode
      
      node?.next = tail
      tail?.prev = node
      
      count++
      
      return true
  }

  fun deleteFront(): Boolean {
      if (isEmpty()) {
          return false
      } 
      
      val nextNode = head?.next?.next
      head?.next = nextNode
      nextNode?.prev = head
      
      count--
      
      return true
  }

  fun deleteLast(): Boolean {
      if (isEmpty()) {
          return false
      } 
      
      val prevNode = tail?.prev?.prev
      prevNode?.next = tail
      tail?.prev = prevNode
      
      count--
      
      return true
  }

  fun getFront(): Int {
      if (isEmpty()) {
          return -1
      }
      
      return head?.next?.value ?: -1
  }

  fun getRear(): Int {
      if (isEmpty()) {
          return -1
      }
      
      return tail?.prev?.value ?: -1
  }

  fun isEmpty(): Boolean {
      return count == 0
  }

  fun isFull(): Boolean {
      return count == k
  }

  data class Node(
    var prev: Node? = null,
    var next: Node? = null,
    var value: Int = 0
  )
}

/**
* Your MyCircularDeque object will be instantiated and called as such:
* var obj = MyCircularDeque(k)
* var param_1 = obj.insertFront(value)
* var param_2 = obj.insertLast(value)
* var param_3 = obj.deleteFront()
* var param_4 = obj.deleteLast()
* var param_5 = obj.getFront()
* var param_6 = obj.getRear()
* var param_7 = obj.isEmpty()
* var param_8 = obj.isFull()
*/