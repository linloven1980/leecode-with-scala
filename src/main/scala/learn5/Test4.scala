package learn5
import scala.util.control.Breaks._
object Test4 {
  def reverseword(s: String): Unit = {
    var a = s.toCharArray
    var j = 0
    for (i <- 0 to a.length - 1) {
      if (a(i) != ' ') {
        a(j) = a(i)
        j += 1
      }else {
        if (j > 0) {
          if (a(i - 1) != ' ') {
            a(j) = ' '
            j += 1
          }
        }
      }
    }
    var len = j
    reverse(a, 0, len - 1)
    var i = 0
    j = 0
    breakable{
      while (true) {
        if (j == len -1 || a(j + 1) == ' ') {
          reverse(a, i, j)
          if (j == len - 1) break
          j += 2
          i = j

        }else {
          j += 1
        }
      }
    }
    println(a.mkString(""))

  }
  def reverse(a: Array[Char], i: Int, j: Int): Unit = {
    var left = i
    var right = j
    while (left <= right) {
      var temp = a(left)
      a(left) = a(right)
      a(right) = temp
      left += 1
      right -= 1
    }
  }

  def main(args: Array[String]): Unit = {
    reverseword("the sky is blue")
    reverseword("  hello world!  ")
    reverseword("a good   example")
  }

}
