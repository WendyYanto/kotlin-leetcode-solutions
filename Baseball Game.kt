class Solution {
  fun calPoints(ops: Array<String>): Int {
      val numbers: MutableList<Int> = mutableListOf()
      
      for (operation in ops) {
          when (operation) {
              "+" -> {
                  val newNumber = numbers.last() + numbers[numbers.lastIndex - 1]
                  numbers.add(newNumber)
              }
              "C" -> {
                  numbers.removeAt(numbers.lastIndex)
              }
              "D" -> {
                  numbers.add(2 * numbers.last())
              }
              else -> {
                  numbers.add(operation.toInt())
              }
          }
      }
      
      return numbers.sum() ?: 0
  }
}