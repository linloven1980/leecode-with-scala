package learn7
import scala.collection.mutable.Queue
import scala.collection.mutable.Stack
import scala.collection.mutable.ListBuffer

object Test12 {
  case class TreeNode(value: Int, left: TreeNode, right: TreeNode)
  def getbottomleft(top: TreeNode): Int = {
    val q: Queue[TreeNode] = Queue.empty
    val l: ListBuffer[Array[Int]] = ListBuffer.empty
    q.enqueue(top)
    while (!q.isEmpty){
      val a: Array[Int] = new Array[Int](q.size)
      for (i <- 1 to q.size) {
        val n = q.dequeue()
        a(i - 1) = n.value
        if (n.left != null) q.enqueue(n.left)
        if (n.right != null) q.enqueue(n.right)

      }
      l.append(a)
    }
    l(l.size - 1)(0)
  }

  def getbottomleft1(top: TreeNode): Int = {
    val s: Stack[TreeNode] = Stack.empty
    var depth: Int = 0
    var resultdepth: Int = 0
    var result: Int = 0
    s.push(top)

    while (!s.isEmpty) {
      val n = s.pop()
      if (n != null) {
        s.push(n)
        s.push(null)
        depth += 1
        if (depth > resultdepth) {
          result = n.value
          resultdepth = depth
        }
        if (n.right != null) s.push(n.right)
        if (n.left != null) s.push(n.left)
      } else {
        s.pop()
        depth -= 1
      }
    }
    result
  }

  def getbottomleft2(top: TreeNode, depth: Int, l: ListBuffer[Int]): Unit = {
    if (top == null) return
    if (depth + 1 > l.size) l.append(top.value)
    getbottomleft2(top.left, depth + 1, l)
    getbottomleft2(top.right, depth + 1, l)
  }

  def main(args: Array[String]): Unit = {
    val tree = TreeNode(5, TreeNode(3, TreeNode(4, null, null), TreeNode(6, null, null)), TreeNode(2, TreeNode(8, TreeNode(10, null, null), null), TreeNode(7, null, null)))
    println(getbottomleft(tree))
    println(getbottomleft1(tree))
    val l: ListBuffer[Int] = ListBuffer.empty
    getbottomleft2(tree, 0, l)
    println(l(l.size - 1))
  }

}
