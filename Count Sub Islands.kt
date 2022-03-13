class Solution {
  private val coordX = intArrayOf(0, 1, 0, -1)
  private val coordY = intArrayOf(1, 0, -1, 0)
  
  private val visited: MutableList<MutableList<Boolean>> = mutableListOf()
  
  private var totalIslands = 0
  
  private lateinit var grid1: Array<IntArray>
  private lateinit var grid2: Array<IntArray>
  
  fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
      this.grid1 = grid1
      this.grid2 = grid2
      
      for (i in 0..grid1.size - 1) {
          val visitedRow: MutableList<Boolean> = mutableListOf()
          
          for (j in 0..grid1[0].size - 1) {
              visitedRow.add(false)
          }
          
          visited.add(visitedRow.toMutableList())
      }
      
      traverse()
      
      return totalIslands
  }
  
  private fun traverse() {
      for (i in 0..grid2.size - 1) {
          for (j in 0..grid2[0].size - 1) {
              if (grid2[i][j] == 1 && 
                  visited[i][j] == false) {
                  val paths: MutableList<Pair<Int, Int>> = mutableListOf()
                  val result = floodfillGrid2(i, j, paths)
                  
                  val isAllContains = result.all { coords -> grid1[coords.first][coords.second] == 1 }
                  
                  if (isAllContains) {
                      totalIslands++
                  }
              }
          }
      }
  }
  
  private fun floodfillGrid2(i: Int, j: Int, paths: MutableList<Pair<Int, Int>>): List<Pair<Int, Int>> {
      visited[i][j] = true
      paths.add(i to j)
      
      for (coords in 0..3) {
          val nextY = i + coordY[coords]
          val nextX = j + coordX[coords]
          
          if (isValid(nextY, nextX) && 
              grid2[nextY][nextX] == 1 &&
              visited[nextY][nextX] == false) {
              
              floodfillGrid2(nextY, nextX, paths)
          }
      }
      
      return paths
  }
  
  private fun isValid(i: Int, j: Int): Boolean {
      return i >= 0 && j >= 0 && i < grid2.size && j < grid2[0].size
  }
}