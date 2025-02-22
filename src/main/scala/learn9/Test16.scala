package learn9

object Test16 {
  case class TreeNode(value: Int, left: TreeNode, right: TreeNode)

  def monitor_binary_tree(tree: TreeNode): Int = {
    var camera_cnt = 0
    def iterate_tree(root: TreeNode): (Boolean, Boolean) = {
      if (root.left == null && root.right == null) return (true, false)
      var left_return: (Boolean, Boolean) = (false, false)
      var right_return: (Boolean, Boolean) = (false, false)
      if (root.left != null) left_return = iterate_tree(root.left)
      if (root.right != null) right_return = iterate_tree(root.right)
      if (left_return._1 == true || right_return._1 == true) {
        camera_cnt += 1
        return (false, true)
      }
      if (left_return._2 == true || right_return._2 == true) {
        return (false, false)
      }
      (true, false)
    }
    iterate_tree(TreeNode(0, tree, null))
    camera_cnt
  }

  def main(args: Array[String]): Unit = {
    println(monitor_binary_tree(TreeNode(0, TreeNode(0, TreeNode(0, null, null), TreeNode(0, null, null)), null)))
    println(monitor_binary_tree(TreeNode(0, TreeNode(0, TreeNode(0, TreeNode(0, null, TreeNode(0, null, null)), null), null), null)))
  }

}
