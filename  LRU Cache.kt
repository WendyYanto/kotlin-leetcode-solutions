class LRUCache(private val capacity: Int) {

  private var currCapacity = 0
  private val cache: MutableMap<Int, Int> = mutableMapOf()
  private val lruQueue = ArrayDeque<Int>()
  
  fun get(key: Int): Int {
      if (cache[key] == null) {
          return -1
      }
      
      lruQueue.remove(key)
      lruQueue.offerFirst(key)
      
      return cache[key] ?: -1
  }

  fun put(key: Int, value: Int) {
      val isUpdate = cache.contains(key)
      
      if (isUpdate.not() && currCapacity == capacity) {
          val key = lruQueue.getLast()
          cache.remove(key)
          lruQueue.removeLast()
          
          currCapacity--
      }
      
      if (isUpdate) {
          lruQueue.remove(key)
      } 
      
      cache[key] = value
      lruQueue.offerFirst(key)
      
      if (isUpdate.not()) {
          currCapacity++
      }
  }
}

/**
* Your LRUCache object will be instantiated and called as such:
* var obj = LRUCache(capacity)
* var param_1 = obj.get(key)
* obj.put(key,value)
*/

// Better Solution

class LRUCache(private val capacity: Int) {
    var head: Node? = null
    var tail: Node? = null
    val cache: MutableMap<Int, Node> = mutableMapOf()
    private var count = 0
    
    fun get(key: Int): Int {
        if (cache.contains(key)) {
            moveToHead(key)
            return cache[key]?.value ?: -1
        } 
        return -1
    }

    fun put(key: Int, value: Int) {
        if (cache.contains(key)) {
            cache[key]?.value = value
            moveToHead(key)
        } else {
            if (count == capacity) {
               removeTail()
               count--
            }
            val node = Node(key = key, value = value)
            cache[key] = node
            if (head == null && tail == null) {
                head = node
                tail = node
            } else {
                moveToHead(key)
            }
            count++
        }
    }
    
    private fun moveToHead(key: Int) {
        val node = cache[key]
        if (node == head) {
            return
        }
        
        if (node == tail) {
            val tailPrev = tail?.prev
            tailPrev?.next = null
            tail = tailPrev
        }
        
        val prevNode = node?.prev
        val nextNode = node?.next
        
        prevNode?.next = nextNode
        nextNode?.prev = prevNode
        
        head?.prev = node
        node?.prev = null
        node?.next = head
        
        head = node
    }
    
    private fun removeTail() {
        tail?.key?.let { safeValue ->
            cache.remove(safeValue)
        }
        
        if (tail == head) {
            head = null
            tail = null
            return
        }
        
        val prevTail = tail?.prev
        
        prevTail?.next = null
        tail = prevTail
    }
}

data class Node(
  var key: Int = 0,
  var value: Int = 0,
  var next: Node? = null,
  var prev: Node? = null
)
/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

 // Cleaner Solution
 class LRUCache(private val capacity: Int) {

    private val cachedValue: MutableMap<Int, Node?> = mutableMapOf()
    private var count = 0
    
    // dummy head and tail so that we don't need to change head and tail cases
    private var head: Node = Node()
    private var tail: Node = Node()
    
    init {
        head.next = tail
        tail.prev = head
    }
    
    fun get(key: Int): Int {
        if (cachedValue[key] == null) {
            return -1
        }
        
        val node = cachedValue[key]
        
        removeNode(node)
        addNode(node)
        
        return node?.value ?: -1
    }

    fun put(key: Int, value: Int) {
        if (cachedValue[key] != null) {
            val node = cachedValue[key]
            node?.value = value
            
            removeNode(node)
            addNode(node)
        } else {
            if (count == capacity) {
                removeEnd()
                count--
            }
        
            val newNode = Node(key = key, value = value)
            cachedValue[key] = newNode
            
            addNode(newNode)
            count++
        }
    }
    
    private fun addNode(node: Node?) {
        val firstNode = head?.next
        
        head?.next = node
        node?.prev = head
        
        firstNode?.prev = node
        node?.next = firstNode
    }
    
    private fun removeNode(node: Node?) {
        val prevNode = node?.prev
        val nextNode = node?.next
        
        prevNode?.next = nextNode
        nextNode?.prev = prevNode
    }
    
    private fun removeEnd() {
        val lastNode = tail.prev
        removeNode(lastNode)
        
        cachedValue.remove(lastNode?.key)
    }

    data class Node(
      var prev: Node? = null,
      var next: Node? = null,
      var key: Int = 0,
      var value: Int = 0
    )
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */