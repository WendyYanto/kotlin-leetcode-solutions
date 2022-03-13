class Solution {
  fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
      val grid = mat
      
      var rowIndex = 0
      var columnIndex = 0
      
      var shouldReverse = false
      val results: MutableList<Int> = mutableListOf()
      
      while (columnIndex < mat[0].size) {
          
          var row = rowIndex
          var column = columnIndex
          
          val numbers: MutableList<Int> = mutableListOf()
          
          while (row >= 0 && column < mat[0].size) {
              numbers.add(grid[row][column])
              row--
              column++
          }
          
          val filteredNumbers = if (shouldReverse) {
              numbers.reversed()
          } else {
              numbers
          }
          
          results.addAll(filteredNumbers)
          
          shouldReverse = shouldReverse.not()
          
          if (rowIndex + 1 == mat.size) {
              columnIndex++
          } else {
              rowIndex++
          }
      }
      
      return results.toIntArray()
  }
}