package learn10

object Test24 {
  case class TreeNode(value: Int, left: TreeNode, right: TreeNode)
  def steal(top: TreeNode): Int = {

    def iter_tree(top: TreeNode): (Int, Int) = {
      if (top.left == null && top.right == null) {
        return (top.value, 0)
      }
      var left_value: (Int, Int) = (0, 0)
      var right_value: (Int, Int) = (0, 0)
      if (top.left != null) left_value = iter_tree(top.left)
      if (top.right != null) right_value = iter_tree(top.right)
      (top.value + left_value._2 + right_value._2, math.max(left_value._1, left_value._2) + math.max(right_value._1, right_value._2))
    }
    val result: (Int, Int) = iter_tree(top)
    math.max(result._1, result._2)
  }

  def main(args: Array[String]): Unit = {
    val tree1: TreeNode = TreeNode(3, TreeNode(2, null, TreeNode(3, null, null)), TreeNode(3, null, TreeNode(1, null, null)))
    val tree2: TreeNode = TreeNode(3, TreeNode(4, TreeNode(1, null, null), TreeNode(3, null, null)), TreeNode(5, null, TreeNode(1, null, null)))
    println(steal(tree1))
    println(steal(tree2))
  }

}
