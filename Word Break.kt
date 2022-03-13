class Solution {
  private var target: String = ""
  private var wordDict: List<String> = emptyList()
  private val memo = Array(1005) { Array(305) { IntArray(305) { -1 } } }
  
  fun wordBreak(s: String, wordDict: List<String>): Boolean {
      target = s
      this.wordDict = wordDict
      return dp("", 0, 0)
  }
  
  fun dp(value: String, indexOfChoice: Int, counter: Int): Boolean {
      if (value.length > target.length) {
          return false
      } else if (value.length == target.length) {
          return value == target
      }
      
      if (memo[indexOfChoice][counter][value.length] != -1) {
          return if (memo[indexOfChoice][counter][value.length] == 1) {
              true
          } else {
              false
          }
      }
      
      var found = false
      
      for (i in 0 .. wordDict.size - 1) {
          found = found || dp(value + wordDict[i], i, counter + 1)
          if (found) {
              return true
          }
      }
      
      memo[indexOfChoice][counter][value.length] = if (found) {
          1
      } else {
          0
      }
      
      return found
  }
}