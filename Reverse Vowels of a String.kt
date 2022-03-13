class Solution {
  fun reverseVowels(s: String): String {
      var value = s.toCharArray()
      
      var left = 0
      var right = s.length - 1
      
      while (left < right) {
          if (isVowel(value[left])) {
              while (!isVowel(value[right])) {
                  right--
              }
              
              val temp = value[left]
              value[left] = value[right]
              value[right] = temp
              
              right--
          }
          
          left++
      }
      
      return String(value)
  }
  
  private fun isVowel(character: Char): Boolean {
      return character == 'a' || 
      character == 'e' || 
      character == 'i' || 
      character == 'o' || 
      character == 'u' || 
      character == 'A' ||
      character == 'E' ||
      character == 'I' ||
      character == 'O' ||
      character == 'U'
  }
}