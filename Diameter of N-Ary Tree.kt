/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution {
  private var maxDiameter = 0
  
  fun diameter(root: Node?): Int {
      getMaxDepth(root)
      
      return maxDiameter
  }
  
  private fun getMaxDepth(root: Node?): Int {
      if (root == null) {
          return 0
      }
      
      var longest = 0
      var secondLongest = 0
      
      for (node in root?.children) {
          if (node == null) {
              continue
          } 
          
          val length = 1 + getMaxDepth(node)
          
          if (length > longest) {
              secondLongest = longest
              longest = length
          } else if (length > secondLongest) {
              secondLongest = length
          }
      }
      
      maxDiameter = maxOf(maxDiameter, secondLongest + longest)
      
      return longest
  }
}