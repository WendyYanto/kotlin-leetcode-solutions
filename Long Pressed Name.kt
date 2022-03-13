class Solution {
  fun isLongPressedName(name: String, typed: String): Boolean {
      var nameIndex = 0
      var typedIndex = 0
      
      while (nameIndex < name.length) {
          var nameCharacterCount = 0
          
          var nameCharacter = name[nameIndex]
          
          while (nameIndex < name.length && name[nameIndex] == nameCharacter) {
              nameCharacterCount++
              nameIndex++
          }
          
          var typedCharacterCount = 0
          
          while (typedIndex < typed.length && typed[typedIndex] == nameCharacter) {
              typedCharacterCount++
              typedIndex++
          }
          
          if (typedCharacterCount < nameCharacterCount) {
              return false
          }
      }
      
      return typedIndex == typed.length
  }
}