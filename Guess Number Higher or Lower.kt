/** 
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */

class Solution:GuessGame() {
  override fun guessNumber(n:Int):Int {
      var left = 1
      var right = n
      
      while (left <= right) {
          val mid = left + (right-left)/2
          
          println(mid)
          
          if (guess(mid) == 0) {
              return mid
          }  else if (guess(mid) == 1) {
              left = mid + 1
          } else {
              right = mid - 1
          }
      }
      
      return -1
  }
}