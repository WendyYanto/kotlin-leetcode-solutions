class Solution {
  private val grids: MutableList<CharArray> = mutableListOf()
  private var resultCount = 0
  private var targetQueen = 0

  fun totalNQueens(n: Int): Int {
    targetQueen = n
    for (i in 0..n - 1) {
      val charArray = CharArray(n)

      for (j in 0..n - 1) {
        charArray[j] = '.'
      }
      grids.add(charArray)
    }

    backtrack(0, 0)

    return resultCount
  }

  private fun backtrack(column: Int, numberOfQueen: Int) {
    if (numberOfQueen == targetQueen) {
      resultCount++
      return
    }

    for (i in 0..grids.size - 1) {
      if (isValid(i, column)) {
        grids[i][column] = 'Q'
        backtrack(column + 1, numberOfQueen + 1)
        grids[i][column] = '.'
      }
    }
  }

  private fun isValid(row: Int, column: Int): Boolean {
    // go up
    for (i in row + 1..grids.size - 1) {
      if (grids[i][column] == 'Q') {
        return false
      }
    }

    // go down
    for (i in 0..row - 1) {
      if (grids[i][column] == 'Q') {
        return false
      }
    }

    // go right
    for (j in column + 1..grids.size - 1) {
      if (grids[row][j] == 'Q') {
        return false
      }
    }

    // go left
    for (j in 0..column - 1) {
      if (grids[row][j] == 'Q') {
        return false
      }
    }

    // go diagonal left up
    var i = row - 1
    var j = column - 1

    while (i >= 0 && j >= 0) {
      if (grids[i][j] == 'Q') {
        return false
      }
      i--
      j--
    }

    // go diagonal right up
    i = row - 1
    j = column + 1

    while (i >= 0 && j < grids.size) {
      if (grids[i][j] == 'Q') {
        return false
      }
      i--
      j++
    }

    // go diagonal right bottom
    i = row + 1
    j = column + 1

    while (i < grids.size && j < grids.size) {
      if (grids[i][j] == 'Q') {
        return false
      }
      i++
      j++
    }

    // go diagonal left bottom
    i = row + 1
    j = column - 1

    while (i < grids.size && j >= 0) {
      if (grids[i][j] == 'Q') {
        return false
      }
      i++
      j--
    }

    return true
  }
}
