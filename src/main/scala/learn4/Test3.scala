package learn4

import scala.util.control.Breaks._

object Test3 {
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
  def reverse(s: String): Unit = {
    var a = s.toCharArray
    var b1, b2, e = 0
    while(a(b2) == ' ') b2 += 1
    breakable{
      while (true) {
        a(b1) = a(b2)
        if (b2 == a.length - 1 || a(b2 + 1) == ' ' && a(b2 + 2) == ' ') break
        b1 += 1
        b2 += 1

      }
    }
    e = b1
    b1 = 0
    reversesub(a, b1, e)
    var i, j = 0
    while (j <= e) {
      while (j != e && a(j+1) != ' ') j += 1
      reversesub(a, i, j)
      j += 2
      i = j
    }
    println(a.mkString(""))
  }
  def main(args: Array[String]): Unit = {
    reverse( "  hello world!  ")
  }

}
