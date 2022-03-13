class Solution {
  private val head = Node()
  private var maxValue = ""
  
  fun longestWord(words: Array<String>): String {
      constructTrie(words)
      
      head?.children
          ?.filter { node -> node?.value?.hasEnded == true }
          ?.forEach { node -> dfs(node.value, "" + node.key) }
      
      return maxValue
  }
  
  private fun constructTrie(words: Array<String>) {
      for (word in words) {
          var curr: Node? = head
          for (character in word) {
              val nextNode = curr?.children?.getOrPut(character) { Node() }
              curr = nextNode
          }
          curr?.hasEnded = true
      }
  }
  
  private fun dfs(node: Node?, value: String) {
      if (maxValue.length < value.length) {
          maxValue = value
      } else if (maxValue.length == value.length && value < maxValue) {
          maxValue = value
      }
      
      if (node?.children?.isEmpty() == true) {
          return
      }
      
      node?.children
          ?.filter { node -> node?.value?.hasEnded == true }
          ?.forEach { node -> dfs(node.value, value + node.key) }
  }
  
  data class Node(
      var hasEnded: Boolean = false,
      val children: MutableMap<Char, Node> = mutableMapOf()
  )
}