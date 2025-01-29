package learn2

object Test4 {
  case class ListNode(value: Int, var next: ListNode)
  def backwards(head: ListNode, backstep: Int): ListNode = {
    var h = ListNode(0, head)
    var heading = h
    var i = 0
    var fast: ListNode = h
    var slow: ListNode = null
    while (fast != null) {
      fast = fast.next
      i += 1
      if (i == backstep + 1) slow = h
      if (i > backstep + 1) slow = slow.next
    }
    if (slow != null) slow.next = slow.next.next
    heading.next
  }

  def main(args: Array[String]): Unit = {
    println(backwards(ListNode(1, ListNode(2, ListNode(3, null))), 4))
    println(backwards(null, 1))
  }

}
