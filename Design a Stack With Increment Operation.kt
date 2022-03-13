class CustomStack(private val maxSize: Int) {

  private val increments = IntArray(1005) { 0 }
  private var index = 0
  
  private val numberStack = ArrayDeque<Int>()
  
  // increments = [0,0,0,0]
  // stack = [3,2,1]
  // index = 3
  
  fun push(x: Int) {
      if (index == maxSize) {
          return
      }
      
      numberStack.push(x)
      index++
  }

  fun pop(): Int {
      if (index == 0) {
          return -1
      }
      
      val number = numberStack.poll()
      
      val topIndex = index - 1
      val result = number + increments[topIndex]
      
      if (topIndex - 1 >= 0) {
          increments[topIndex - 1] = increments[topIndex - 1] + increments[topIndex]
      }
      
      increments[topIndex] = 0
      index--
      
      return result
  }

  fun increment(k: Int, `val`: Int) {
      if (index == 0) {
          return
      }
      val maxIndex = minOf(k - 1, index - 1)
      increments[maxIndex] += `val`
  }

}

/**
* Your CustomStack object will be instantiated and called as such:
* var obj = CustomStack(maxSize)
* obj.push(x)
* var param_2 = obj.pop()
* obj.increment(k,`val`)
*/