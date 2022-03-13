class Trie() {

  private val head = Node()
  
  fun insert(word: String) {
      var curr: Node? = head
      
      for (character in word) {
          val nextCurr = curr?.children?.getOrPut(character) { Node() }
          nextCurr?.hasUsedCount = (nextCurr?.hasUsedCount ?: 0) + 1
          curr = nextCurr
      }
      
      curr?.hasEndedCount = (curr?.hasEndedCount ?: 0) + 1
  }

  fun countWordsEqualTo(word: String): Int {
      var curr: Node? = head

      for (character in word) {
          val nextCurr = curr?.children?.get(character)
          if (nextCurr == null) {
              return 0
          }
          curr = nextCurr
      }
      
      return curr?.hasEndedCount ?: 0
  }

  fun countWordsStartingWith(prefix: String): Int {
      var curr: Node? = head

      for (character in prefix) {
          val nextCurr = curr?.children?.get(character)
          if (nextCurr == null) {
              return 0
          }
          curr = nextCurr
      }
      
      return curr?.hasUsedCount ?: 0
  }

  fun erase(word: String) {
      var curr: Node? = head

      for (character in word) {
          val nextCurr = curr?.children?.get(character)
          if (nextCurr == null) {
              return
          }
          nextCurr?.hasUsedCount = (nextCurr?.hasUsedCount ?: 0) - 1
          curr = nextCurr
      }
      
      curr?.hasEndedCount = (curr?.hasEndedCount ?: 0) - 1
  }
  
  data class Node(
      val children: MutableMap<Char, Node?> = mutableMapOf(),
      var hasUsedCount: Int = 0,
      var hasEndedCount: Int = 0
  )
}

/**
* Your Trie object will be instantiated and called as such:
* var obj = Trie()
* obj.insert(word)
* var param_2 = obj.countWordsEqualTo(word)
* var param_3 = obj.countWordsStartingWith(prefix)
* obj.erase(word)
*/