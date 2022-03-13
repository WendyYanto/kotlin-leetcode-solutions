class Solution {
  fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
      var firstIndex = 0
      var secondIndex = 0
      val results: MutableList<IntArray> = mutableListOf()
      
      while (firstIndex < firstList.size && secondIndex < secondList.size) {
          val firstStart = firstList[firstIndex][0]
          val firstEnd = firstList[firstIndex][1]
          
          val secondStart = secondList[secondIndex][0]
          val secondEnd = secondList[secondIndex][1]
          
          val start = maxOf(secondStart, firstStart)
          val end = minOf(firstEnd, secondEnd)

          if (start <= end) {
              results.add(intArrayOf(start,end))
          }
          
          if (firstEnd > secondEnd) {
              secondIndex++
          } else {
             firstIndex++
          }
      }
      
      return results.toTypedArray()
  }
}