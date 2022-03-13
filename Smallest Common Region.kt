class Solution {
  private val regionsMap: MutableMap<String, MutableList<String>> = mutableMapOf()
  private val parentsMap: MutableMap<String, String> = mutableMapOf()
  
  fun findSmallestRegion(regions: List<List<String>>, region1: String, region2: String): String {
      for (region in regions) {
          for (i in 1 .. region.size - 1) {
              val regionMap = regionsMap.getOrPut(region[0]) { mutableListOf() }
              regionMap.add(region[i])
              
              parentsMap[region[i]] = region[0]
          }
      }
      
      val root = regionsMap.keys.firstOrNull { region -> parentsMap[region] == null }.orEmpty()
      
      return findRegion(root, region1, region2)
  }
  
  private fun findRegion(key: String, region1: String, region2: String): String {
      if (key == region1 || key == region2) {
          return key
      }
      
      var hasFoundRegion1 = false
      var region1Parent = ""
      var foundRegion1 = ""
      var hasFoundRegion2 = false
      var region2Parent = ""
      var foundRegion2 = ""

      for (region in regionsMap[key].orEmpty()) {
          if (hasFoundRegion1.not()) {
              region1Parent = findRegion(region, region1, region2)
              if (region1Parent.isNotBlank()) {
                  hasFoundRegion1 = true
                  foundRegion1 = region1Parent
                  continue
              }
          }

          if (hasFoundRegion2.not()) {
              region2Parent = findRegion(region, region1, region2)
              if (region2Parent.isNotBlank()) {
                  hasFoundRegion2 = true
                  foundRegion2 = region2Parent
              }
          }
          
          if (hasFoundRegion1 && hasFoundRegion2) {
              return key   
          }
      }
      
      
      if (hasFoundRegion1) {
          return foundRegion1
      } else if (hasFoundRegion2) {
          return foundRegion2
      } else {
          return ""
      }
  }
}