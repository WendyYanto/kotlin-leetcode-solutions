class Solution {
  private val keyCount: MutableMap<String, Int> = mutableMapOf()
  
  fun getFolderNames(names: Array<String>): Array<String> {
      val results: MutableList<String> = mutableListOf()
      
      for (index in 0 .. names.lastIndex) {
          val name = names[index]
          val result = if (keyCount[name] == null) {
              name
          } else {
              var counter = keyCount.getOrDefault(name, 0)
              while(keyCount["$name($counter)"] != null) {
                  counter++
              }
              keyCount[name] = counter + 1
              "$name($counter)"
          }
          
          names[index] = result
          keyCount[result] = keyCount.getOrDefault(result, 0) + 1 
      }
      
      return names
  }
}