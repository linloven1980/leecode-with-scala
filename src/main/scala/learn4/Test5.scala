package learn4

import scala.util.control.Breaks._
object Test5 {
  def mkprefixtable(s: String): Array[Int] = {
    var a = s.toCharArray
    var prefixtable = new Array[Int](a.length)
    prefixtable(0) = 0
    if (a.length > 1) {
      var j = 0
      for (i <- 1 to a.length - 1) {
        if (a(i) == a(j)) {
          prefixtable(i) = prefixtable(i - 1) + 1
          j += 1
        } else {
          if (j == 0) {
            if (a(j) == a(i)) {
              prefixtable(i) = 1
              j += 1
            }
            else prefixtable(i) = 0
          } else {
            while (j > 0 && a(j) != a(i)) {
              j = prefixtable(j - 1)
            }
            if (j == 0) {
              if (a(j) == a(i)) {
                prefixtable(i) = 1
                j += 1
              }
              else prefixtable(i) = 0
            } else {
              prefixtable(i) = j + 1
              j += 1
            }
          }
        }
      }
    }
    println(prefixtable.mkString(","))
    prefixtable
  }

  def index(s: String, p: String): Int = {
    var sa = s.toCharArray
    var pa = p.toCharArray
    var ptable = mkprefixtable(p)
    var j = 0
    var result = -1
    if (pa.length == 0) result = 0
    breakable{
      for (i <- 0 to sa.length - 1) {
        if (sa(i) == pa(j)) {
          if (j == pa.length - 1) {
            result = i - pa.length + 1
            break
          } else {
            j += 1
          }
        } else {
          while (j > 0 && sa(i) != pa(j)) {
            j = ptable(j - 1)
          }
          if (j > 0) j += 1
        }
      }
    }


    result

  }

  def main(args: Array[String]): Unit = {
    println(index("abcabdabcd", "c" +
      ""))
  }

}
