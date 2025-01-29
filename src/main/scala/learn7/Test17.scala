package learn7
import scala.util.control.Breaks._
object Test17 {
  case class TreeNode(value: Int, var left: TreeNode, var right: TreeNode)
  def binary_tree_search(top: TreeNode, target: Int): TreeNode = {
    if (top == null) return null
    if (top.value == target) return top
    if (top.value < target) return binary_tree_search(top.right, target)

    if (top.value > target) return binary_tree_search(top.left, target)
    null

  }

  def binary_tree_search1(top: TreeNode, target: Int): TreeNode = {
    var cur: TreeNode = top
    breakable{
      while (cur != null) {
        if (cur.value == target) break
        if (cur.value > target) cur = cur.left
        else cur = cur.right
      }
    }

    cur
  }

  def main(args: Array[String]): Unit = {
    val tree = TreeNode(10, TreeNode(6, TreeNode(4, null, null), TreeNode(7, null, TreeNode(9, null, null))), TreeNode(15, TreeNode(13, TreeNode(11, null, null), null), TreeNode(17, null, null)))
    println(binary_tree_search(tree, 8))
    println(binary_tree_search(tree, 7))
    println(binary_tree_search(tree, 15))
    println(binary_tree_search1(tree, 8))
    println(binary_tree_search1(tree, 7))
    println(binary_tree_search1(tree, 15))
  }

}
