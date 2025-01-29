package learn7
import scala.collection.mutable.Stack
object Test9 {
  case class TreeNode(value: Int, left: TreeNode, right: TreeNode)
  def isbalancetree(top: TreeNode): Int = {
    if (top == null) return 0
    val leftdepth = isbalancetree(top.left)
    val rightdepth = isbalancetree(top.right)
    if (leftdepth == -1 || rightdepth == -1) return -1
    if (math.abs(leftdepth - rightdepth) > 1) return - 1
    return math.max(leftdepth, rightdepth) + 1
  }

  def getdepth(top: TreeNode): Int = {
    if (top == null) return 0
    val s: Stack[TreeNode] = Stack.empty
    var depth = 0
    var result = 0
    s.push(top)
    while (!s.isEmpty) {
      val n = s.pop()
      if (n != null) {
        s.push(n)
        s.push(null)
        depth += 1
        if (result < depth) result = depth
        if (n.left != null) s.push(n.left)
        if (n.right != null) s.push(n.right)
      } else {
        s.pop()
        depth -= 1
      }
    }
    result
  }

  def isbalancetree1(top: TreeNode): Boolean = {
    val s: Stack[TreeNode] = Stack.empty
    s.push(top)
    while (!s.isEmpty) {
      val n = s.pop()
      val leftdepth = getdepth(n.left)
      val rightdepth = getdepth(n.right)
      if (math.abs(leftdepth - rightdepth) > 1) return false
      if (n.left != null) s.push(n.left)
      if (n.right != null) s.push(n.right)

    }
    true
  }

  def main(args: Array[String]): Unit = {
    val tree = TreeNode(5, TreeNode(3, TreeNode(4, null, null), TreeNode(6, null, null)), TreeNode(2, TreeNode(8, null, null), null))
    val tree1 = TreeNode(5, TreeNode(3, TreeNode(4, null, null), TreeNode(6, null, null)), null)
    println(isbalancetree(tree))
    println(isbalancetree(tree1))
    println(getdepth(tree))
    println(isbalancetree1(tree))
    println(isbalancetree1(tree1))
  }
}
