class Solution {
  fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
      for (row in box) {
          var index = 0
          var leftIndex = 0
          var count = 0
          
          // make box down by gravity
          while (index < row.size) {
              if (row[index] == '#') {
                  count++
              } else if (row[index] == '*') {
                  var prevIndex = index - 1
                  
                  while (count > 0 && prevIndex >= leftIndex) {
                      row[prevIndex] = '#'
                      count--
                      prevIndex--
                  }
                  
                  while (prevIndex >= leftIndex) {
                      row[prevIndex] = '.'
                      prevIndex--
                  }
                  
                  leftIndex = index + 1
              }
              
              index++
          }
          
          if (count > 0) {
              var prevIndex = row.size - 1
              while (count > 0 && prevIndex >= leftIndex) {
                  row[prevIndex] = '#'
                  prevIndex--
                  count--
              }
              
              while (prevIndex >= leftIndex) {
                  row[prevIndex] = '.'
                  prevIndex--
              }
          }
      }
      
      val result = Array(box[0].size) { CharArray(box.size) }
      
      var columnIndex = 0
      var boxRowIndex = box.size - 1
      
      // rotate box
      while (columnIndex < box.size) {
          var rowIndex = 0
          
          for (i in 0 .. box[0].size - 1) {
              result[rowIndex][columnIndex] = box[boxRowIndex][i]
              rowIndex++
          }
          
          boxRowIndex--
          columnIndex++
      }
      
      return result
  }
}