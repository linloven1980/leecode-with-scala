package learn4

import scala.io.StdIn

object Test4 {
  def reversesub(a: Array[Char], i: Int, j: Int): Unit = {
    var l = i
    var r = j
    while (l <= r) {
      var tmp = a(l)
      a(l) = a(r)
      a(r) = tmp
      l += 1
      r -= 1
    }
  }

  def rightrun(s: String, k: Int): Unit = {
    var a = s.toCharArray
    reversesub(a, 0, a.length - 1)
    reversesub(a, 0, k - 1)
    reversesub(a, k, a.length - 1)
    println(a.mkString(""))
  }
  def main(args: Array[String]): Unit = {
    var k = StdIn.readInt()
    var s = StdIn.readLine()
    rightrun(s, k)
  }

}
