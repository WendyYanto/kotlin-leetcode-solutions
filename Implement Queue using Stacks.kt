class MyQueue() {

  private val innerStack = ArrayDeque<Int>()
  private val FIFOStack = ArrayDeque<Int>()
  
  fun push(x: Int) {
       while (!FIFOStack.isEmpty()) {
           innerStack.push(FIFOStack.poll())
       }
       
       // add x
       FIFOStack.push(x)
       
       while (!innerStack.isEmpty()) {
           FIFOStack.push(innerStack.poll())
       }
  }

  fun pop(): Int {
      return FIFOStack.poll()
  }

  fun peek(): Int {
      return FIFOStack.peek()
  }

  fun empty(): Boolean {
      return FIFOStack.isEmpty()
  }

}

/**
* Your MyQueue object will be instantiated and called as such:
* var obj = MyQueue()
* obj.push(x)
* var param_2 = obj.pop()
* var param_3 = obj.peek()
* var param_4 = obj.empty()
*/