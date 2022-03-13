class Solution {
  fun longestValidParentheses(s: String): Int {
      val parenthesesStack = ArrayDeque<Int>()
      
      var maxCount = 0
      
      for (i in 0 .. s.length - 1) {
          if (parenthesesStack.size > 0) {
              if (s[parenthesesStack.peek()] == '(' && s[i] == ')') {
                  parenthesesStack.pop()
              }  else {
                  parenthesesStack.push(i)
              }
          } else {
              parenthesesStack.push(i)
          }
      }
      
      var lastIndex = s.length
      
      if (parenthesesStack.size == 0) {
          return lastIndex
      }
      
      while (parenthesesStack.size > 0) {
          val peek = parenthesesStack.peek()
          maxCount = maxOf(maxCount, lastIndex - peek - 1)
          lastIndex = peek
          parenthesesStack.pop()
      }

      maxCount = maxOf(maxCount, maxOf(lastIndex, 0))
      
      return maxCount
  }
}
