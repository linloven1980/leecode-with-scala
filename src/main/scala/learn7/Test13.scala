package learn7
import scala.collection.mutable.Stack
import scala.collection.mutable.ListBuffer
object Test13 {
  case class TreeNode(value: Int, left: TreeNode, right: TreeNode)
  def pathsum(top: TreeNode, sum: Int, target: Int): Boolean = {
    if (top.left == null && top.right == null) {
      if (top.value + sum == target) return true
      else return false
    }
    var lresult = false
    var rresult = false
    if (top.left != null) lresult = pathsum(top.left, sum + top.value, target)
    if (top.right != null) rresult = pathsum(top.right, sum + top.value, target)
    return lresult || rresult
  }

  def pathsum1(top: TreeNode, target: Int): Boolean = {
    if (top.left == null && top.right == null && top.value == target) return true
    val s: Stack[TreeNode] = Stack.empty
    var sum: Int = 0
    s.push(top)
    while (!s.isEmpty) {
      val n = s.pop()
      if (n != null) {
        s.push(n)
        s.push(null)
        sum += n.value
        if (n.left != null) s.push(n.left)
        if (n.right != null) s.push(n.right)
      } else {
        val n1 = s.pop()
        if (n1.left == null && n1.right == null && sum == target) return true
        sum -= n1.value
      }
    }
    false
  }

  def pathssum(top: TreeNode, sum: Int, target: Int, path: List[Int], paths: ListBuffer[List[Int]]): Unit = {
    if (top.left == null && top.right == null && top.value + sum == target) paths.append(path :+ top.value)
    if (top.left != null) pathssum(top.left, sum + top.value, target, path :+ top.value, paths)
    if (top.right != null ) pathssum(top.right, sum + top.value, target, path :+ top.value, paths)
  }

  def pathssum1(top: TreeNode, target: Int): ListBuffer[List[Int]] = {
    val s: Stack[TreeNode] = Stack.empty
    val paths: Stack[List[Int]] = Stack.empty
    var path: List[Int] = List.empty
    val pathsresult: ListBuffer[List[Int]] = ListBuffer.empty
    var sum: Int = 0
    s.push(top)
    paths.push(path)
    while (!s.isEmpty) {
      val n = s.pop()
      if (n != null) {
        s.push(n)
        s.push(null)

        paths.push(paths.top :+ n.value)
        sum += n.value
        if (n.left != null) s.push(n.left)
        if (n.right != null) s.push(n.right)
      } else {
        val n1 = s.pop()
        val path1 = paths.pop()
        if (n1.left == null && n1.right == null && sum == target) pathsresult.append(path1)
        sum -= n1.value
      }
    }
    pathsresult
  }

  def main(args: Array[String]): Unit = {
    val tree = TreeNode(5, TreeNode(3, TreeNode(4, null, null), TreeNode(6, null, TreeNode(11, null, null))), TreeNode(2, TreeNode(8, TreeNode(10, null, null), null), TreeNode(7, null, null)))
    println(pathsum(tree, 0, 25))
    println(pathsum(tree, 0, 22))
    println(pathsum1(tree, 25))
    println(pathsum1(tree, 22))

    val path: List[Int] = List.empty
    val paths: ListBuffer[List[Int]] = ListBuffer.empty
    pathssum(tree, 0, 25, path, paths)
    println(paths)
    println(pathssum1(tree, 25))
  }

}
