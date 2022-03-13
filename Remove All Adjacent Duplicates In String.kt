class Solution {
  fun removeDuplicates(s: String): String {
      val characterStack = ArrayDeque<Char>()
      
      for (character in s) {
          if (characterStack.size > 0 && characterStack.peek() == character) {
              characterStack.pop()
          } else {
              characterStack.push(character)
          }
      }
      
      val stringBuilder = StringBuilder()
      
      while (characterStack.size > 0) {
          stringBuilder.append(characterStack.poll())
      }
      
      return stringBuilder.toString().reversed()
  }
}