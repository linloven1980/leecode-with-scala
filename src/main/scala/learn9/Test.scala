package learn9
import scala.util.control.Breaks._
object Test {
  def distribute_cookie(g: Array[Int], s: Array[Int]): Int = {
    var g1 = g.sorted.reverse
    var s1 = s.sorted.reverse

    var sum: Int = 0
    var index: Int = 0
    breakable {
      for (i <- s1) {
        if (index > g1.length - 1) break
        breakable{
          for (j <- index to g1.length - 1) {
            if (i >= g1(j)) {

              sum += 1
              index = j + 1
              break
            }
          }
        }


      }
    }

    sum
  }

  def main(args: Array[String]): Unit = {
    println(distribute_cookie(Array[Int](1,2,3), Array[Int](1,1)))
    println(distribute_cookie(Array[Int](1,2), Array[Int](1,2,3)))
    println(distribute_cookie(Array[Int](1,2,7,10), Array[Int](1,3,5,9)))

  }

}
