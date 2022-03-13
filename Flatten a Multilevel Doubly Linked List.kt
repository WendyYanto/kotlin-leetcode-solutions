/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var prev: Node? = null
 *     var next: Node? = null
 *     var child: Node? = null
 * }
 */

class Solution {
  fun flatten(root: Node?): Node? {
      var curr = root
      
      while (curr != null) {
          if (curr?.child != null) {
              var childNode = flatten(curr?.child)
              val tempCurrNext = curr?.next
              
              curr?.child = null
              curr?.next = childNode
              childNode?.prev = curr
              
              var currChildNode = childNode
              var prev: Node? = null
              while (currChildNode != null) {
                  prev = currChildNode
                  currChildNode = currChildNode?.next
              }
              
              prev?.next = tempCurrNext
              tempCurrNext?.prev = prev
              
              curr = prev
          }
          
          curr = curr?.next
      }
      
      return root
  }
}