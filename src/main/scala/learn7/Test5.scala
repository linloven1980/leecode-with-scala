package learn7
import scala.collection.mutable.Queue
object Test5 {
  case class TreeNode(value: Int, left: TreeNode, right: TreeNode)
  def mirrortree(tree1: TreeNode, tree2: TreeNode): Boolean ={
    if (tree1 == null && tree2 == null) return true
    if (tree1 == null && tree2 != null || tree1 != null && tree2 == null) return false
    if (tree1.value != tree2.value) return false
    else {
      return mirrortree(tree1.left, tree2.right) && mirrortree(tree1.right, tree2.left)
    }
  }
  def mirrortree1(tree1: TreeNode, tree2: TreeNode): Boolean = {

    val q: Queue[TreeNode] = Queue.empty
    q.enqueue(tree1)
    q.enqueue(tree2)
    while (!q.isEmpty) {
      val n1 = q.dequeue()
      val n2 = q.dequeue()

      if (n1 == null && n2 != null || n1 != null && n2 == null) return false
      if (n1 != null && n2 != null) {
        if (n1.value != n2.value) return false
        q.enqueue(n1.left)
        q.enqueue(n2.right)
        q.enqueue(n1.right)
        q.enqueue(n2.left)
      }
    }
    true
  }

  def main(args:Array[String]): Unit = {
    val tree = TreeNode(5, TreeNode(3, TreeNode(4, null, null), TreeNode(6, null, null)), TreeNode(2, TreeNode(8, null, null), TreeNode(7, null, null)))
    println(mirrortree(tree.left,tree.right))
    val tree1 = TreeNode(5, TreeNode(3, TreeNode(4, null, null), TreeNode(6, null, null)), TreeNode(3, TreeNode(6, null, null), TreeNode(4, null, null)))
    println(mirrortree(tree1.left,tree1.right))
    println(mirrortree1(tree.left, tree.right))
    println(mirrortree1(tree1.left, tree1.right))
  }

}
