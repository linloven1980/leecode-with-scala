package learn7
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Stack
object Test18 {
  case class TreeNode(value: Int, var left: TreeNode, var right: TreeNode)
  def mid_order_traversal(top: TreeNode, l: ListBuffer[Int]): Unit = {
    if (top == null) return
    mid_order_traversal(top.left, l)
    l.append(top.value)
    mid_order_traversal(top.right, l)
  }
  def is_binary_search_tree(top: TreeNode): Boolean = {
    val l: ListBuffer[Int] = ListBuffer.empty
    mid_order_traversal(top, l)
    println(l)
    for (i <- 0 until l.length - 1) {
      if (l(i) > l(i + 1)) return false
    }
    true
  }

  def is_binary_search_tree1(top: TreeNode): (Int, Int, Boolean) = {
    if (top.left == null && top.right == null) return (top.value, top.value, true)
    var left: (Int, Int, Boolean) = null
    if (top.left != null) left = is_binary_search_tree1(top.left)
    else left = (top.value, top.value, true)
    var right: (Int, Int, Boolean) = null
    if (top.right != null) right = is_binary_search_tree1(top.right)
    else right = (top.value, top.value, true)
    if (left._3 == false || right._3 == false) return (0, 0, false)
    if (top.value < left._2 || top.value > right._1) return (0, 0, false)
    (left._1, right._2, true)
  }

  var max: Long = Long.MinValue
  def is_binary_search_tree2(top: TreeNode): Boolean = {
    if (top == null) return true
    val left = is_binary_search_tree2(top.left)
    if (top.value >= max) max = top.value
    else return false
    val right = is_binary_search_tree2(top.right)
    left && right
  }

  def is_binary_search_tree3(top: TreeNode): Boolean = {
    val s: Stack[TreeNode] = Stack.empty
    var max: Long = Long.MinValue
    s.push(top)
    while (!s.isEmpty) {
      val n = s.pop()
      if (n != null) {
        if (n.right != null) s.push(n.right)
        s.push(n)
        s.push(null)
        if (n.left != null) s.push(n.left)
      } else {
        val n1 = s.pop()
        if (n1.value > max) max = n1.value
        else return false
      }
    }
    true
  }

  def main(args: Array[String]): Unit = {
    val tree = TreeNode(10, TreeNode(6, TreeNode(4, null, null), TreeNode(7, null, TreeNode(9, null, null))), TreeNode(15, TreeNode(13, TreeNode(11, null, null), null), TreeNode(17, null, null)))
    val tree1 = TreeNode(10, TreeNode(6, TreeNode(4, null, null), TreeNode(7, null, TreeNode(11, null, null))), TreeNode(15, TreeNode(13, TreeNode(11, null, null), null), TreeNode(17, null, null)))

    println(is_binary_search_tree(tree))
    println(is_binary_search_tree(tree1))
    println(is_binary_search_tree1(tree))
    println(is_binary_search_tree1(tree1))
    println(is_binary_search_tree2(tree))
    println(is_binary_search_tree2(tree1))
    println(is_binary_search_tree3(tree))
    println(is_binary_search_tree3(tree1))
  }

}
