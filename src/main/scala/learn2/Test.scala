package learn2

object Test {
  case class ListNode(var value: Int, var next: ListNode)
  def rm_ele(head: ListNode, value: Int): ListNode = {
    var dummy = ListNode(0, head)
    var head1 = dummy
    while(head1.next != null){
      if (head1.next.value == value) {
        head1.next = head1.next.next
      }else {
        head1 = head1.next
      }
    }
    dummy.next

  }
  def main(args: Array[String]): Unit = {
    var head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, null))))
    print(rm_ele(head, 4))
  }
}
