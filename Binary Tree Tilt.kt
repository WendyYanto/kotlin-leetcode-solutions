import kotlin.math.abs

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
    var sum = 0
    
    fun findTilt(root: TreeNode?): Int {
        getSum(root)
        return sum
    }
    
    fun getSum(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        
        val leftSum = getSum(root?.left)
        val rightSum = getSum(root?.right)
        val value = root?.`val` ?: 0
        
        sum += abs(leftSum - rightSum)
        
        return value + leftSum + rightSum
    }
}