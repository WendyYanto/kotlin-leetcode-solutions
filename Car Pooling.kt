class Solution {
  private val capacities = IntArray(1005) { 0 }
  
  private var smallest = 0
  private var largest = 0
  
  fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
      trips.forEach { trip ->
          smallest = minOf(trip[1], smallest)
          largest = maxOf(trip[2], largest)
          save(trip[1], trip[2], trip[0])
      }
      
      var count = 0
      for (i in smallest..largest) {
          count += capacities[i]
          if (count > capacity) {
              return false
          }
      }
      
      return true
  }
  
  private fun save(from: Int, to: Int, value: Int) {
      capacities[from] += value
      capacities[to] -= value
  }
}