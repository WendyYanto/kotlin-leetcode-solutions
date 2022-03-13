class Solution {
  private val visited = Array(55) { BooleanArray(55) { false } }
  private val directions = arrayOf(intArrayOf(1,0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
  
  private val directionSteps = arrayOf("U", "R", "D", "L")
  private var height = 0
  private var width = 0
  private lateinit var grid: Array<IntArray>
  
  fun numDistinctIslands(grid: Array<IntArray>): Int {
      height = grid.size
      width = grid[0].size
      this.grid = grid
      
      val results: MutableSet<String> = mutableSetOf()
      
      for (i in 0 .. grid.size - 1) {
          for (j in 0 .. grid[0].size - 1) {
              if (grid[i][j] == 1 && visited[i][j].not()) {
                  val ways = getWays(i, j)
                  results.add(ways)
              }
          }
      }
      
      return results.size
  }
  
  private fun getWays(row: Int, column: Int): String {
      visited[row][column] = true
      var takeDirection = StringBuilder()
      
      for (i in 0 .. directions.size - 1) {
          val direction = directions[i]
          val newRow = direction[0] + row
          val newColumn = direction[1] + column
          
          if (isValid(newRow, newColumn) && grid[newRow][newColumn] == 1 &&
                  visited[newRow][newColumn].not()) {
              takeDirection.append(directionSteps[i])
              takeDirection.append(getWays(newRow, newColumn))
              takeDirection.append("#")
          }
      }
      
      return takeDirection.toString()
  }
  
  private fun isValid(row: Int, column: Int): Boolean {
      return row >= 0 && row < height && column >= 0 && column < width
  }
}