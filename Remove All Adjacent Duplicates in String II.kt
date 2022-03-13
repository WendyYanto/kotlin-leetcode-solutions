class Solution {
  fun removeDuplicates(s: String, k: Int): String {
      val stack = ArrayDeque<CharNode>()
  
      for (character in s) {
          if (stack.size > 0 && stack.peek().character == character) {
              val count = stack.peek().count
              if (1 + count == k) {
                  stack.pop()
              } else {
                  stack.peek().count = 1 + count 
              }
          } else {
              stack.push(CharNode(character = character))
          }
      }
      
      val stringBuilder = StringBuilder()
      
      while(stack.size > 0) {
          val character = stack.poll()
          val nodeString = (0 .. character.count - 1)
              .map { _ -> character.character }
              .joinToString("")
              
          stringBuilder.append(nodeString)
      }
      
      return stringBuilder
          .toString()
          .reversed()
  }
  
  data class CharNode(
    var count: Int = 1,
    var character: Char = '-'
  )
}