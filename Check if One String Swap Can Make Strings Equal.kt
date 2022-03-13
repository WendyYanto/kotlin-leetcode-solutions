class Solution {
    
  fun areAlmostEqual(s1: String, s2: String): Boolean {
      var diff = 0
      
      val s1Map: MutableMap<Char, Int> = mutableMapOf()
      val s2Map: MutableMap<Char, Int> = mutableMapOf()
      
      for (i in 0..s1.length-1) {
          if (s1[i] != s2[i]) {
              diff++
          }
          s1Map[s1[i]] = s1Map.getOrDefault(s1[i], 0) + 1
          s2Map[s2[i]] = s2Map.getOrDefault(s2[i], 0) + 1
      }
      
      return diff <= 2 && s1Map == s2Map
  }
}