package learn3

import java.util
import scala.collection.mutable


object Test2 {
  def happynum(num: Int): Unit = {
    var s = mutable.HashSet[Int]()
    var sum = 0
    var n = num
    var findcircle = false
    while (sum !=1 && !findcircle) {
      sum = 0
      while (n != 0) {
        sum += (n%10) * (n%10)
        n /= 10
      }
      if (s.contains(sum)) findcircle = true
      else s += sum
      n = sum
    }
    println(s)
    if (sum == 1) println("True")
    else println("False")
  }
  def main(args: Array[String]): Unit = {
    happynum(99)
  }

}
