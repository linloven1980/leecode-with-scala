package learn7

object Test15 {
  case class TreeNode(value: Int, var left: TreeNode, var right: TreeNode)
  def create_max_tree(nodes: Array[Int]): TreeNode = {
    if (nodes.length == 0) return null
    var max = 0
    var index = 0
    var top: TreeNode = null
    for (i <- 0 to nodes.length - 1) {
      if (nodes(i) > max) {
        max = nodes(i)
        index = i
      }
    }
    var left: TreeNode = null
    var right: TreeNode = null
    if (index > 0) {
      left = create_max_tree(nodes.slice(0, index))
    }
    if (index < nodes.length - 1) {
      right = create_max_tree(nodes.slice(index + 1, nodes.length))
    }
    top = TreeNode(max, left, right)

    top
  }

  def main(args: Array[String]): Unit = {
    val nodes = Array[Int](3, 2, 1, 6, 0, 5)
    println(create_max_tree(nodes))
  }

}
