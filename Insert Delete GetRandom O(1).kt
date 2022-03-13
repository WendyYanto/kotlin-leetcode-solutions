class RandomizedSet() {

  private val numbers: MutableList<Int> = mutableListOf()
  private val numberIndex: MutableMap<Int, Int> = mutableMapOf()
  private var index = 0
  
  fun insert(`val`: Int): Boolean {
      if (numberIndex[`val`] != null) {
          return false
      }
      
      numbers.add(`val`)
      numberIndex[`val`] = index
      index++
      
      return true
  }

  fun remove(`val`: Int): Boolean {
      if (numberIndex[`val`] == null) {
          return false
      }
      
      val toDeleteIndex = numberIndex[`val`] ?: 0
      val lastNumber = numbers.last()
      
      // swap with last number
      numbers[toDeleteIndex] = lastNumber
      numberIndex[lastNumber] = toDeleteIndex
      
      numberIndex.remove(`val`)
      numbers.removeAt(numbers.lastIndex)
      index--
      
      return true
  }

  fun getRandom(): Int {
      val index = (0..(index - 1)).random()
      return numbers[index]
  }

}

/**
* Your RandomizedSet object will be instantiated and called as such:
* var obj = RandomizedSet()
* var param_1 = obj.insert(`val`)
* var param_2 = obj.remove(`val`)
* var param_3 = obj.getRandom()
*/