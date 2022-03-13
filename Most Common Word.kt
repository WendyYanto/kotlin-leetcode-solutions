class Solution {
  fun mostCommonWord(paragraph: String, banned: Array<String>): String {
  
    val bannedMap = banned.associateBy({it}, {it})
      
    return paragraph
     .toLowerCase()
     .replace(Regex("[^a-z ]"), " ")
     .split(" ")
     .filter { word -> word.isNotBlank() }
     .groupingBy { it }
     .eachCount()
     .toList()
     .sortedByDescending { (word, count) -> count }
     .first { wordTuple -> bannedMap.get(wordTuple.first) == null }
     .first
  }
}