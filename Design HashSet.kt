class MyHashSet() {

  private val cache = BooleanArray(1000005) { false }
  
  fun add(key: Int) {
      cache[key] = true
  }

  fun remove(key: Int) {
      cache[key] = false
  }

  fun contains(key: Int): Boolean {
      return cache[key]
  }

}

/**
* Your MyHashSet object will be instantiated and called as such:
* var obj = MyHashSet()
* obj.add(key)
* obj.remove(key)
* var param_3 = obj.contains(key)
*/

// Other Solution
class MyHashSet() {

    private val KEY_SIZE = 769
    private val buckets = Array<Bucket>(KEY_SIZE + 5) { Bucket() }
    
    private fun getHash(key: Int): Int {
        return key % KEY_SIZE
    }
    
    fun add(key: Int) {
        if (contains(key)) {
            return
        }
        
        val index = getHash(key)
        var bucket: Bucket? = buckets[index]
        
        if (bucket?.value == -1) {
            bucket?.value = key
        } else {
            var prev: Bucket? = null
            while (bucket != null) {
                prev = bucket
                bucket = bucket?.next
            }
            
            prev?.next = Bucket(key)
        }
    }

    fun remove(key: Int) {
        if (contains(key).not()) {
            return
        } 
        
        val index = getHash(key)
        
        var bucket: Bucket? = buckets[index]
        var prev: Bucket? = null
        
        while (bucket != null && bucket?.value != key) {
            prev = bucket
            bucket = bucket?.next
        }
        
        if (prev == null) {
            val newBucket = buckets[index]?.next ?: Bucket()
            
            buckets[index].value = newBucket?.value
            buckets[index].next = newBucket?.next
        } else {
            val newBucket = prev?.next
            
            newBucket?.value = newBucket?.next?.value ?: -1
            newBucket?.next = newBucket?.next?.next
        }
    }

    fun contains(key: Int): Boolean {
        val index = getHash(key)
        
        var bucket: Bucket? = buckets[index]
        
        while (bucket != null) {
            if (bucket?.value == key) {
                return true
            }
            bucket = bucket?.next
        }

        return false
    }

    data class Bucket(
      var value: Int = -1,
      var next: Bucket? = null
    )
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */