class Solution {
  fun checkPerfectNumber(num: Int): Boolean {
      var sum = 1
      
      for (i in 2..num) {
          if (i*i > num) {
              return sum == num
          }
          
          if (num % i == 0) {
              if (i*i == num) {
                  sum += i
              } else {
                  sum += i
                  sum += (num / i)
              }
          }
      }
      
      return false
  }
}