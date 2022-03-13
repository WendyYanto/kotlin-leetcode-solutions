class Solution {
  fun calculate(s: String): Int {
      var multiplier = 1
      var result: Long = 0L
      
      var opening = 0
      var closing = 0
      var openingIndex = -1

      var i = 0
      while (i <= s.length - 1) {
          if (s[i] == '(') {
              opening++
              if (openingIndex != -1) {
                  i++
                  continue
              }
              openingIndex = i
          } else if (s[i] == ')') {
              closing++
              if (opening == closing) {
                  result += (multiplier * calculate(s.substring(openingIndex + 1, i)))
                  opening = 0
                  closing = 0
                  openingIndex = -1
              } else {
                  i++
                  continue
              }
          } else if (opening != closing) {
              i++
              continue
          }  else if (s[i] == '+') {
              multiplier = 1
          } else if (s[i] == ' ') {
              i++
              continue
          } else if (s[i] == '-') {
              multiplier = -1
          } else {
              var currentCount: Long = 0L
              while (i <= s.length - 1 && (s[i] - '0') >= 0 && (s[i] - '0') <= 9) {
                  currentCount += (s[i] - '0')
                  currentCount *= 10
                  i++
              }
              result += (multiplier * (currentCount / 10))
              continue
          }
          
          i++
      }
      
      return result.toInt()
  }
}