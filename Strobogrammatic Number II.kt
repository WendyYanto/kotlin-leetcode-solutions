class Solution {
  private val output: MutableSet<String> = mutableSetOf()
  
  private val mirrorPair: Map<String, String> = mapOf(
    "0" to "0",
    "1" to "1",
    "6" to "9",
    "8" to "8",
    "9" to "6"
  )
  
  fun findStrobogrammatic(n: Int): List<String> {
      if (n%2 == 0) {
          backtrack("", n)
      } else {
          backtrack("0", n - 1)
          backtrack("1", n - 1)
          backtrack("8", n - 1)
      }
      
      return output.toList()
  }
  
  private fun backtrack(result: String, n: Int) {
      if (n == 0) {
          if (isValidPrefixZero(result)) {
              output.add(result)
          }
          return
      }
      
      mirrorPair.forEach { pair ->
          val current = pair.key
          val mirror = mirrorPair[current]!!
          val tempResult = mirror + result + pair.key
          
          backtrack(tempResult, n - 2)   
      }
  }
  
  private fun isValidPrefixZero(value: String): Boolean {
      if (value.first() != '0') {
          return true
      }
      
      return value.length == 1
  }
}