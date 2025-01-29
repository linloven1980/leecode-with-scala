package learn7
import scala.collection.mutable.Queue
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._
object Test3 {
  case class TreeNode(value: Int, left: TreeNode, right: TreeNode)
  case class MCTreeNode(value: Int, children: Array[MCTreeNode])
  case class NextTreeNode(value: Int, left: NextTreeNode, right: NextTreeNode, var next: NextTreeNode = null)
  def levelorder(top: TreeNode): ListBuffer[Array[Int]] = {
    val l: ListBuffer[Array[Int]] = ListBuffer.empty
    val q: Queue[TreeNode] = Queue.empty
    q.enqueue(top)
    while (!q.isEmpty) {
      val a: Array[Int] = new Array[Int](q.size)
      for (i <- 1 to q.size) {
        val n = q.dequeue()
        a(i - 1) = n.value
        if (n.left != null) q.enqueue(n.left)
        if (n.right != null) q.enqueue(n.right)

      }
      l.append(a)
    }
    l
  }

  def levelorderbottom(top: TreeNode): ListBuffer[Array[Int]] = {
    val q: Queue[TreeNode] = Queue.empty
    var l: ListBuffer[Array[Int]] = ListBuffer.empty
    q.enqueue(top)
    while (!q.isEmpty) {
      val a: Array[Int] = new Array[Int](q.size)
      for (i <- 1 to q.size) {
        val n = q.dequeue()
        a(i - 1) = n.value
        if (n.left != null) q.enqueue(n.left)
        if (n.right != null) q.enqueue(n.right)
      }
      l.prepend(a)
    }
    l
  }

  def rightsideview(top: TreeNode): ListBuffer[Int] = {
    val q: Queue[TreeNode] = Queue.empty
    var l: ListBuffer[Int] = ListBuffer.empty
    q.enqueue(top)
    while (!q.isEmpty) {
      var size = q.size
      for (i <- 1 to size) {
        val n = q.dequeue()
        if (n.left != null) q.enqueue(n.left)
        if (n.right != null) q.enqueue(n.right)
        if (i == size) l.append(n.value)
      }
    }
    l
  }

  def averageoflevels(top: TreeNode): ListBuffer[Int] = {
    val q: Queue[TreeNode] = Queue.empty
    var l: ListBuffer[Int] = ListBuffer.empty
    q.enqueue(top)
    while (!q.isEmpty) {
      var size = q.size
      var sum = 0
      for (i <- 1 to size) {
        val n = q.dequeue()
        sum += n.value
        if (n.left != null) q.enqueue(n.left)
        if (n.right != null) q.enqueue(n.right)

      }
      l.append(sum/size)
    }
    l
  }

  def levelordermctree(top: MCTreeNode): ListBuffer[Array[Int]] = {
    val q: Queue[MCTreeNode] = Queue.empty
    val l: ListBuffer[Array[Int]] = ListBuffer.empty
    q.enqueue(top)
    while (!q.isEmpty) {
      val a: Array[Int] = new Array[Int](q.size)
      for (i <- 1 to q.size) {
        val n = q.dequeue()
        a(i - 1) = n.value
        for (j <- 0 to n.children.length - 1) {
          q.enqueue(n.children(j))
        }
      }
      l.append(a)
    }
    l
  }

  def maxoflevel(top: TreeNode): ListBuffer[Int] = {
    val q: Queue[TreeNode] = Queue.empty
    val l: ListBuffer[Int] = ListBuffer.empty
    q.enqueue(top)

    while (!q.isEmpty) {
      var max = -9999
      for (i <- 1 to q.size) {
        val n = q.dequeue()
        if (max < n.value) max = n.value
        if (n.left != null) q.enqueue(n.left)
        if (n.right != null) q.enqueue(n.right)
      }
      l.append(max)
    }
    l
  }

  def setnext(top: NextTreeNode): Unit = {
    val q: Queue[NextTreeNode] = Queue.empty
    q.enqueue(top)
    while (!q.isEmpty) {
      for (i <- 1 to q.size - 1) {
        val n = q.dequeue()
        n.next = q.head
        if (n.left != null) q.enqueue(n.left)
        if (n.right != null) q.enqueue(n.right)
      }
      val n = q.dequeue()
      if (n.left != null) q.enqueue(n.left)
      if (n.right != null) q.enqueue(n.right)
    }
  }

  def maxdepth(top: TreeNode): Int = {
    val q: Queue[TreeNode] = Queue.empty
    val l: ListBuffer[Array[Int]] = ListBuffer.empty
    q.enqueue(top)
    while (!q.isEmpty) {
      val a: Array[Int] = new Array[Int](q.size)
      for (i <- 1 to q.size) {
        val n = q.dequeue()
        a(i - 1) = n.value
        if (n.left != null) q.enqueue(n.left)
        if (n.right != null) q.enqueue(n.right)
      }
      l.append(a)
    }
    l.length
  }

  def mindepth(top: TreeNode): Int = {
    val q: Queue[TreeNode] = Queue.empty
    val l: ListBuffer[Array[Int]] = ListBuffer.empty
    q.enqueue(top)
    breakable{
      while (!q.isEmpty) {
        val a: Array[Int] = new Array[Int](q.size)
        for (i <- 1 to q.size){
          val n = q.dequeue()
          a(i - 1) = n.value
          if (n.left == null && n.right == null) {
            l.append(a)
            break
          }
          if (n.left != null) q.enqueue(n.left)
          if (n.right != null) q.enqueue(n.right)
        }
        l.append(a)
      }
    }

    l.length
  }

  def main(args: Array[String]): Unit = {
    val tree = TreeNode(5, TreeNode(3, TreeNode(4, null, null), TreeNode(6, null, null)), TreeNode(2, TreeNode(8, null, null), TreeNode(7, null, null)))
    val l = levelorder(tree)
    for (a <- l) {
      println(a.mkString(","))
    }
    val l1 = levelorderbottom(tree)
    for (a <- l1) {
      println(a.mkString(","))
    }
    val l2 = rightsideview(tree)
    println(l2)
    val l3 = averageoflevels(tree)
    println(l3)

    val mctree = MCTreeNode(5, Array[MCTreeNode](MCTreeNode(3, Array[MCTreeNode](MCTreeNode(4, Array[MCTreeNode]()), MCTreeNode(6, Array[MCTreeNode]()))), MCTreeNode(2, Array[MCTreeNode](MCTreeNode(8, Array[MCTreeNode]()), MCTreeNode(7, Array[MCTreeNode]())))))
    val l4 = levelordermctree(mctree)
    for (a <- l) {
      println(a.mkString(","))
    }

    val l5 = maxoflevel(tree)
    println(l5)

    val nexttree = NextTreeNode(5, NextTreeNode(3, NextTreeNode(4, null, null), NextTreeNode(6, null, null)), NextTreeNode(2, NextTreeNode(8, null, null), NextTreeNode(7, null, null)))
    setnext(nexttree)
    println(nexttree)

    val maxdept = maxdepth(tree)
    println(maxdept)

    val tree1 = TreeNode(5, TreeNode(3, null, null), TreeNode(2, TreeNode(8, null, null), TreeNode(7, null, null)))
    val mindept = mindepth(tree1)
    println(mindept)
  }

}
