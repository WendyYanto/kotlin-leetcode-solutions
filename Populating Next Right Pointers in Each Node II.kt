/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
  fun connect(root: Node?): Node? {
      val nodeQueue: Queue<Node?> = LinkedList<Node?>()
      
      nodeQueue.add(root)
      
      while (nodeQueue.isNotEmpty()) {
          val size = nodeQueue.size
          var index = 0
          
          var prevNode: Node? = null
          while (index < size) {
              val node = nodeQueue.poll()
              
              if (prevNode != null) {
                  prevNode?.next = node
              }
              
              prevNode = node
              index++
              
              if (node?.left != null) {
                  nodeQueue.add(node?.left)
              }
              
              if (node?.right != null) {
                  nodeQueue.add(node?.right)
              }
          }
      }
      
      return root
  }
}