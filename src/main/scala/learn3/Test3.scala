package learn3

import scala.collection.mutable

object Test3 {
  def findtwonums(a: Array[Int], sum: Int): Unit = {
    var m = mutable.HashMap[Int, Int]()
    var index1 = -1
    var index2 = -1
    for (i <- 0 to a.length - 1) {
      if (m.contains(sum - a(i))) {
        index1 = m(sum - a(i))
        index2 = i
      } else m(a(i)) = i

    }
    println(index1)
    println(index2)
  }
  def main(args: Array[String]): Unit = {
    findtwonums(Array[Int](2, 7, 11, 15), 23)
  }

}
