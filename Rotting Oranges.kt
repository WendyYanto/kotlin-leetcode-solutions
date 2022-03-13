class Solution {
    
  private val directions = listOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
  
  private var height = 0
  private var width = 0
  
  fun orangesRotting(grid: Array<IntArray>): Int {
      
      val rottenQueue: Queue<Pair<Int, Int>> = LinkedList()
      
      height = grid.size
      width = grid[0].size
      
      val timeCount = Array(height) { IntArray(width) { 0 } }

      for (i in 0 .. grid.size - 1) {
          for (j in 0 .. grid[0].size - 1) {
              if (grid[i][j] == 2) {
                  rottenQueue.add(i to j)
              }
          }
      }
      
      var maxCount = 0
      
      while (rottenQueue.isNotEmpty()) {
          val orangeCell = rottenQueue.poll()
          
          maxCount = maxOf(maxCount, timeCount[orangeCell.first][orangeCell.second])
          
          for (direction in directions) {
              val nextY = orangeCell.first + direction[0]
              val nextX = orangeCell.second + direction[1]
              
              if (isValid(nextY, nextX) && grid[nextY][nextX] == 1) { 
                  grid[nextY][nextX] = 2
                  timeCount[nextY][nextX] = 1 + timeCount[orangeCell.first][orangeCell.second]
                  rottenQueue.add(nextY to nextX)
              }
          }
      }
      
      if (isAllRotten(grid)) {
          return -1
      }
      
      return maxCount
  }
  
  private fun isAllRotten(grid: Array<IntArray>): Boolean {
      for (i in 0 .. grid.size - 1) {
          for (j in 0 .. grid[0].size - 1) {
              if (grid[i][j] == 1) {
                  return true
              }
          }
      }
      
      return false
  }
  
  private fun isValid(row: Int, column: Int): Boolean {
      return row >= 0 && row < height && column >= 0 && column < width
  }
}