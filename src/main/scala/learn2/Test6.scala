package learn2

object Test6 {
  case class ListNode(value: Int, var next: ListNode)
  def circle(head: ListNode): Unit = {
    var h = ListNode(0, head)
    var fast = h
    var slow = h
    var findcircle = false
    while (fast != null && findcircle == false) {
      fast = fast.next
      if (fast != null) fast = fast.next
      slow = slow.next
      if (fast == slow) findcircle = true
    }

    if (fast == null) println("no circle")
    else {
      println("find circle")
      var index1 = fast
      var index2 = h
      while (index1 != index2) {
        index1 = index1.next
        index2 = index2.next
      }
      print(index1.value)
    }

  }
  def main(args: Array[String]): Unit = {
    var n1 = ListNode(1, null)
    var n2 = ListNode(2, null)
    var n3 = ListNode(3, null)
    n1.next = n2
    n2.next = n3
    n3.next = n3
    circle(n1)
  }

}
