/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
  private val cache: MutableMap<Pair<TreeNode?, TreeNode?>, Boolean> = mutableMapOf()
  
  fun twoSumBSTs(root1: TreeNode?, root2: TreeNode?, target: Int): Boolean {
      return traverse(root1, root2, target)
  }
  
  private fun traverse(root1: TreeNode?, root2: TreeNode?, target: Int): Boolean {
      if (root1 == null || root2 == null) {
          return false
      }
      
      if (cache[root1 to root2] != null) {
          return cache[root1 to root2]!!
      }
      
      val safeRoot1Value = root1?.`val` ?: 0
      val safeRoot2Value = root2?.`val` ?: 0
      
      val sum = safeRoot1Value + safeRoot2Value
      
      if (sum == target) {
          return true
      } else if (sum < target) {
          val result = traverse(root1?.right, root2?.right, target) || 
                  traverse(root1, root2?.right, target) ||
                  traverse(root1?.right, root2, target)
                  
          cache[root1 to root2] = result
          
          return result
      } else {
          val result = traverse(root1?.left, root2?.left, target) || 
                  traverse(root1, root2?.left, target) ||
                  traverse(root1?.left, root2, target)
                  
          cache[root1 to root2] = result  
          
          return result
      }
  }

  // other better solutions
  fun twoSumBSTs(root1: TreeNode?, root2: TreeNode?, target: Int): Boolean {
    val firstRootSets: MutableSet<Int> = mutableSetOf()
    val secondRootSets: MutableSet<Int> = mutableSetOf()
    
    generateSets(firstRootSets, root1)
    generateSets(secondRootSets, root2)
    
    return hasSum(root1, secondRootSets, target) || hasSum(root2, firstRootSets, target)
}

private fun hasSum(root: TreeNode?, numbers: Set<Int>, target: Int): Boolean {
    if (root == null) {
        return false
    }
    
    val safeValue = root?.`val` ?: 0
    val otherValue = target - safeValue
    
    if (numbers.contains(otherValue)) {
        return true
    }
    
    return hasSum(root?.left, numbers, target) || hasSum(root?.right, numbers, target)
}

private fun generateSets(numbers: MutableSet<Int>, root: TreeNode?) {
    if (root == null) {
        return
    }
    
    val safeValue = root?.`val`
    numbers.add(safeValue)
    
    generateSets(numbers, root?.left)
    generateSets(numbers, root?.right)
}
}