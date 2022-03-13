class Solution {
  fun minDeletions(s: String): Int {
      val characterCount = IntArray(26) { 0 }
      var mostCount = 0
      
      for (character in s) {
          characterCount[character - 'a']++
          mostCount = maxOf(mostCount, characterCount[character - 'a'])
      }
  
      val frequencyCounterBucket = IntArray(mostCount + 100) { -1 }
      
      for (character in 'a' .. 'z') {
          if (characterCount[character - 'a'] > 0) {
              frequencyCounterBucket[characterCount[character - 'a']] = 0
          }
      }
      
      val sortedFrequencyCounts = characterCount.sorted()
      val minimumBucket = ArrayDeque<Int>()
      
      for (i in 1 .. mostCount) {
          if (frequencyCounterBucket[i] == -1) {
              minimumBucket.push(i)
          }
      }
      
      var count = 0
      val frequencySet: MutableSet<Int> = mutableSetOf()
      
      for (i in sortedFrequencyCounts.size - 1 downTo 0) {
          if (frequencySet.contains(sortedFrequencyCounts[i])) {
              while (minimumBucket.size > 0 && minimumBucket.peek() >= sortedFrequencyCounts[i]) {
                  minimumBucket.pop()
              }
              
              val countToFill = if (minimumBucket.size > 0) {
                  minimumBucket.poll()
              } else {
                  0
              }
              
              count += (sortedFrequencyCounts[i] - countToFill)
          } else {
              frequencySet.add(sortedFrequencyCounts[i])
          }
      }
      
      return count
  }
}