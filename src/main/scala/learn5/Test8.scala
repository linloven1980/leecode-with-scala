package learn5

object Test8 {
  case class Node(value: Int, var next: Node)
  def looplink(head: Node): Int = {
    var f = head
    var s = head
    var pos = 0
    f = f.next.next
    s = s.next
    while (f != null && f != s) {
      f = f.next
      if (f != null) f = f.next
      s = s.next
    }
    if (f == null) return -1
    else {
      s = head
      while (s != f) {
        s = s.next
        f = f.next
        pos += 1
      }
    }
    return pos
  }
  def main(args: Array[String]): Unit = {
    var n1 = Node(1, null)
    var n2 = Node(2, null)
    var n3 = Node(3, null)
    var n4 = Node(4, null)
    var n5 = Node(5, null)
    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5
    n5.next = n3
    println(looplink(n1))
  }

}
