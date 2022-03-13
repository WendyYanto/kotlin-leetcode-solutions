class Solution {
  // Bruteforce, time: 0(n2) , space: 0(n)
  fun finalPrices(prices: IntArray): IntArray {
      var index = 0
      val numbers = IntArray(prices.size)
      while (index < prices.size) {
          var minimumIndex = index + 1
          // search first minimum
          while (minimumIndex < prices.size && prices[minimumIndex] > prices[index]) {
              minimumIndex++
          }
          
          val discount = if (minimumIndex < prices.size) {
            prices[minimumIndex] 
          } else {
            0 
          }
          
          numbers[index] = prices[index] - discount
          index++
      }
      
      return numbers
  }
  
  // monotonic stack, time: O(n) and space O(n)
  fun finalPrices(prices: IntArray): IntArray {
    val lastIndexStack = ArrayDeque<Int>()
    
    prices.forEachIndexed { index, value ->
        while (lastIndexStack.isNotEmpty() && prices[lastIndexStack.peek()] >= value) {
            val lastIndex = lastIndexStack.peek()
            prices[lastIndex] -= value
            lastIndexStack.pop()
        }
        
        lastIndexStack.push(index)
    }
    
    return prices
}
}