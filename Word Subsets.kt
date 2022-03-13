class Solution {
  fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
      val keys = words2
          .map(::getPairs)
          .flatten()
          .fold(mutableMapOf<Char, Int>(), { accumulator, value ->
              val currentMaxValue = accumulator.getOrDefault(value.first, 0)
              accumulator[value.first] = Math.max(value.second, currentMaxValue)
              accumulator
          })
      
      return words1.map { word ->
          word to word.groupingBy { it }.eachCount()
      }.filter { wordPair ->
          containsSubset(keys, wordPair.second)
      }.map { wordPair ->
          wordPair.first
      }
  }
  
  private fun getPairs(word: String): List<Pair<Char, Int>> {
      return word
          .groupingBy { it }
          .eachCount()
          .entries
          .map { it.key to it.value }
  }
  
  private fun containsSubset(keys: Map<Char, Int>, wordMap: Map<Char, Int>): Boolean {
      return keys.all { subset -> 
          wordMap.getOrDefault(subset.key, 0) >= subset.value 
      }
  }
}

// Faster Solution
// class Solution {
//     fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
//         val maxWordKeys = IntArray(26) { 0 }
        
//         for (word in words2) {
//             val wordChars = word.toCharArray()
//             val wordKeys = IntArray(26)

//             wordChars.forEach { value ->
//                 wordKeys[value - 'a']++
//             }
            
//             for (i in 0..25) {
//                 maxWordKeys[i] = Math.max(maxWordKeys[i], wordKeys[i])
//             }
//         }
        
//         val result = mutableListOf<String>()
        
//         for (word in words1) {
//             val wordChars = word.toCharArray()
//             val wordKeys = IntArray(26) { 0 }

//             wordChars.forEach { value ->
//                 wordKeys[value - 'a']++
//             }
            
//             var flag = true
            
//             loop@ for (i in 0..25) {
//                 if (maxWordKeys[i] > 0 && wordKeys[i] < maxWordKeys[i]) {
//                     flag = false
//                     break@loop
//                 } 
//             }
            
//             if (flag) {
//                 result.add(word)
//             }
//         }
        
//         return result
//     }
// }