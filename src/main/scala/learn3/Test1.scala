package learn3

import java.util
import scala.collection.mutable

object Test1 {
  def interset(a: Array[Int], b: Array[Int]): Unit = {
    var s = mutable.HashSet[Int]()
    var r = mutable.HashSet[Int]()
    for (i <- a) {
      s += i
    }
    for (i <- b) {
      if (s.contains(i)) r += i
    }
    println(r)
  }
  def main(args: Array[String]): Unit = {
    interset(Array[Int](1,2,3,4,5,6, 3,3,6,6), Array[Int](3, 6, 7,8,9, 3,3,6,6,6))
  }

}
