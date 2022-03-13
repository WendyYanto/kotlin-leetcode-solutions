class Solution {
  fun dailyTemperatures(temperatures: IntArray): IntArray {
      val results = IntArray(temperatures.size) { 0 }
      val temperatureIndexStack = ArrayDeque<Int>()
      
      for (i in 0 .. temperatures.size - 1) {
          while (temperatureIndexStack.size > 0 && 
                  temperatures[temperatureIndexStack.peek()] < temperatures[i]) {
              val index = temperatureIndexStack.poll()
              results[index] = i - index
          }
          
          temperatureIndexStack.push(i)
      }
      
      return results
  }
}

