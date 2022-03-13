class MyHashMap() {

  companion object {
      private const val KEY_SIZE = 2069
  }
  
  private val buckets = Array<Bucket>(KEY_SIZE) { Bucket() } 
  
  fun put(key: Int, value: Int) {
      val index = getHashIndex(key)
      
      var bucket: Bucket? = buckets[index]
      
      var currBucket = bucket
      while (currBucket != null) {
          if (currBucket?.key == key) {
              currBucket?.value = value
              return
          }
          
          currBucket = currBucket?.next
      }
      
      var prev: Bucket? = null
      
      while (bucket != null) {
          prev = bucket
          bucket = bucket?.next
      }
      
      val newBucket = Bucket(key = key, value = value)
      
      prev?.next = newBucket
  }

  fun get(key: Int): Int {
      val index = getHashIndex(key)
      var bucket: Bucket? = buckets[index]    
  
      while (bucket != null && bucket?.key != key) {
          bucket = bucket?.next
      }
      
      return bucket?.value ?: -1
  }

  fun remove(key: Int) {
      val index = getHashIndex(key)
      var bucket: Bucket? = buckets[index]    
      var prev: Bucket? = null
      
      while (bucket != null && bucket?.key != key) {
          prev = bucket
          bucket = bucket?.next
      }
      
      if (prev != null) {
          prev?.next = bucket?.next
      } else {
          bucket?.key = -1
          bucket?.value = -1
      }
  }
  
  private fun getHashIndex(key: Int): Int {
      return key % KEY_SIZE
  }
  
  data class Bucket (
      var key: Int = -1, 
      var value: Int = -1,
      var next: Bucket? = null
  )
}   

/**
* Your MyHashMap object will be instantiated and called as such:
* var obj = MyHashMap()
* obj.put(key,value)
* var param_2 = obj.get(key)
* obj.remove(key)
*/