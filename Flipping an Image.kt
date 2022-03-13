class Solution {
  fun flipAndInvertImage(image: Array<IntArray>): Array<IntArray> {
      // flip
      for (currImage in image) {
          flip(currImage)
      }
      
      for (currImage in image) {
          invert(currImage)
      }
      
      return image
  }
  
  private fun flip(currImage: IntArray) {
      var right = currImage.size - 1
      var left = 0
      
      while (left < right) {
          val temp = currImage[right]
          currImage[right] = currImage[left]
          currImage[left] = temp
          
          left++
          right--
      }
  }
  
  private fun invert(currImage: IntArray) {
      var right = currImage.size - 1
      var left = 0
      
      while (left <= right) {
          if (currImage[left] == 0) {
              currImage[left] = 1
          } else {
              currImage[left] = 0
          }
          left++
      }
  }
}