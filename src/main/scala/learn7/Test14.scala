package learn7

object Test14 {
  case class TreeNode(value: Int, var left: TreeNode, var right: TreeNode)
  def create_tree(mid_order: Array[Int], back_order: Array[Int]): TreeNode = {
    var top: TreeNode = null
    if (back_order.length > 0) {
      val top_value = back_order(back_order.length - 1)
      val index = mid_order.indexOf(top_value)
      var left: TreeNode = null
      var right: TreeNode = null
      if (index > 0) {
        left = create_tree(mid_order.slice(0, index), back_order.slice(0, index))
      }
      if (index < back_order.length - 1) {
        right = create_tree(mid_order.slice(index + 1, back_order.length), back_order.slice(index, back_order.length - 1))
      }
      top = TreeNode(top_value, left, right)
    }

    top
  }

  def create_tree1(pre_order: Array[Int], mid_order: Array[Int]): TreeNode = {

    var top: TreeNode = null
    if (pre_order.length > 0) {
      val top_value = pre_order(0)
      val index = mid_order.indexOf(top_value)
      var left: TreeNode = null
      var right: TreeNode = null
      if (index > 0) {
        left = create_tree1(pre_order.slice(1, index + 1), mid_order.slice(0, index))
      }
      if (index < mid_order.length - 1) {
        right = create_tree1(pre_order.slice(index + 1, mid_order.length), mid_order.slice(index + 1, mid_order.length))
      }
      top = TreeNode(top_value, left, right)
    }
    top
  }

  def main(args: Array[String]): Unit = {
    val mid_order = Array[Int](9, 3, 15, 20, 7)
    val back_order = Array[Int](9, 15, 7, 20, 3)
    val pre_order = Array[Int](3, 9, 20, 15, 7)

    println(create_tree(mid_order, back_order))
    println(create_tree1(pre_order, mid_order))
  }

}
