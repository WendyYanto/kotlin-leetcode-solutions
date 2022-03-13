class MovingAverage(private val size: Int) {

  val sumQueue: Queue<Int> = LinkedList<Int>()
  var totalSum = 0
  var totalSize = 0
  
  fun next(`val`: Int): Double {
      if (totalSize >= size) {
        val deletedVal = sumQueue.poll()
        totalSum -= deletedVal
        totalSize -= 1
      }
      
      sumQueue.add(`val`)
      totalSum += `val`
      totalSize += 1
      
      return totalSum.toDouble() / totalSize 
  }

}

/**
* Your MovingAverage object will be instantiated and called as such:
* var obj = MovingAverage(size)
* var param_1 = obj.next(`val`)
*/