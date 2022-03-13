class Solution {
  private val visited: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()
  private lateinit var rooms: Array<IntArray>

  private var height = 0
  private var width = 0
  
  private val directions: List<Pair<Int, Int>> = listOf(-1 to 0, 0 to 1, 1 to 0, 0 to -1)
  
  private val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
  
  fun wallsAndGates(rooms: Array<IntArray>): Unit {
      this.rooms = rooms
      
      height = rooms.size 
      width = rooms[0].size
            
      for (i in 0..rooms.size - 1) {
          for (j in 0..rooms[i].size - 1) {
              if (rooms[i][j] == 0) {
                  queue.add(i to j)
                  visited[i to j] = 0
              }
          }
      }
  
      bfs()
  }
  
  private fun bfs() {
      while (queue.isNotEmpty()) {
          val top = queue.poll()
          
          directions.map { direction ->
              (direction.first + top.first) to (direction.second + top.second)
          }.filter { direction ->
              isValid(direction.first, direction.second) && 
              rooms[direction.first][direction.second] == Integer.MAX_VALUE &&
              visited[direction] == null
          }.forEach { direction ->
              val distance = 1 + visited[top]!!
              visited[direction] = distance
              rooms[direction.first][direction.second] = distance
              queue.add(direction)
          }
      }
  }
  
  private fun isValid(row: Int, column: Int): Boolean {
      return row >= 0 && row < height && column >= 0 && column < width
  }
}