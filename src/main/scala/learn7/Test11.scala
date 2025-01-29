package learn7
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Stack
object Test11 {
  case class TreeNode(value: Int, left: TreeNode, right: TreeNode)
  def leftchildsum(top: TreeNode): Int  = {
    if (top == null) return 0
    if (top.left == null && top.right == null) return 0
    var lsum = 0
    if (top.left == null) lsum = 0
    else {
      if (top.left.left == null && top.left.right == null) {
        lsum = top.left.value
      } else {
        lsum = leftchildsum(top.left)
      }
    }
    var rsum = 0
    if (top.right != null) {
      rsum = leftchildsum(top.right)
    }
    lsum + rsum
  }

  def leftchildsum1(top: TreeNode): Int = {
    val s: Stack[TreeNode] = Stack.empty
    var sum = 0
    s.push(top)
    while (!s.isEmpty) {
      val n = s.pop()
      if (n.right != null) s.push(n.right)
      if (n.left != null) {
        if (n.left.left == null && n.left.right == null) sum += n.left.value
        else s.push(n.left)
      }
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    val tree = TreeNode(5, TreeNode(3, TreeNode(4, null, null), TreeNode(6, null, null)), TreeNode(2, TreeNode(8, null, null), TreeNode(7, null, null)))
    println(leftchildsum(tree))
    println(leftchildsum1(tree))
  }

}
