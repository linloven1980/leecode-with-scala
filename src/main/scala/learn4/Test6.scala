package learn4

import scala.util.control.Breaks._

object Test6 {
  def madeofsubstr(s: String): Boolean = {
    var a = s.toCharArray
    for (i <- 1 to a.length/2) {
      var found = true
      if(a.length % i == 0 && a(i) == a(0)) {
        breakable{
          for (j <- 0 to i - 1) {
            var k = j + i
            while (k < a.length) {
              if (a(k) != a(j)) {
                found = false
                break
              }else {
                k += i
              }
            }
          }
        }
        if (found == true) return true
      }
    }
    false
  }

  def madeofsubstr1(s: String): Boolean = {
    var ss = s + s
    if (ss.indexOf(s) != -1) return true
    else return false
  }

  def getnextarr(s: String): Array[Int] = {
    var a = s.toCharArray
    var nextarr = new Array[Int](a.length)
    nextarr(0) = 0
    var j = 0
    for (i <- 1 to a.length - 1) {
      if (a(i) == a(j)) {
        nextarr(i) = nextarr(i - 1) + 1
        j += 1
      } else {
        if (j == 0) {
          if (a(i) == a(j)) {
            nextarr(i) = 1
            j += 1
          }else {
            nextarr(i) = 0
          }
        } else {
          j = nextarr(j - 1)
          while (j != 0 && a(j) != a(i)) {
            j = nextarr(j)
          }
          if (j == 0) {
            if (a(i) == a(j)) {
              nextarr(i) = 1
              j += 1
            }else {
              nextarr(i) = 0
            }
          } else {
            nextarr(i) = j + 1
            j += 1
          }
        }
      }
    }
    println(nextarr.mkString(","))
    nextarr
  }

  def madeofsubstr2(s: String): Boolean = {
    var nextarr = getnextarr(s)
    if (s.length % (s.length - nextarr(s.length - 1)) == 0) return true
    else return false
  }

  def main(args: Array[String]): Unit = {
    println(madeofsubstr2("abcabcmabcabcabcmabc"))
  }

}
