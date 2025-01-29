package learn7
import scala.collection.mutable.Stack
object Test23 {
  case class TreeNode(value: Int, var left: TreeNode, var right: TreeNode)
  def insert_binary_search_tree(top: TreeNode, node: TreeNode): Unit = {
    if (top.value < node.value) {
      if (top.right == null) {
        top.right = node
        return
      } else {
        insert_binary_search_tree(top.right, node)
      }
    }
    if (top.value > node.value) {
      if (top.left == null) {
        top.left = node
        return
      } else {
        insert_binary_search_tree(top.left, node)
      }
    }
  }
  def insert_binary_search_tree1(top: TreeNode, value: Int): TreeNode = {
    val s: Stack[TreeNode] = Stack.empty
    s.push(top)
    while (true) {
      val n = s.pop()
      if (n.value < value) {
        if (n.right == null) {
          n.right = TreeNode(value, null, null)
          return top
        }
        else s.push(n.right)
      }
      if (n.value > value) {
        if (n.left == null) {
          n.left = TreeNode(value, null, null)
          return top
        } else s.push(n.left)
      }
    }
    top
  }
  def main(args: Array[String]): Unit = {
    val tree = TreeNode(10, TreeNode(6, TreeNode(4, null, null), TreeNode(7, null, TreeNode(8, null, null))), TreeNode(15, TreeNode(13, TreeNode(11, null, null), null), TreeNode(17, null, null)))
    insert_binary_search_tree(tree, TreeNode(9, null, null))
    println(tree)
    println(insert_binary_search_tree1(tree, 12))
  }

}
