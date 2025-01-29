package learn7
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Stack
object Test10 {
  case class TreeNode(value: Int, left: TreeNode, right: TreeNode)
  def getallpath(top: TreeNode, thispath: List[Int], allpath: ListBuffer[List[Int]]): Unit = {
    val l: List[Int] = thispath :+ top.value
    if (top.left == null && top.right == null) {
      allpath.append(l)
    } else {
      if (top.left != null) getallpath(top.left, l, allpath)
      if (top.right != null) getallpath(top.right, l, allpath)
    }

  }
  def getallpath1(top: TreeNode): ListBuffer[List[Int]] = {
    val s: Stack[TreeNode] = Stack.empty
    val paths: Stack[List[Int]] = Stack.empty
    s.push(top)
    val path: List[Int] = List(top.value)
    paths.push(path)
    val result: ListBuffer[List[Int]] = ListBuffer.empty
    while (!s.isEmpty) {
      val n = s.pop()
      val p = paths.pop()
      if (n.left == null && n.right == null) {
        result.append(p)
      }
      if (n.right != null) {
        s.push(n.right)
        paths.push(p :+ n.right.value)
      }
      if (n.left != null) {
        s.push((n.left))
        paths.push(p :+ n.left.value)
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val tree = TreeNode(5, TreeNode(3, TreeNode(4, null, null), TreeNode(6, null, null)), TreeNode(2, TreeNode(8, null, null), null))
    val tree1 = TreeNode(5, TreeNode(3, TreeNode(4, null, null), TreeNode(6, null, null)), TreeNode(2, TreeNode(8, null, null), TreeNode(7, null, null)))
    var thispath: List[Int] = List.empty
    var allpath: ListBuffer[List[Int]] = ListBuffer.empty
    getallpath(tree, thispath, allpath)
    println(allpath)
    thispath = List.empty
    allpath = ListBuffer.empty
    getallpath(tree1, thispath, allpath)
    println(allpath)
    println(getallpath1(tree))
    println(getallpath1(tree1))
  }

}
