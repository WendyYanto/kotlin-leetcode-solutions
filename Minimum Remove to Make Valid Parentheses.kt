class Solution {
  fun minRemoveToMakeValid(word: String): String {
      val toBeRemovedStack = ArrayDeque<Pair<Int, Char>>()
      
      for (i in 0 .. word.length - 1) {
          if (word[i] == '(') {
              toBeRemovedStack.push(i to word[i])
          } else if (word[i] == ')') {
              if (toBeRemovedStack.isNotEmpty() && toBeRemovedStack.peek().second == '(') {
                  toBeRemovedStack.pop()
              } else {
                  toBeRemovedStack.push(i to word[i])
              }
          } 
      }
      
      val output = StringBuilder()
      
      for (i in 0 .. word.length - 1) {
          if (toBeRemovedStack.isNotEmpty() && toBeRemovedStack.getLast().first == i) {
              toBeRemovedStack.removeLast()
          } else {
              output.append(word[i])
          }
      }
      
      return output.toString()
  }
}