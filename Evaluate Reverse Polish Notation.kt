class Solution {
  fun evalRPN(tokens: Array<String>): Int {
      val numberStack = Stack<Int>()
      
      for (token in tokens) {
          if (token == "+") {
              val secondNumber = numberStack.pop()
              val firstNumber = numberStack.pop()
              
              val result = firstNumber + secondNumber
              
              numberStack.push(result)
          } else if (token == "-") {
              val secondNumber = numberStack.pop()
              val firstNumber = numberStack.pop()
              
              val result = firstNumber - secondNumber
              
              numberStack.push(result)
          } else if (token == "*") {
              val secondNumber = numberStack.pop()
              val firstNumber = numberStack.pop()
              
              val result = firstNumber * secondNumber
              
              numberStack.push(result)
          } else if (token == "/") {
              val secondNumber = numberStack.pop()
              val firstNumber = numberStack.pop()
              
              val result = firstNumber / secondNumber
              
              numberStack.push(result)
          } else {
              numberStack.push(token.toInt())
          }
      }
      
      return numberStack.peek()
  }
}