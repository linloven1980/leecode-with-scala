package learn2

object Test1 {
  case class ListNode(var value: Int, var next: ListNode=null)
  class LinkedList(var head: ListNode) {
    def get(index: Int): Int = {
      var h = ListNode(0, head)
      var i = 0
      var result = -1
      while (h.next != null && i <= index) {
        if (i == index) result = h.next.value
        h = h.next
        i += 1
      }
      result
    }

    def addAtHead(value: Int): Unit = {
      head = ListNode(value, head)
    }

    def addAtTail(value: Int): Unit = {
      var h = ListNode(0, head)
      head = h
      while (h.next != null) {
        h = h.next
      }
      h.next = ListNode(value, null)
      head = head.next
    }

    def addAtIndex(index: Int, value: Int): Unit = {
      if (index < 0) addAtHead(value)
      else {
        var h = ListNode(0, head)
        head = h
        var i = 0
        while (h != null && i <= index) {
          if (i == index) {
            h.next = ListNode(value, h.next)
          }
          h = h.next
          i += 1
        }
        head = head.next
      }
    }

    def deleteAtIndex(index: Int): Unit = {
      var h = ListNode(0, head)
      head = h
      var i = 0
      while (i <= index && h.next != null) {
        if (i == index) {
          h.next = h.next.next
        }
        h = h.next
        i += 1
      }
      head = head.next
    }

    override def toString: String = {
      super.toString
      if (head == null) "null"
      else head.toString
    }
  }

  def main(args: Array[String]): Unit = {
    var l = new LinkedList(null)
    println(l)
    l.addAtHead(1)
    println(l)
    l.addAtTail(3)
    println(l)
    l.addAtIndex(1, 2)
    println(l)
    println(l.get(2))
    l.deleteAtIndex(0)
    println(l)
  }

}
