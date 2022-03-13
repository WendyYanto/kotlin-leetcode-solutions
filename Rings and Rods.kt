class Solution {
  fun countPoints(rings: String): Int {
      val cache = (0..10).map {
          Point()
      }
      
      for (i in 0 .. rings.length - 2 step 2) {
          val firstChar = rings[i]
          val secondIndex = rings[i+1] - '0'
          
          when (firstChar) {
              'R' -> {
                  cache[secondIndex].hasRed = true
              }
              'G' -> {
                  cache[secondIndex].hasGreen = true
              }
              else -> {
                  cache[secondIndex].hasBlue = true
              }
          }
      }
      
      return cache.filter(Point::isComplete).size
  }
  
  data class Point(
    var hasRed: Boolean = false,
    var hasGreen: Boolean = false,
    var hasBlue: Boolean = false
  ) {
      fun isComplete(): Boolean {
          return hasRed && hasGreen && hasBlue
      }
  }
}