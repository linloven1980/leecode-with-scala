package learn7
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._
object Test21 {
  case class TreeNode(value: Int, var left: TreeNode, var right: TreeNode)
  def traversal(top: TreeNode, path: List[Int], paths: ListBuffer[List[Int]], a: Int, b: Int): Unit = {
    if (top == null) return
    if (top.value == a || top.value == b) {
      paths.append(path :+ top.value)
    }
    traversal(top.left, path :+ top.value, paths, a, b)
    traversal(top.right, path :+ top.value, paths, a, b)
  }
  def find_common_ancestor(top: TreeNode, a: Int, b: Int): Int = {
    val path: List[Int] = List.empty
    val paths: ListBuffer[List[Int]] = ListBuffer.empty
    traversal(top, path, paths, a, b)
    println(paths)
    var i = 0
    breakable{
      while (i < paths(0).length && i < paths(1).length) {
        if (paths(0)(i) == paths(1)(i)) i += 1
        else break
      }
    }
    paths(0)(i - 1)
  }

  var result = 0
  def find_common_ancestor1(top: TreeNode, a: Int, b: Int): Boolean = {
    if (top == null) return false
    val l = find_common_ancestor1(top.left, a, b)
    val r = find_common_ancestor1(top.right, a, b)
    if (l == true && r == true) {
      result = top.value
      return true
    }
    if ((l == true || r == true)) {
      if (top.value == a || top.value == b) {
        result = top.value
      }
      return true
    }
    if (top.value == a || top.value == b) return true
    false

  }

  def main(args: Array[String]): Unit = {
    val tree = TreeNode(10, TreeNode(6, TreeNode(4, null, null), TreeNode(7, null, TreeNode(8, null, null))), TreeNode(15, TreeNode(13, TreeNode(11, null, null), null), TreeNode(17, null, null)))
    println(find_common_ancestor(tree, 4, 8))
    println(find_common_ancestor(tree, 15, 17))
    find_common_ancestor1(tree, 4, 8)
    println(result)
    find_common_ancestor1(tree, 15, 17)
    println(result)
  }

}
