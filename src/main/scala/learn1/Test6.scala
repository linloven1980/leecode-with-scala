package learn1

import scala.io
import scala.io.StdIn

object Test6 {
  def search(): Unit = {
    val len = StdIn.readInt()
    val a = new Array[Int](len)
    for (i <- 0 to len - 1) {
      a(i) = StdIn.readInt()
    }
    a.foreach(x => {
      print(x)
      print(",")
    })
    println
    val a1 = new Array[Int](len)
    var sum = 0
    for (i <- 0 to len - 1) {
      sum += a(i)
      a1(i) = sum
    }
    a1.foreach(x => {
      print(x)
      print(",")
    })
    println
    var window = StdIn.readLine()
    while (window != "end") {
      val w = window.split(" ")
      val begin = w(0).toInt
      val end = w(1).toInt
      val sum_w = a1(end) - a1(begin) + a(begin)
      println(sum_w)
      window = StdIn.readLine()
    }

  }

  def main(args: Array[String]): Unit = {
    search()
  }
}
