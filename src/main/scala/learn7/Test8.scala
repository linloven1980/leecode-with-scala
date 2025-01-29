package learn7
import scala.collection.mutable.Queue
object Test8 {
  case class TreeNode(value: Int, left: TreeNode, right: TreeNode)
  def getnodesum(top: TreeNode): Int = {
    if (top == null) return 0
    else return getnodesum(top.left) + getnodesum(top.right) + 1
  }

  def getnodesum1(top: TreeNode): Int = {
    val q: Queue[TreeNode] = Queue.empty
    q.enqueue(top)
    var sum = 0
    while (!q.isEmpty) {
      val n = q.dequeue()
      sum += 1
      if (n.left != null) q.enqueue(n.left)
      if (n.right != null) q.enqueue(n.right)
    }
    sum
  }

  def getnodesum2(top: TreeNode): Int = {
    if (top == null) return 0
    var leftdepth = 1
    var rightdepth = 1
    var left = top.left
    var right = top.right
    while (left != null) {
      leftdepth += 1
      left =left.left
    }
    while (right != null) {
      rightdepth += 1
      right = right.right
    }
    if (leftdepth == rightdepth) return math.pow(2, leftdepth).toInt - 1
    return getnodesum2(top.left) + getnodesum2(top.right) + 1
  }

  def main(args: Array[String]): Unit = {
    val tree = TreeNode(5, TreeNode(3, TreeNode(4, null, null), TreeNode(6, null, null)), TreeNode(2, TreeNode(8, null, null), null))
    println(getnodesum(tree))
    println(getnodesum1(tree))
    println(getnodesum2(tree))
  }

}
