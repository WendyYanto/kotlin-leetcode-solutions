class Solution {
    
  companion object {
      private const val START_CHAR = 97
  }
  
  fun getLucky(s: String, k: Int): Int {
      val digitString = s.toList().map(::toASCII).joinToString(separator = "")
      
      return transform(digitString, k)
  }
  
  private fun toASCII(character: Char): Int {
      return (character.toInt() - START_CHAR) + 1
  }
  
  private fun transform(digitString: String, k: Int): Int {
      if (k == 0) {
          return digitString.toInt()
      }
      val sum = digitString.toList().map { digit -> digit - '0' }.sum()
      return transform(sum.toString(), k-1)
  }
}