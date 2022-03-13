class Solution {
  private lateinit var parents: IntArray
  
  fun validTree(n: Int, edges: Array<IntArray>): Boolean {
      parents = IntArray(n) { 0 }
      
      for (i in 0 .. n - 1) {
          parents[i] = i
      }
      
      var avoidMergeCount = 0
      
      for (edge in edges) {
          if (hasSameParent(edge[0], edge[1])) {
              avoidMergeCount++
          } else {
              merge(edge[0], edge[1])
          }
      }
      
      var totalCountWithPointingItSelf = 0
      
      for (i in 0 .. n - 1) {
          if (parents[i] == i) {
              totalCountWithPointingItSelf++
          }
      }
      
      return avoidMergeCount == 0 && totalCountWithPointingItSelf == 1
  }
  
  private fun findParent(index: Int): Int {
      if (parents[index] != index) {
          return findParent(parents[index])
      }
      
      return index
  }
  
  private fun hasSameParent(firstIndex: Int, secondIndex: Int): Boolean {
      return findParent(firstIndex) == findParent(secondIndex)
  }
  
  private fun merge(firstIndex: Int, secondIndex: Int) {
      parents[findParent(secondIndex)] = findParent(firstIndex)
  }
}