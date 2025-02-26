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
    var result = 0
    private val smallest: MutableMap<TreeNode, Int> = mutableMapOf()
    private val largest: MutableMap<TreeNode, Int> = mutableMapOf()

    fun largestBSTSubtree(root: TreeNode?): Int {
        traverse(root)
        return result
    }

    private fun traverse(root: TreeNode?): Int {
        // not possible
        val safeRoot = root ?: return 0

        val goLeft = traverse(safeRoot.left)
        val goRight = traverse(safeRoot.right)

        // if largest[] is null, it means it is no longer valid bst subtree
        val left = safeRoot.left != null && 
            largest[safeRoot.left!!] != null &&
            largest[safeRoot.left!!]!! < safeRoot.`val`
        
        // if smallest[] is null, it means it is no longer valid bst subtree
        val right = safeRoot.right != null && 
            smallest[safeRoot.right!!] != null &&
            smallest[safeRoot.right!!]!! > safeRoot.`val`

        val hasValidLeft = safeRoot.left == null || (left && goLeft > 0)
        val hasValidRight = safeRoot.right == null || (right && goRight > 0)
    
        // valid BST because we need all subtree are valid
        if (hasValidLeft && hasValidRight) {
            val value = 1 + goLeft + goRight
            result = maxOf(result, value)
            smallest[safeRoot] = safeRoot.left?.let {
                minOf(smallest[it]!!, safeRoot.`val`)
            } ?: safeRoot.`val`
            
            largest[safeRoot] = safeRoot.right?.let {
                maxOf(largest[it]!!, safeRoot.`val`)
            } ?: safeRoot.`val`
            
            return value
        }
        
        return 0
    }
}
