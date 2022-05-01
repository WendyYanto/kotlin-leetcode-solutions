class Solution {
  private val nameToTimes: MutableMap<String, MutableList<Int>> = mutableMapOf()
  
  fun alertNames(keyName: Array<String>, keyTime: Array<String>): List<String> {
      for (i in 0 .. keyName.size - 1) {
          val times = nameToTimes.getOrPut(keyName[i]) { mutableListOf() }
          times.add(keyTime[i].toSeconds())
      }
      
      val results: MutableList<String> = mutableListOf()
      
      nameToTimes.forEach { key, value ->
          val sortedValue = value.sorted()
          if (slidingWindow(sortedValue, 3)) {
              results.add(key)
          }
      }
      
      return results.sorted()
  }
  
  private fun String.toSeconds(): Int {
      val times = this.split(":")
      val hour = times.first().toInt()
      val minute = times.last().toInt()
      
      return (hour * 3600) + (minute * 60)
  }
  
  private fun slidingWindow(numbers: List<Int>, maxCount: Int): Boolean {
      var count = 0
      var index = 0
      
      while (index < numbers.size) {
          var count = 1
          
          val firstNumber = numbers[index]
          val secondNumber = numbers.getOrNull(index + 1)
          val thirdNumber = numbers.getOrNull(index + 2)
          
          if (secondNumber != null && secondNumber!! - firstNumber <= 3600) {
              count++
          }
          
          if (thirdNumber != null && thirdNumber!! - firstNumber <= 3600) {
              count++
          }
          
          if (count == 3) {
              return true
          }
          
          index++
      }
      
      return false
  }
}