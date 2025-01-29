package learn7
import scala.collection.mutable.Queue
object Test26 {
  case class TreeNode(value: Int, var left: TreeNode, var right: TreeNode)
  def make_binary_search_tree(a: Array[Int], l: Int, r: Int): TreeNode = {
    if (l == r) return TreeNode(a(l), null, null)
    val index = (l + r) / 2
    var left: TreeNode = null
    if (l < index) left = make_binary_search_tree(a, l, index - 1)
    val top = TreeNode(a(index), left, make_binary_search_tree(a, index + 1, r))
    top
  }

  def make_binary_search_tree1(a: Array[Int], l: Int, r: Int): TreeNode = {
    val node_q: Queue[TreeNode] = Queue.empty
    val left_q: Queue[(Int, Int)] = Queue.empty
    val right_q: Queue[(Int, Int)] = Queue.empty
    var index = (l + r) / 2
    val top = TreeNode(a(index), null, null)
    node_q.enqueue(top)
    left_q.enqueue((l, index - 1))
    right_q.enqueue((index + 1, r))
    while (!node_q.isEmpty) {
      val n = node_q.dequeue()
      var left_node: TreeNode = null
      val left = left_q.dequeue()
      if (left._1 == left._2) left_node = TreeNode(a(left._1), null, null)
      else if (left._1 < left._2) {
        index = (left._1 + left._2) / 2
        left_node = TreeNode(a(index), null, null)
        node_q.enqueue(left_node)
        left_q.enqueue((left._1, index - 1))
        right_q.enqueue((index + 1, left._2))
      }
      n.left = left_node
      var right_node: TreeNode = null
      val right = right_q.dequeue()
      if (right._1 == right._2) right_node = TreeNode(a(right._1), null, null)
      else if (right._1 < right._2) {
        index = (right._1 + right._2) / 2
        right_node = TreeNode(a(index), null, null)
        node_q.enqueue(right_node)
        left_q.enqueue((right._1, index - 1))
        right_q.enqueue((index + 1, right._2))
      }
      n.right = right_node
    }
    top
  }

  def main(args: Array[String]): Unit = {
    println(make_binary_search_tree(Array[Int](-10, -3, 0, 5, 9), 0, 4))
    println(make_binary_search_tree1(Array[Int](-10, -3, 0, 5, 9), 0, 4))
  }

}
