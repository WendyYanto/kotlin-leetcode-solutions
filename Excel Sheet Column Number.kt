class Solution {
  fun titleToNumber(columnTitle: String): Int {
      var count = 0
      var counter = 0
      
      for (i in columnTitle.length - 1 downTo 0) {
          count += (getMultiplier(counter) * (1 + (columnTitle[i] - 'A')))
          counter++
      }
      
      return count
  }
  
  private fun getMultiplier(counter: Int): Int {
      return Math.pow(26.0, counter.toDouble()).toInt()
  }
}