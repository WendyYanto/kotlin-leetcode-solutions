class Solution {
  fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
      var left = 0
      var right = 0
      var maxLength = 0
      
      val characterCount: MutableMap<Char, Int> = mutableMapOf()
      
      while (right < s.length) {
          val rightCount = characterCount.getOrPut(s[right]) { 0 }
          characterCount[s[right]] = 1 + rightCount
          
          while (characterCount.keys.size > 2) {
              val leftCount = characterCount[s[left]] ?: 0
              if (leftCount - 1 == 0) {
                  characterCount.remove(s[left])
              } else {
                  characterCount[s[left]] = leftCount - 1
              }
              
              
              left++
          }
          
          maxLength = maxOf(maxLength, right - left + 1)
          right++
      }
      
      return maxLength
  }
}