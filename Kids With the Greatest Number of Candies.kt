class Solution {
  fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
      var maxCandies = candies.max() ?: 0
      
      return candies.map { candy ->
          candy + extraCandies >= maxCandies
      }
  }
}