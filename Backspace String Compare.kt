class Solution {
  fun backspaceCompare(s: String, t: String): Boolean {
      return getString(s) == getString(t)
  }
  
  private fun getString(word: String): String {
      val output: MutableList<Char> = mutableListOf()
      
      for (character in word) {
          if (character == '#') {
              if (output.isNotEmpty()) {
                  output.removeAt(output.lastIndex)
              }
          } else {
              output.add(character)
          }
      }
      
      return output.joinToString("")
  }
}