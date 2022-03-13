class Solution {
  fun minEatingSpeed(piles: IntArray, h: Int): Int {
      var sum = 0
      var maximumPile = 0
      
      for (pile in piles) {
          sum += pile
          maximumPile = maxOf(maximumPile, pile)
      }
      
      var left = 1
      var right = maximumPile
      
      while (left < right) {
          val mid = left + (right - left) / 2
          
          var totalTime = 0.0
          for (pile in piles) {
              totalTime += Math.ceil(pile.toDouble() / mid.toDouble())
          }
          
          if (totalTime <= h) {
              right = mid
          } else {
              left = mid + 1
          }
      }
      
      return left
  }
}