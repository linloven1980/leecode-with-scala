package learn7

object Test22 {
  case class TreeNode(value: Int, var left: TreeNode, var right: TreeNode)
  def find_common_ancestor(top: TreeNode, a: Int, b: Int): TreeNode = {
    if (top.value < math.min(a, b)) return find_common_ancestor(top.right, a, b)
    if (top.value > math.max(a, b)) return find_common_ancestor(top.left, a, b)
    return top
  }
  def find_common_ancestor1(top: TreeNode, a: Int, b: Int): TreeNode = {
    var cur = top
    while (cur != null) {
      if (cur.value > math.max(a, b)) cur = cur.left
      else if (cur.value < math.min(a, b)) cur = cur.right
      else return cur
    }
    cur
  }

  def main(args: Array[String]): Unit = {
    val tree = TreeNode(10, TreeNode(6, TreeNode(4, null, null), TreeNode(7, null, TreeNode(8, null, null))), TreeNode(15, TreeNode(13, TreeNode(11, null, null), null), TreeNode(17, null, null)))
    println(find_common_ancestor(tree, 4, 8))
    println(find_common_ancestor(tree, 15, 17))
    println(find_common_ancestor1(tree, 4, 8))
    println(find_common_ancestor1(tree, 15, 17))
  }

}
