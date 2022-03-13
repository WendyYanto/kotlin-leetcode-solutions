class WordDictionary() {

  val head = Node()
  
  fun addWord(word: String) {
      var curr: Node? = head
      
      for (character in word) {
          curr = curr?.children?.getOrPut(character) { Node() }
      }
      
      curr?.isEnd = true
  }

  fun search(word: String): Boolean {
      return traverse(head, 0, word)
  }
  
  private fun traverse(node: Node?, index: Int, word: String): Boolean {
      if (index > word.length) {
          return false
      }
      if (index == word.length) {
          return node?.isEnd == true
      }
      
      val nextCurr = node?.children?.get(word[index])

      if (word[index] != '.') {
          return nextCurr != null && traverse(nextCurr, index + 1, word)
       }
      
       return node?.children?.values?.any { 
           value -> traverse(value, index + 1, word) 
       } == true
  }
  
  data class Node(
    val children: MutableMap<Char, Node> = mutableMapOf(),
    var isEnd: Boolean = false
  )
}

/**
* Your WordDictionary object will be instantiated and called as such:
* var obj = WordDictionary()
* obj.addWord(word)
* var param_2 = obj.search(word)
*/