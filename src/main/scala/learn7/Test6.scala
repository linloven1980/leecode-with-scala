package learn7

object Test6 {
  case class TreeNode(value: Int, left: TreeNode, right: TreeNode)
  def getmaxdepth(top: TreeNode): Int = {
    if (top == null) return 0
    else {
      val leftdepth = getmaxdepth(top.left)
      val rightdepth = getmaxdepth(top.right)
      return math.max(leftdepth, rightdepth) + 1
    }
  }

  def main(args: Array[String]): Unit = {
    val tree = TreeNode(5, TreeNode(3, TreeNode(4, null, null), TreeNode(6, null, null)), TreeNode(2, TreeNode(8, null, null), TreeNode(7, null, null)))
    println(getmaxdepth(tree))
  }

}
