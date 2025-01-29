package learn5

object Test6 {
  case class Node(value: Int, var next: Node)
  def removebackwards(head: Node, i: Int): Node = {
    var h = Node(0, head)
    var l = h
    var r = h
    for (i <- 1 to i) {
      r = r.next
    }
    while (r.next != null) {
      r = r.next
      l = l.next
    }
    l.next = l.next.next
    h.next
  }
  def main(args: Array[String]): Unit = {
    println(removebackwards(Node(1, Node(2, Node(3, null))), 3))
  }

}
