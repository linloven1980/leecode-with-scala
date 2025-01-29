package learn7

import scala.collection.mutable.Stack
import scala.collection.mutable.ListBuffer

object Test2 {
  case class TreeNode(value: Int, left: TreeNode, right: TreeNode)
  def preordertraversal(top: TreeNode, l: ListBuffer[Int]): Unit = {
    val s: Stack[TreeNode] = Stack.empty
    s.push(top)
    while (!s.isEmpty) {
      var cur = s.pop()
      if (cur != null) {
        if (cur.right != null) s.push(cur.right)
        if (cur.left != null) s.push(cur.left)
        s.push(cur)
        s.push(null)
      } else {
        cur = s.pop()
        l.append(cur.value)
      }
    }
  }

  def midordertraversal(top: TreeNode, l: ListBuffer[Int]): Unit = {
    val s: Stack[TreeNode] = Stack.empty
    s.push(top)
    while (!s.isEmpty) {
      var cur = s.pop()
      if (cur != null) {
        if (cur.right != null) s.push(cur.right)
        s.push(cur)
        s.push(null)
        if (cur.left != null) s.push(cur.left)
      } else {
        cur = s.pop()
        l.append(cur.value)

      }
    }
  }

  def backordertraversal(top: TreeNode, l: ListBuffer[Int]): Unit = {
    val s: Stack[TreeNode] = Stack.empty
    s.push(top)
    while (!s.isEmpty) {
      var cur = s.pop()
      if (cur != null) {
        s.push(cur)
        s.push(null)
        if (cur.right != null) s.push(cur.right)
        if (cur.left != null) s.push(cur.left)
      } else {
        cur = s.pop()
        l.append(cur.value)
      }
    }

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
