package learn7
import scala.util.control.Breaks._
object Test25 {
  case class TreeNode(value: Int, var left: TreeNode, var right: TreeNode)
  def trim_binary_search_tree(top: TreeNode, a: Int, b: Int): TreeNode = {
    if (top == null) return null
    if (top.value > b) return trim_binary_search_tree(top.left, a, b)
    if (top.value < a) return trim_binary_search_tree(top.right, a, b)
    top.left = trim_binary_search_tree(top.left, a, b)
    top.right = trim_binary_search_tree(top.right, a, b)
    top

  }

  def trim_binary_search_tree1(top: TreeNode, a: Int, b: Int): TreeNode = {
    var cur = top
    breakable{
      while (cur != null) {
        if (cur.value > b) cur = cur.left
        else if (cur.value < a) cur = cur.right
        else break
      }
    }
    if (cur != null) {
      var pre = cur
      var tmp = cur
      while (tmp != null && tmp.left != null) {
        tmp = tmp.left
        if (tmp.value >= a) {
          pre = tmp
        } else {
          tmp = tmp.right
          pre.left = tmp
        }
      }
      pre = cur
      tmp = cur
      while (tmp != null && tmp.right != null) {
        tmp = tmp.right
        if (tmp.value <= b) {
          pre = tmp
        } else {
          tmp = tmp.left
          pre.right = tmp
        }
      }
    }


    cur
  }

  def main(args: Array[String]): Unit = {
    var tree = TreeNode(10, TreeNode(6, TreeNode(4, null, null), TreeNode(7, null, TreeNode(8, null, null))), TreeNode(15, TreeNode(13, TreeNode(11, null, null), null), TreeNode(17, null, null)))
    println(trim_binary_search_tree(tree, 7, 13))
    tree = TreeNode(10, TreeNode(6, TreeNode(4, null, null), TreeNode(7, null, TreeNode(8, null, null))), TreeNode(15, TreeNode(13, TreeNode(11, null, null), null), TreeNode(17, null, null)))

    println(trim_binary_search_tree(tree, 4, 7))
    tree = TreeNode(10, TreeNode(6, TreeNode(4, null, null), TreeNode(7, null, TreeNode(8, null, null))), TreeNode(15, TreeNode(13, TreeNode(11, null, null), null), TreeNode(17, null, null)))
    println(trim_binary_search_tree1(tree, 7, 13))
    tree = TreeNode(10, TreeNode(6, TreeNode(4, null, null), TreeNode(7, null, TreeNode(8, null, null))), TreeNode(15, TreeNode(13, TreeNode(11, null, null), null), TreeNode(17, null, null)))

    println(trim_binary_search_tree1(tree, 4, 7))
  }
}
