package learn7

import scala.collection.mutable.ListBuffer
object Test {
  case class TreeNode(value: Int, left: TreeNode, right: TreeNode)
  def preordertraversal(top: TreeNode, l: ListBuffer[Int]): Unit = {
    if (top == null) return
    l.append(top.value)
    preordertraversal(top.left, l)
    preordertraversal(top.right, l)
  }
  def midordertraversal(top: TreeNode, l: ListBuffer[Int]): Unit = {
    if (top == null) return
    midordertraversal(top.left, l)
    l.append(top.value)
    midordertraversal(top.right, l)
  }
  def backordertraversal(top: TreeNode, l: ListBuffer[Int]): Unit = {
    if (top == null) return
    backordertraversal(top.left, l)
    backordertraversal(top.right, l)
    l.append(top.value)
  }

  def main(args: Array[String]): Unit = {
    val tree = TreeNode(5, TreeNode(3, TreeNode(4, null, null), TreeNode(6, null, null)), TreeNode(2, TreeNode(8, null, null), TreeNode(7, null, null)))
    var l1: ListBuffer[Int] = ListBuffer.empty
    preordertraversal(tree, l1)
    println(l1)
    var l2: ListBuffer[Int] = ListBuffer.empty
    midordertraversal(tree, l2)
    println(l2)
    var l3: ListBuffer[Int] = ListBuffer.empty
    backordertraversal(tree, l3)
    println(l3)
  }

}
