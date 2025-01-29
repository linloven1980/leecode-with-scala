package learn7

import scala.collection.mutable.HashMap
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Stack
import scala.util.control.Breaks._
object Test20 {
  case class TreeNode(value: Int, var left: TreeNode, var right: TreeNode)
  def traversal(top: TreeNode, map:HashMap[Int, Int] ): Unit = {
    if (top == null) return
    if (map.contains(top.value)) map(top.value) = map(top.value) + 1
    else map(top.value) = 1
    traversal(top.left, map)
    traversal(top.right, map)
  }
  def find_mode(top: TreeNode): ListBuffer[Int] = {
    val map: HashMap[Int, Int] = HashMap.empty
    traversal(top, map)
    val result: ListBuffer[Int] = ListBuffer.empty
    val l = map.toList.sortBy(_._2).reverse
    result.append(l(0)._1)
    breakable{
      for (i <- 1 to l.length - 1) {
        if (l(i)._2 == l(0)._2) result.append(l(i)._1)
        else break
      }
    }
    result
  }

  var cur: TreeNode = null
  var pre: TreeNode = null
  var cur_count: Int = 0
  var pre_count: Int = 0
  def find_mode1(top: TreeNode, result: ListBuffer[Int]): Unit = {
    if (top == null) return
    find_mode1(top.left, result)
    cur = top
    if (pre == null) {
      cur_count = 1
    } else {
      if (cur.value == pre.value) {
        cur_count += 1
      } else {
        if (pre_count == 0) {
          result.append(pre.value)
          pre_count = cur_count
        } else {
          if (cur_count == pre_count) {
            result.append(pre.value)
          }
          if (cur_count > pre_count) {
            result.clear()
            result.append(pre.value)
            pre_count = cur_count
          }
        }
        cur_count = 1
      }

    }
    pre = cur
    find_mode1(top.right, result)
  }



  def main(args: Array[String]): Unit = {
    val tree = TreeNode(10, TreeNode(6, TreeNode(4, null, null), TreeNode(7, null, TreeNode(7, null, null))), TreeNode(15, TreeNode(11, TreeNode(11, null, null), null), TreeNode(17, null, null)))
    println(find_mode(tree))
    val l: ListBuffer[Int] = ListBuffer.empty
    find_mode1(tree, l)
    println(l)
  }

}
