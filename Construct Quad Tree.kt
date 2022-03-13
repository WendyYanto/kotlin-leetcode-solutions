/**
 * Definition for a QuadTree node.
 * class Node(var `val`: Boolean, var isLeaf: Boolean) {
 *     var topLeft: Node? = null
 *     var topRight: Node? = null
 *     var bottomLeft: Node? = null
 *     var bottomRight: Node? = null
 * }
 */

class Solution {
  private lateinit var grid: Array<IntArray>
  
  fun construct(grid: Array<IntArray>): Node? {
      this.grid = grid
      
      return getNode(0, 0, grid.size)
  }
  
  private fun getNode(left: Int, top: Int, n: Int): Node? {
      if (n == 0) {
          return null
      }
      
      var sum = 0
      
      for (i in top..(top+n-1)) {
          for (j in left..(left+n-1)) {
              sum += grid[i][j]
          }
      }
      
      val isAllZero = sum == 0
      val isAllOne = sum == (n*n)
      
      val isLeaf = isAllZero || isAllOne
      
      val halfSize = n / 2
      
      return Node(isAllOne,isLeaf).apply {
          topLeft = if (isLeaf) {
              null
          } else {
              getNode(left, top, halfSize)
          }

          topRight = if (isLeaf) {
              null
          } else {
              getNode(left + halfSize, top, halfSize)
          }

          bottomLeft = if (isLeaf) {
              null
          } else {
              getNode(left, top + halfSize, halfSize)
          }

          bottomRight = if (isLeaf) {
              null
          } else {
              getNode(left + halfSize, top + halfSize, halfSize)
          }
      }
  }
}