package learn7
import scala.collection.mutable.Stack
import scala.util.control.Breaks._
object Test24 {
  case class TreeNode(value: Int, var left: TreeNode, var right: TreeNode)
  def delete_from_binary_search_tree(top: TreeNode, value: Int) : TreeNode = {
    if (top == null) return null
    if (top.value == value) {
      if (top.left == null && top.right == null) return top
      if (top.left == null) return top.right
      if (top.right == null) return top.left
      var cur = top.right
      if (cur.left == null) cur.left = top.left
      else {
        while (cur.left != null) cur = cur.left
      }
      cur.left = top.left
      return top.right

    } else {
      if (top.value > value) top.left = delete_from_binary_search_tree(top.left, value)
      if (top.value < value) top.right = delete_from_binary_search_tree(top.right, value)
    }
    top
  }
  def delete_from_binary_search_tree1(top: TreeNode, value: Int): TreeNode = {
    var pre: TreeNode = null
    var cur: TreeNode = top
    breakable{
      while (cur != null) {
        if (cur.value == value) break
        else if (cur.value > value) {
          pre = cur
          cur = cur.left
        }
        else {
          pre = cur
          cur = cur.right
        }
      }
    }
    if (cur != null) {
      var tmp = cur
      if (cur.left == null && cur.right == null) tmp = null
      else if (cur.left == null) tmp = cur.right
      else if (cur.right == null) tmp = cur.left
      else {
        cur = cur.right
        while (cur.left != null) cur = cur.left
        cur.left = tmp.left
        tmp = tmp.right
      }
      if (pre == null) return tmp
      else {
        if (pre.value > value) pre.left = tmp
        else pre.right = tmp
      }
    }
    top
  }

  def main(args: Array[String]): Unit = {
    val tree = TreeNode(10, TreeNode(6, TreeNode(4, null, null), TreeNode(7, null, TreeNode(8, null, null))), TreeNode(15, TreeNode(13, TreeNode(11, null, null), null), TreeNode(17, null, null)))
    println(delete_from_binary_search_tree(tree, 6))
    println(delete_from_binary_search_tree(tree, 15))
    println(delete_from_binary_search_tree1(tree, 7))
    println(delete_from_binary_search_tree1(tree, 10))
  }

}
