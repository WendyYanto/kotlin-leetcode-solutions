class Solution {
  fun isValidSudoku(board: Array<CharArray>): Boolean {
      val rowSets = Array<MutableSet<Int>>(9) { mutableSetOf() }
      val columnSets = Array<MutableSet<Int>>(9) { mutableSetOf() }
      val miniBoxSets = Array<MutableSet<Int>>(9) { mutableSetOf() }
      
      for (i in 0 .. board.size - 1) {
          for (j in 0 .. board[0].size - 1) {
              if (board[i][j] == '.') {
                  continue
              }
              
              val number = board[i][j].toInt()
              
              if (rowSets[i].contains(number)) {
                  return false
              }
              rowSets[i].add(number)
              
              if (columnSets[j].contains(number)) {
                  return false
              }
              columnSets[j].add(number)
              
              val miniBoxKey = (i/3) * 3 + (j/3)
              if (miniBoxSets[miniBoxKey].contains(number)) {
                  return false
              }
              miniBoxSets[miniBoxKey].add(number)
          }
      }
      
      return true
  }
}