package learn6

import scala.collection.mutable
import scala.util.Try

object Test4 {
  def isnumeric(s: String): Boolean = {
    Try(s.toInt).isSuccess
  }
  def calrpn(l: List[String]): Int = {
    val s: mutable.Stack[Int] = mutable.Stack.empty
    for (str <- l) {
      if (isnumeric(str)) s.push(str.toInt)
      else {
        var b = s.pop()
        var a = s.pop()
        var c = 0
        if (str == "+") c = a + b
        else if (str == "-") c = a - b
        else if (str == "*") c = a * b
        else if (str == "/") c = a / b
        s.push(c)
      }
    }
    s.pop()

  }

  def main(args: Array[String]): Unit = {
    println(calrpn(List[String]("2", "1", "+", "3", "*")))
    println(calrpn(List[String]("4", "13", "5", "/", "+")))
    println(calrpn(List[String]("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))
  }

}
