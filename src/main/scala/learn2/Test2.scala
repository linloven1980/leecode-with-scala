package learn2

object Test2 {
  case class ListNode(value: Int, var next: ListNode)
  def reverse(head: ListNode): ListNode = {

    if (head == null) return null

    var heading = head
    var h = heading
    var t = heading.next
    h.next = null
    while (t != null) {
      h = heading
      heading = t
      t = t.next
      heading.next = h


    }
    heading
  }

  def main(args: Array[String]): Unit = {
    println(reverse(ListNode(1, ListNode(2, ListNode(3, null)))))
  }
}
