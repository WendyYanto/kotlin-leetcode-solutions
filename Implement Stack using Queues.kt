class MyStack() {
    
  val resultQueue: Queue<Int> = LinkedList<Int>()
  val tempQueue: Queue<Int> = LinkedList<Int>()

  fun push(x: Int) {
      while(resultQueue.isNotEmpty()) {
          tempQueue.add(resultQueue.poll())
      }
      
      resultQueue.add(x)
      
      while(tempQueue.isNotEmpty()) {
          resultQueue.add(tempQueue.poll())
      }
  }
  
  fun pop(): Int {
      return resultQueue.poll()
  }

  fun top(): Int {
      return resultQueue.peek()
  }

  fun empty(): Boolean {
      return resultQueue.isEmpty()
  }

}

/**
* Your MyStack object will be instantiated and called as such:
* var obj = MyStack()
* obj.push(x)
* var param_2 = obj.pop()
* var param_3 = obj.top()
* var param_4 = obj.empty()
*/

// using one queue

class MyStack() {
    
  val resultQueue: Queue<Int> = LinkedList<Int>()

  fun push(x: Int) {
      var size = resultQueue.size
      
      resultQueue.add(x)
      
      while(size > 0) {
          resultQueue.add(resultQueue.poll())
          size--
      }
  }
  
  fun pop(): Int {
      return resultQueue.poll()
  }

  fun top(): Int {
      return resultQueue.peek()
  }

  fun empty(): Boolean {
      return resultQueue.isEmpty()
  }

}

/**
* Your MyStack object will be instantiated and called as such:
* var obj = MyStack()
* obj.push(x)
* var param_2 = obj.pop()
* var param_3 = obj.top()
* var param_4 = obj.empty()
*/