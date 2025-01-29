package learn7
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Stack
object Test19 {
  case class TreeNode(value: Int, var left: TreeNode, var right: TreeNode)
  def mid_order_traversal(top: TreeNode, l: ListBuffer[Int]): Unit = {
    if (top == null) return
    mid_order_traversal(top.left, l)
    l.append(top.value)
    mid_order_traversal(top.right, l)
  }
  def min_diff(top: TreeNode): Int = {
    val l: ListBuffer[Int] = ListBuffer.empty
    mid_order_traversal(top, l)
    var min_dif: Int = Int.MaxValue
    for (i <- 0 until l.length - 1) {
      if (l(i + 1) - l(i) < min_dif) min_dif = l(i + 1) - l(i)
    }
    min_dif
  }
  var cur: TreeNode = null
  var pre: TreeNode = null
  var diff: Int = Int.MaxValue
  def min_diff1(top: TreeNode): Unit = {
    if (top == null) return
    min_diff1(top.left)
    cur = top
    if (pre != null) {
      if (cur.value - pre.value < diff) diff = cur.value - pre.value
    }
    pre = cur
    min_diff1(top.right)
  }

  def min_diff2(top: TreeNode): Int = {
    val s: Stack[TreeNode] = Stack.empty
    var pre_value = -1
    var result = Int.MaxValue
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
        if (pre_value != -1) {
          result = math.min(n1.value - pre_value, result)
        }
        pre_value = n1.value
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val tree = TreeNode(10, TreeNode(6, TreeNode(4, null, null), TreeNode(7, null, TreeNode(9, null, null))), TreeNode(15, TreeNode(13, TreeNode(11, null, null), null), TreeNode(17, null, null)))
    println(min_diff(tree))
    min_diff1(tree)
    println(diff)
    println(min_diff2(tree))
  }

}
