class Solution {
  private val uniqueNumbers: MutableSet<Int> = mutableSetOf()
  private var maxLength = 0
  
  fun numsSameConsecDiff(n: Int, k: Int): IntArray {
      maxLength = n
      backtrack(0, k, 0)
      
      return uniqueNumbers.toIntArray()
  }
  
  private fun backtrack(number: Int, k: Int, counter: Int) {
      if (counter == maxLength) {
          uniqueNumbers.add(number)
          return
      }
      
      for (i in 0 .. 9) {
          if (counter == 0) {
              backtrack(number + i, k, counter + 1)
          } else {
              val remainder = number % 10
              val finalResultOfPlus = (remainder + i) % 10
              
              if (Math.abs(finalResultOfPlus - remainder) == k) {
                  val prefix = number * 10
                  if (prefix != 0) {
                      backtrack(prefix + finalResultOfPlus, k, counter + 1)
                  }
              }
          }
      }
  }
}