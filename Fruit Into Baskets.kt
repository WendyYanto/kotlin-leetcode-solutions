class Solution {
  fun totalFruit(fruits: IntArray): Int {
      var leftIndex = 0
      var rightIndex = 0
      val cachedFruits: MutableMap<Int, Int> = mutableMapOf()
      var maxCount = 0
      
      while (rightIndex < fruits.size) {
          while (cachedFruits.keys.size > 2) {
              val value = cachedFruits[fruits[leftIndex]] ?: 0
              cachedFruits[fruits[leftIndex]] = value - 1
              if (cachedFruits[fruits[leftIndex]] == 0) {
                  cachedFruits.remove(fruits[leftIndex])
              }
              leftIndex++
          }
          
          val value = cachedFruits[fruits[rightIndex]] ?: 0

          cachedFruits[fruits[rightIndex]] = 1 + value
          maxCount = maxOf(maxCount, rightIndex - leftIndex)
          rightIndex++
      }
      
      while (cachedFruits.keys.size > 2) {
          val value = cachedFruits[fruits[leftIndex]] ?: 0
          cachedFruits[fruits[leftIndex]] = value - 1
          if (cachedFruits[fruits[leftIndex]] == 0) {
              cachedFruits.remove(fruits[leftIndex])
          }
          leftIndex++
      }
      
      maxCount = maxOf(maxCount, rightIndex - leftIndex)

      return maxCount
  }
}

// Better Solution

class Solution {
  fun totalFruit(fruits: IntArray): Int {
      var leftIndex = 0
      var rightIndex = 0
      var maxCount = 0
      val cacheFruits: MutableMap<Int, Int> = mutableMapOf()
      
      while (rightIndex < fruits.size) {
          val value = cacheFruits[fruits[rightIndex]] ?: 0
          cacheFruits[fruits[rightIndex]] = value + 1
          
          while (cacheFruits.keys.size > 2) {
              val leftFruitCount = cacheFruits[fruits[leftIndex]] ?: 0
              cacheFruits[fruits[leftIndex]] = leftFruitCount - 1
              
              if (cacheFruits[fruits[leftIndex]] == 0) {
                  cacheFruits.remove(fruits[leftIndex])
              }
              
              leftIndex++
          }
          
          maxCount = maxOf(maxCount, rightIndex - leftIndex + 1)
          rightIndex++
      }
      
      return maxCount
  }
}