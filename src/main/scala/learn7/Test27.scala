package learn7
import scala.collection.mutable.Stack
object Test27 {
  case class TreeNode(var value: Int, var left: TreeNode, var right: TreeNode)
  var sum = 0
  def make_accumulating_tree(top: TreeNode): TreeNode = {
    if (top == null) return null
    make_accumulating_tree(top.right)
    sum += top.value
    top.value = sum
    make_accumulating_tree(top.left)
    top
  }
  def make_accumulating_tree1(top: TreeNode): TreeNode = {
    val s: Stack[TreeNode] = Stack.empty
    s.push(top)
    var sum = 0
    while (!s.isEmpty) {
      val n = s.pop()
      if (n != null) {
        if (n.left != null) s.push(n.left)
        s.push(n)
        s.push(null)
        if (n.right != null) s.push(n.right)
      } else {
        val n1 = s.pop()
        sum += n1.value
        n1.value = sum
      }
    }
    top
  }

  def main(args: Array[String]): Unit = {
    var tree = TreeNode(10, TreeNode(6, TreeNode(4, null, null), TreeNode(7, null, TreeNode(8, null, null))), TreeNode(15, TreeNode(13, TreeNode(11, null, null), null), TreeNode(17, null, null)))
    println(make_accumulating_tree(tree))
    tree = TreeNode(10, TreeNode(6, TreeNode(4, null, null), TreeNode(7, null, TreeNode(8, null, null))), TreeNode(15, TreeNode(13, TreeNode(11, null, null), null), TreeNode(17, null, null)))
    println(make_accumulating_tree1(tree))
  }

}
