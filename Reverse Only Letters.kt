class Solution {
  fun reverseOnlyLetters(s: String): String {
      val letters: MutableList<Char> = mutableListOf()
      val charArrays = s.toCharArray()
      
      for (i in 0..charArrays.size - 1) {
          if (charArrays[i].isLetter()) {
              letters.add(charArrays[i])
              charArrays[i] = 'Z'
          }
      }
      
      var index = letters.size - 1
      for (i in 0..charArrays.size - 1) {
          if (charArrays[i] == 'Z') {
              charArrays[i] = letters[index]
              index--
          }
      }
      
      return charArrays.joinToString("")
  }
}