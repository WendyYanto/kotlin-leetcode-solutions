class Solution {
  private var numberString = ""
  private val memo = IntArray(105) { -1 }
  
  fun numDecodings(s: String): Int {
      numberString = s
      return traverse(0)
  }
  
  private fun traverse(index: Int): Int {
      if (memo[index] != -1) {
          return memo[index]
      }
      if (index == numberString.length) {
          return 1
      } else if (index > numberString.length) {
          return 0
      }
      
      val firstNumber = numberString[index] - '0'
      if (firstNumber == 0) {
          return 0
      }
      
      val takeTwo = if (index + 2 <= numberString.length) {
          val number = 10 * firstNumber + (numberString[index+1] - '0')
          if (number <= 26) {
              traverse(index + 2)
          } else {
              0
          }
      } else {
          0
      }
      
      val takeOne = if (firstNumber <= 26) {
          traverse(index + 1)
      } else {
          0
      }
      
      memo[index] = takeTwo + takeOne
      return memo[index]
  }
}