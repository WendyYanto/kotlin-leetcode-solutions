class Solution {
    
  fun maxDistance(colors: IntArray): Int {
      val size = colors.size
      
      var rightMax = size - 1
      while (colors[0] == colors[rightMax]) {
          rightMax--
      }
      
      var leftMax = 0
      while(colors[leftMax] == colors[size - 1]) {
          leftMax++
      }
      
      return Math.max(size - 1 - leftMax, rightMax)
  }
}