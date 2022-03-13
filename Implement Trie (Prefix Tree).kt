class Trie() {

  private val head = Node()
  
  fun insert(word: String) {
      var curr: Node? = head
      
      for (i in 0 .. word.length - 1) {
          curr?.children?.getOrPut(word[i]) { Node() } 
          
          curr = curr?.children?.get(word[i])
          
          if (i == word.length - 1) {
              curr?.isCompleted = true
          }
      }
  }

  fun search(word: String): Boolean {
      var curr: Node? = head
      
      for (i in 0 .. word.length - 1) {
          if (curr?.children?.get(word[i]) == null) {
              return false
          }
          
          curr = curr?.children?.get(word[i])
      }
      
      return curr?.isCompleted == true
  }

  fun startsWith(prefix: String): Boolean {
      var curr: Node? = head
      
      for (i in 0 .. prefix.length - 1) {
          if (curr?.children?.get(prefix[i]) == null) {
              return false
          }
          
          curr = curr?.children?.get(prefix[i])
      }
      
      return true
  }

  data class Node(
    val children: MutableMap<Char, Node> = mutableMapOf(),
    var isCompleted: Boolean = false
  )
}

/**
* Your Trie object will be instantiated and called as such:
* var obj = Trie()
* obj.insert(word)
* var param_2 = obj.search(word)
* var param_3 = obj.startsWith(prefix)
*/