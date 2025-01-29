package learn3

import scala.collection.mutable

object Test4 {
  def foursum(a: Array[Int], b: Array[Int], c: Array[Int], d: Array[Int]): Unit = {
    var m = mutable.HashMap[Int, Int]()
    for (i <- a) {
      for (j <- b) {
        if (m.contains(i + j)) {
          m(i + j) += 1
        } else {
          m(i + j) = 1
        }
      }
    }
    var count = 0
    for (i <- c) {
      for (j <- d) {
        if (m.contains(0 - i - j)) count += m(0 - i - j)
      }
    }
    println(count)
  }
  def main(args: Array[String]): Unit = {
    foursum(Array[Int](1, 2), Array[Int](-2, -1), Array[Int](-1, 2), Array[Int](0, 2))
  }

}
