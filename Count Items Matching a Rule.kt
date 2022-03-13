class Solution {
  fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {
      val typeMaps: MutableMap<String, Int> = mutableMapOf()
      val colorMaps: MutableMap<String, Int> = mutableMapOf()
      val nameMaps: MutableMap<String, Int> = mutableMapOf()
      
      items.forEach { item ->
          typeMaps[item[0]] = typeMaps.getOrDefault(item[0], 0) + 1
          colorMaps[item[1]] = colorMaps.getOrDefault(item[1], 0) + 1
          nameMaps[item[2]] = nameMaps.getOrDefault(item[2], 0) + 1
      }
      
      return when(ruleKey) {
          "type" -> typeMaps.getOrDefault(ruleValue, 0)
          "color" -> colorMaps.getOrDefault(ruleValue, 0)
          "name" -> nameMaps.getOrDefault(ruleValue, 0)
          else -> 0
      }
  }
}