class Solution {
  private val head = Node()
  
  fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
      saveWords(products.toList().sorted())
      
      val results: MutableList<List<String>> = mutableListOf()
      
      var currNode: Node? = head
      for (character in searchWord) {
          val node = currNode?.children?.get(character)
          if (node != null) {
              results.add(node?.words ?: emptyList())
          } else {
              results.add(emptyList())
          }
          
          currNode = node
      }
      
      return results
  }
  
  private fun saveWords(products: List<String>) {
      for (i in 0..products.size - 1) {
          val product = products[i]
          
          var currNode = head
          for (character in product) {
              val node = currNode.children.getOrPut(character) { Node() }
              if (node.words.size < 3) {
                  node.words.add(product)   
              }
              
              currNode = node
          }
      }
  }
  
  data class Node(
      val children: MutableMap<Char, Node> = mutableMapOf(),
      val words: MutableList<String> = mutableListOf()
  )
}