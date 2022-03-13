
class Solution {
  fun reorderSpaces(text: String): String {
      val words = mutableListOf<String>()
      var word = ""
      var totalSpace = 0
      
      for (i in 0..text.length - 1) {
          if (text[i] == ' ') {
              if (word.length > 0) {
                  words.add(word)
                  word = ""
              }
              totalSpace++
          } else {
              word = word + text[i]
          }
      }
      
      if (word.length > 0) {
          words.add(word)
      }
      
      if (words.size == 1) {
          return words[0] + generateSpace(totalSpace)
      }
      
      val space = (totalSpace / (words.size-1)).toInt()
      val remainingSpace = (totalSpace % (words.size-1)).toInt()
      
      return words.joinToString(
        separator = generateSpace(space),
        postfix = generateSpace(remainingSpace)
      )
  }
  
  private fun generateSpace(count: Int): String {
      var result = ""
      for (i in 0..count-1) {
          result += " "
      }
      return result
  }
}