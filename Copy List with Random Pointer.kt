/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution {
  private val nodeCached: MutableMap<Node?, Node?> = mutableMapOf()
  
  fun copyRandomList(node: Node?): Node? {
      return constructNode(node)
  }
  
  private fun constructNode(node: Node?): Node? {
      if (node == null) {
          return null
      }
      
      if (nodeCached[node] != null) {
          return nodeCached[node]
      }
      
      val newNode = Node(node?.`val` ?: 0)
      nodeCached[node] = newNode
      newNode?.next = constructNode(node?.next)
      newNode?.random = constructNode(node?.random)
      
      return newNode
  }
}