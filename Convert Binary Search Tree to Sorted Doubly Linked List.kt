/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 * }
 */

class Solution {
  var prev: Node? = null
  var head: Node? = null
  
  fun treeToDoublyList(root:Node?): Node? {
      traverse(root)

      // merge tail and head
      prev?.right = head
      head?.left = prev
      
      return head
  }
  
  private fun traverse(root: Node?) {
      if (root == null) {
          return
      }
      
      traverse(root?.left)
      
      if (prev == null) {
          // this will be the most left because there is no prev
          head = root
      }
      
      // connect prev and curr node
      prev?.right = root
      root?.left = prev
      
      // save current node as prev for right to be connected
      prev = root
      
      traverse(root?.right)
  }
}