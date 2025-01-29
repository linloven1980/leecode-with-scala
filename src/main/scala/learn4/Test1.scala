package learn4
import scala.util.control.Breaks._
object Test1 {
  def reverse(s: String, k: Int): Unit = {
    var a = s.toCharArray
    var len = a.length
    var l = 0
    var r = k - 1
    breakable{
      while (true) {
        if (r > len - 1) r = len - 1
        subreverse(a, l, r)
        l += k
        r += k
        if (r >= len - 1) break
        l += k
        r += k

      }
    }
    println(a.mkString(""))

  }
  def subreverse(a: Array[Char], i: Int, j: Int): Unit = {
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
  def main(args: Array[String]): Unit = {
    reverse("abcdefgh", 3)
  }
}
