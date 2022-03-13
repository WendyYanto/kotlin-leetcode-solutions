class Solution {
  fun findOriginalArray(changed: IntArray): IntArray {
      val sortedChanged = changed.sorted()
      
      val numberCount: MutableMap<Int, Int> = mutableMapOf()
      val results: MutableList<Int> = mutableListOf()
      
      var zeroCount = 0
      
      for (number in sortedChanged) {
          if (number == 0) {
              zeroCount++
              continue
          }
          
          val currentValue = numberCount.getOrPut(number) { 0 }
          val newCurrentValue = 1 + currentValue
          numberCount[number] = newCurrentValue
          
          if (number % 2 == 0 && numberCount[number / 2] != null) {
              val value = numberCount.getOrPut(number / 2) { 0 }
              
              if (value - 1 == 0) {
                  numberCount.remove(number / 2)
              } else {
                  numberCount[number/2] = value - 1
              }
              
              if (newCurrentValue - 1 == 0) {
                  numberCount.remove(number)
              } else {
                  numberCount[number] = newCurrentValue - 1
              }
              
              results.add(number / 2)
          }
      }
      
      if (zeroCount > 0 && zeroCount % 2 == 0) {
          for (i in 1 .. zeroCount / 2) {
              results.add(0)
          }
      }
      
      if (results.size * 2 == changed.size) {
          return results.toIntArray()
      } else {
          return intArrayOf()
      }
  }
}