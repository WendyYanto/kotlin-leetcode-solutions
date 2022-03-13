class Solution {
  fun minimumMoves(s: String): Int {
      // sliding window
      var startIndex: Int? = null
      var endIndex = 0
      var count = 0
      
      while (endIndex < s.length) {
          startIndex?.let { safeStartIndex ->
              if (endIndex - safeStartIndex == 2) {
                  count++
                  startIndex = null
              } 
          } ?: run {
              if (s[endIndex] == 'X') {
                  startIndex = endIndex
              }
          }
          
          endIndex++
      }
        
      if (startIndex != null) {
          count++
      }
      
      return count
  }

  // better solution
  fun minimumMoves(s: String): Int {
    // sliding window
    var startIndex: Int? = null
    var endIndex = 0
    var count = 0
    
    while (endIndex < s.length) {
        startIndex?.let { safeStartIndex ->
            count++
            startIndex = null
            endIndex += 2
        } ?: run {
            if (s[endIndex] == 'X') {
                startIndex = endIndex
            }
            endIndex++
        }
    }

    val safeStartIndex = startIndex ?: 0
    
    if (startIndex != null) {
        count++
    }
    
    return count
}
}