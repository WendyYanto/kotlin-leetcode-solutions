class CombinationIterator(
    private val characters: String,
    private val combinationLength: Int) {

    val combinations: MutableList<String> = mutableListOf()
    var index = 0
    
    init {
        traverse(0, "")
    }
    
    fun traverse(index: Int, value: String) {
        if (value.length == combinationLength) {
            combinations.add(value)
            return
        }
        for (i in index..characters.length-1) {
            traverse(i+1, value + characters[i])
        }
    }
    
    fun next(): String {
        return combinations.get(index++)
    }

    fun hasNext(): Boolean {
        return combinations.getOrNull(index) != null
    }

}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * var obj = CombinationIterator(characters, combinationLength)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */