package learn5

object Test5 {
  case class Node(value: Int, var next: Node)
  def reverselink(head: Node): Node = {
    if (head.next == null) {
      return head
    }
    var n = head.next
    var c = head
    c.next = null
    while (n != null) {
      var temp = n
      n = n.next
      temp.next = c
      c = temp
    }
    c
  }

  def main(args: Array[String]): Unit = {
    println(reverselink(Node(1, Node(2, Node(3, Node(4, null))))))
  }

}
