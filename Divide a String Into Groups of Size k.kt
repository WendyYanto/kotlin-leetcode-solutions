class Solution {
  fun divideString(s: String, k: Int, fill: Char): Array<String> {
      val results: MutableList<String> = mutableListOf()
      
      for (character in 0 .. s.length - 1 step k) {
          val endIndex = minOf(character + k, s.length)
          results.add(s.substring(character, endIndex))
      }
      
      val lastString = results.last()
      
      if (lastString.length < k) {
          var length = lastString.length
          val appender = StringBuilder()
          
          while (length < k) {
              appender.append(fill)
              length++
          }
          
          results[results.lastIndex] = lastString + appender
      }
      
      return results.toTypedArray()
  }
}