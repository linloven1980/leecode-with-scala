package learn7

object Test7 {
  case class TreeNode(value: Int, left: TreeNode, right: TreeNode)
  def getmindepth(top: TreeNode): Int = {
    if (top == null) return 0
    val leftdepth = getmindepth(top.left)
    val rightdepth = getmindepth(top.right)
    if (top.left == null) return rightdepth + 1
    if (top.right == null) return leftdepth + 1
    return math.min(leftdepth, rightdepth) + 1
  }
  def main(args: Array[String]): Unit = {
    val tree = TreeNode(5, TreeNode(3, null, null), TreeNode(2, TreeNode(8, null, null), TreeNode(7, null, null)))
    println(getmindepth(tree))
  }

}
