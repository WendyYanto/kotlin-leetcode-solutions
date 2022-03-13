class Solution {
  private lateinit var rows: Array<IntArray>
  
  fun smallestCommonElement(mat: Array<IntArray>): Int {
      rows = mat
      val results = traverse(0, rows.size - 1)
      
      if (results.isEmpty()) {
          return -1
      } else {
          return results.first()
      }
  }
  
  private fun traverse(left: Int, right: Int): List<Int> {
      if (left > right) {
          return emptyList()
      } else if (left == right) {
          return rows[left].toList()
      } 
      
      val mid = (left + right) / 2
      
      val firstRows = traverse(left, mid)
      val secondRows = traverse(mid + 1, right)
      
      return getCommon(firstRows, secondRows)
  }
  
  private fun getCommon(firstRows: List<Int>, secondRows: List<Int>): List<Int> {
      var firstIndex = 0
      var secondIndex = 0
      
      val results: MutableList<Int> = mutableListOf()
      
      while (firstIndex < firstRows.size && secondIndex < secondRows.size) {
          if (firstRows[firstIndex] == secondRows[secondIndex]) {
              results.add(firstRows[firstIndex])
              firstIndex++
              secondIndex++
          } else if (firstRows[firstIndex] > secondRows[secondIndex]) {
              secondIndex++
          } else {
              firstIndex++
          }
      }
      
      return results
  }
}