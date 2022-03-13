class Solution {
  fun longestNiceSubstring(s: String): String {
      if (s.length < 2) {
          // only one character or less
          return "";
      }
      
      val characterSet: MutableSet<Char> = mutableSetOf()
      
      for (character in s) {
          characterSet.add(character)
      }
      
      for (i in 0 .. s.length - 1) {
          if (characterSet.contains(s[i].toUpperCase()) && characterSet.contains(s[i].toLowerCase())) {
            // if current charracte worth keeping  
              continue
          }
          
          val leftSubstring = longestNiceSubstring(s.substring(0, i))
          val rightSubstring = longestNiceSubstring(s.substring(i+1))
          
          if (leftSubstring.length >= rightSubstring.length) {
              return leftSubstring
          } else {
              return rightSubstring
          }
      }
      
      return s
  }
}