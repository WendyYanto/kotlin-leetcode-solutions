class Solution {
    
  fun spiralOrder(matrix: Array<IntArray>): List<Int> {
      var leftColumn = 0 
      var rightColumn = matrix[0].size - 1
      var topRow = 0 
      var bottomRow = matrix.size - 1
      
      val results: MutableList<Int> = mutableListOf()
      
      while (leftColumn <= rightColumn && topRow <= bottomRow) {
          // left to right
          var index = leftColumn
          while (index <= rightColumn) {
              results.add(matrix[topRow][index])
              index++
          }
          topRow++
          
          // right to bottom
          index = topRow
          if (topRow > bottomRow) {
              break
          }
          while (index <= bottomRow) {
              results.add(matrix[index][rightColumn])
              index++
          }
          rightColumn--
          
          // bottom to left
          index = rightColumn
          if (index < leftColumn) {
              break
          }
          while (index >= leftColumn) {
              results.add(matrix[bottomRow][index])
              index--
          }
          bottomRow--
          
          // left to top
          index = bottomRow
          if (index < topRow) {
              break
          }
          while (index >= topRow) {
              results.add(matrix[index][leftColumn])
              index--
          }
          leftColumn++
      }
      
      return results
  }
}