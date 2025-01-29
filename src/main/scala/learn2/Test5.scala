package learn2

object Test5 {
  case class ListNode(valule: Int, var next: ListNode)
  def intersect(a: ListNode, b: ListNode): Unit = {
    var la = a
    var lb = b
    var lenA: Int = 0
    var lenB: Int = 0
    while (la != null) {
      lenA += 1
      la = la.next
    }
    while (lb != null) {
      lenB += 1
      lb = lb.next
    }
    println(lenA)
    println(lenB)
    la = a
    lb = b
    if (lenA > lenB) {
      for (i <- 1 to lenA - lenB) {
        la = la.next
      }
    }else {
      for (i <- 1 to lenB - lenA) {
        lb = lb.next
      }
    }
    var ha = la
    var hb = lb
    var i = 0
    while (ha != hb && ha != null) {
      i += 1
      ha = ha.next
      hb = hb.next
    }
    if (ha != null) {
      println(ha.valule)
      if (lenA > lenB) {
        println(lenA - lenB + i)
        println(i)
      }
      else {
        println(i)
        println(lenB - lenA + i)
      }
    } else println("null")
  }
  def main(args: Array[String]): Unit = {
    intersect(ListNode(1, ListNode(2, ListNode(13, ListNode(14, null)))), ListNode(3, ListNode(4, ListNode(5, ListNode(11, ListNode(12, null))))))
  }

}
