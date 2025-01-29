package learn5

object Test7 {
  case class Node(value: Int, next: Node)
  def intersect(head1: Node, head2: Node): Node = {
    var len1 = 1
    var len2 = 1
    var h1 = head1
    var h2 = head2
    while (h1.next != null){
      len1 += 1
      h1 = h1.next
    }
    while (h2.next != null){
      len2 += 1
      h2 = h2.next
    }
    h1 = head1
    h2 = head2
    println(len1)
    println(len2)
    if (len1 > len2) {
      for (i <- 1 to len1 - len2){
        h1 = h1.next
      }
    }else {
      for (i <- 1 to len2 -len1){
        h2 = h2.next
      }
    }
    println(h1)
    println(h2)
    while (h1 != null && h1.value != h2.value) {
      h1 = h1.next
      h2 = h2.next
    }
    if (h1 == null) return null
    else h1
  }
  def main(args: Array[String]): Unit = {
    println(intersect(Node(1, Node(2, Node(8, Node(9, null)))), Node(4, Node(5, Node(6, Node(7, Node(8, Node(9, null))))))))
  }

}
