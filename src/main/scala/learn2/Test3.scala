package learn2

object Test3 {
  case class ListNode(value: Int, var next: ListNode)
  def switch(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head
    var h = head
    var t = head.next
    h.next = switch(t.next)
    t.next = h
    t
  }

  def switch1(head: ListNode): ListNode = {
    var heading = ListNode(0, head)
    var h = heading
    var t = h.next
    while (t != null && t.next != null) {
      var tmp = t.next.next
      h.next = t.next
      t.next = tmp
      h.next.next = t
      h = t
      t = tmp
    }
    heading.next
  }

  def main(args: Array[String]): Unit = {
    println(switch1(ListNode(1, ListNode(2, ListNode(3, null)))))
  }

}
