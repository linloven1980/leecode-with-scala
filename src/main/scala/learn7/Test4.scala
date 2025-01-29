package learn7
import scala.collection.mutable.Stack
import scala.collection.mutable.Queue
import scala.collection.mutable.ListBuffer
object Test4 {
  case class TreeNode(value: Int, var left: TreeNode, var right: TreeNode)
  def inverttree(top: TreeNode): Unit = {
    if (top != null) {
      val n = top.left
      top.left = top.right
      top.right = n
      inverttree(top.left)
      inverttree(top.right)
    }
  }

  def inverttree1(top: TreeNode): Unit = {
    val s: Stack[TreeNode] = Stack.empty
    s.push(top)

    while (!s.isEmpty) {
      val t = s.pop()
      val n = t.left
      t.left = t.right
      t.right = n
      if (t.left != null) s.push(t.left)
      if (t.right != null) s.push(t.right)
    }
  }

  def inverttree2(top: TreeNode): Unit = {
    val q: Queue[TreeNode] = Queue.empty
    q.enqueue(top)
    while (!q.isEmpty){
      for (i <- 1 to q.size) {
        val t = q.dequeue()
        val n = t.left
        t.left = t.right
        t.right = n
        if (t.left != null) q.enqueue(t.left)
        if (t.right != null) q.enqueue(t.right)
      }

    }
  }

  def main(args: Array[String]): Unit = {
    val tree = TreeNode(5, TreeNode(3, TreeNode(4, null, null), TreeNode(6, null, null)), TreeNode(2, TreeNode(8, null, null), TreeNode(7, null, null)))
    inverttree(tree)
    println(tree)
    inverttree1(tree)
    println(tree)
    inverttree2(tree)
    println(tree)
  }

}
