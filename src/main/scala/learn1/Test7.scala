package learn1

import scala.io.StdIn

object Test7 {
  def search(m: Int, n: Int): Unit = {
    val m = StdIn.readInt()
    val n = StdIn.readInt()
    val a = Array.ofDim[Int](m, n)
    for (i <- 0 to m-1) {
      for (j <- 0 to n-1) {
        a(i)(j) = StdIn.readInt()
      }
    }
    a.foreach(x => {
      x.foreach(y => {
        print(y)
        print(",")
      })
      println
    })
    val row = new Array[Int](m)
    val row_sum = new Array[Int](m)
    var sum1 = 0
    for (i <- 0 to m-1) {
      var sum = 0

      for (j <- 0 to n-1) {
        sum += a(i)(j)
      }
      row(i) = sum
      sum1 += sum
      row_sum(i) = sum1
    }
    row.foreach(x => {
      print(x)
      print(",")
    })
    println
    row_sum.foreach(x => {
      print(x)
      print(",")
    })
    println
    var diff = 9999
    for (i <- 0 to m-2) {
      val dif = Math.abs(sum1 - row_sum(i) - row_sum(i))
      println(dif)
      if (dif < diff) diff = dif
    }
    println(diff)

  }

  def main(args: Array[String]): Unit = {
    search(3, 3)
  }
}
