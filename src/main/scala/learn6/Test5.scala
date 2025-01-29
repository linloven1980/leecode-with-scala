package learn6

import scala.collection.mutable

object Test5 {
  def slidemax(a: Array[Int], k: Int): List[Int] = {
    var max: Int = 0
    var result: List[Int] = List.empty
    val q: mutable.ArrayDeque[Int] = mutable.ArrayDeque.empty

    for (i <- 0 to k - 1) {
      while (!q.isEmpty && q.last < a(i)) {
        q.removeLast()
      }
      q.append(a(i))

    }
    result = result :+ q.head

    for (i <- 1 to a.length - k) {
      if (a(i - 1) == q.head) q.removeHead()
      while (!q.isEmpty && q.last < a(i + k - 1)) q.removeLast()
      q.append(a(i + k - 1))
      result = result :+ q.head
    }
    result
  }

  def main(args: Array[String]): Unit = {
    println(slidemax(Array[Int](3, 3, -1, -3, 5, 3, 6, 7), 3))
  }

}
