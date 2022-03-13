data class Value(
  var value: Int,
  var min: Int
)

class MinStack() {

    val stack = ArrayDeque<Value>()
    var minimumValue: Int = Int.MAX_VALUE
    
    fun push(`val`: Int) {
        minimumValue = Math.min(`val`, minimumValue)
        stack.push(Value(`val`, minimumValue))
    }

    fun pop() {
        stack.pop()
        minimumValue = if (stack.isNotEmpty()) {
            getMin()
        } else {
            Int.MAX_VALUE
        }
    }

    fun top(): Int {
        return stack.peek().value
    }

    fun getMin(): Int {
        return stack.peek().min
    }

}