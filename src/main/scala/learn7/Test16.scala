package learn7
import scala.collection.mutable
import scala.collection.mutable.Stack
import scala.collection.mutable.Queue
object Test16 {
  case class TreeNode(value: Int, var left: TreeNode, var right: TreeNode)
  def combine_tree(top1: TreeNode, top2: TreeNode): TreeNode = {
    if (top1 == null && top2 == null) return null
    if (top1 != null && top2 == null) return top1
    if (top1 == null && top2 != null) return top2
    val left = combine_tree(top1.left, top2.left)
    val right = combine_tree(top1.right, top2.right)
    val top = TreeNode(top1.value + top2.value, left, right)
    top
  }

  def combine_tree1(top1: TreeNode, top2: TreeNode): TreeNode = {
    if (top1 == null && top2 == null) return null
    if (top1 != null && top2 == null) return top1
    if (top1 == null && top2 != null) return top2

    val s1: Stack[TreeNode] = Stack.empty
    val s2: Stack[TreeNode] = Stack.empty
    val s_result: Stack[TreeNode] = Stack.empty
    val top: TreeNode = TreeNode(top1.value + top2.value, null, null)
    s1.push(top1)
    s2.push(top2)
    s_result.push(top)
    while (!s1.isEmpty) {
      val n1 = s1.pop()
      val n2 = s2.pop()
      val n3 = s_result.pop()
      if (n1.right != null || n2.right != null) {
        if (n1.right != null) {
          s1.push(n1.right)
        } else {
          s1.push(TreeNode(0, null, null))
        }
        if (n2.right != null) {
          s2.push(n2.right)
        } else {
          s2.push(TreeNode(0, null, null))
        }
        val right = TreeNode(s1.top.value + s2.top.value, null, null)
        n3.right = right
        s_result.push(right)
      }
      if (n1.left != null || n2.left != null) {
        if (n1.left != null) {
          s1.push(n1.left)
        } else {
          s1.push(TreeNode(0, null, null))
        }
        if (n2.left != null) {
          s2.push(n2.left)
        } else {
          s2.push(TreeNode(0, null, null))
        }
        val left = TreeNode(s1.top.value + s2.top.value, null, null)
        n3.left = left
        s_result.push(left)
      }

    }
    top
  }

  def combine_tree2(top1: TreeNode, top2: TreeNode): TreeNode ={
    if (top1 == null) return top2
    if (top2 == null) return top1
    val q: Queue[TreeNode] = Queue.empty
    val q_result: Queue[TreeNode] = Queue.empty
    val top: TreeNode = TreeNode(top1.value + top2.value, null, null)
    q.enqueue(top1)
    q.enqueue(top2)
    q_result.enqueue(top)
    while (!q.isEmpty) {
      val n1 = q.dequeue()
      val n2 = q.dequeue()
      val n3 = q_result.dequeue()
      if (n1.left != null || n2.left != null) {
        var left_value = 0

        if (n1.left != null) {
          q.enqueue(n1.left)
          left_value = n1.left.value
        }
        else q.enqueue(TreeNode(0, null, null))
        if (n2.left != null) {
          q.enqueue(n2.left)
          left_value += n2.left.value
        }
        else q.enqueue(TreeNode(0, null, null))
        val left = TreeNode(left_value, null, null)
        n3.left = left
        q_result.enqueue(left)

      }
      if (n1.right != null || n2.right != null) {
        var right_value = 0
        if (n1.right != null) {
          q.enqueue(n1.right)
          right_value = n1.right.value
        } else q.enqueue(TreeNode(0, null, null))
        if (n2.right != null) {
          q.enqueue(n2.right)
          right_value += n2.right.value
        } else q.enqueue(TreeNode(0, null, null))
        val right = TreeNode(right_value, null, null)
        n3.right = right
        q_result.enqueue(right)
      }
    }
    top
  }

  def main(args: Array[String]): Unit = {
    val tree1 = TreeNode(1, TreeNode(3, TreeNode(5, null, null), null), TreeNode(2, null, null))
    val tree2 = TreeNode(2, TreeNode(1, null, TreeNode(4, null, null)), TreeNode(3, null, TreeNode(7, null, null)))
    println(combine_tree(tree1, tree2))
    println(combine_tree1(tree1, tree2))
    println(combine_tree2(tree1, tree2))
  }

}
