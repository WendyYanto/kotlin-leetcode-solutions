class Solution {
  private lateinit var grid: Array<IntArray>
  private var height = 0
  private var width = 0
  
  private val directions = arrayOf(intArrayOf(1,0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
  
  fun getMaximumGold(grid: Array<IntArray>): Int {
      this.grid = grid
      
      height = grid.size
      width = grid[0].size
      
      var result = 0
      
      for (i in 0..grid.size - 1) {
          for (j in 0..grid[i].size - 1) {
              if (grid[i][j] != 0) {
                  result = maxOf(result, dfs(i, j))
              }
          }
      }
      
      return result
  }
  
  private fun dfs(row: Int, column: Int): Int {
      var count = 0
      val value = grid[row][column]
      count += value
      grid[row][column] = 0
      
      for (direction in directions) {
          val nextRow = row + direction[0]
          val nextColumn = column + direction[1]
          
          if (isValid(nextRow, nextColumn) && grid[nextRow][nextColumn] != 0) {
              val next = value + dfs(nextRow, nextColumn)
              count = maxOf(count, next)
          }
      }
      
      grid[row][column] = value
      
      return count
  }
  
  private fun isValid(row: Int, column: Int): Boolean {
      return row >= 0 && row < height && column >= 0 && column < width
  }
}