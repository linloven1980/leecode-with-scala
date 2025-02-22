package learn9

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Queue
import scala.collection.mutable.Stack

object Test15 {
  def increasing_number(target: Int): Int = {
    def is_increasing_number(n: Int): Boolean = {
      var tmp_n = n
      var tmp_l: ListBuffer[Int] = ListBuffer.empty
      while (tmp_n != 0) {
        tmp_l.append(tmp_n % 10)
        tmp_n = tmp_n / 10
      }
      for (i <- 0 to tmp_l.length - 2) {
        if (tmp_l(i) < tmp_l(i + 1)) return false
      }
      true
    }
    var n = target
    while (is_increasing_number(n) != true) {
      n -= 1
    }
    n
  }
  def increasing_number1(target: Int): Int = {
    var q: Queue[Int] = Queue.empty
    var s: Stack[Int] = Stack.empty
    var n = target
    while (n != 0) {
      q.enqueue(n % 10)
      n = n / 10
    }
    if (q.size == 1) return q.dequeue()
    var a = q.dequeue()
    var b = -1
    var pos = 0
    for (i <- 1 to q.size) {
      b = q.dequeue()
      if (a < b) {
        a = 9
        b -= 1
        pos = i
      }
      s.push(a)
      a = b
    }
    s.push(a)
    var result = 0
    for (i <- s.size to 1 by -1) {
      var tmp = s.pop()
      if (i <= pos) tmp = 9
      result = result * 10 + tmp
    }
    result
  }
  def increasing_number2(target: Int): Int = {
    if (target < 10) return target
    var s: String = target.toString
    var a = s.toCharArray
    var pos = -1
    for (i <- a.length - 1 to 1 by -1) {
      if (a(i) < a(i - 1)) {
        a(i) = '9'
        a(i - 1) = (a(i - 1).toInt - 1).toChar
        pos = i
      }
    }
    if (pos != -1) {
      for (i <- pos to a.length - 1) {
        a(i) = '9'
      }
    }
      

    a.mkString("").toInt
  }

  def main(args: Array[String]): Unit = {
    println(increasing_number(10))
    println(increasing_number(1234))
    println(increasing_number(332))
    println(increasing_number(1265565))
    println(increasing_number(1065565))
    println(increasing_number1(10))
    println(increasing_number1(1234))
    println(increasing_number1(332))
    println(increasing_number1(1265565))
    println(increasing_number1(1065565))
    println(increasing_number2(10))
    println(increasing_number2(1234))
    println(increasing_number2(332))
    println(increasing_number2(1265565))
    println(increasing_number2(1065565))
  }

}
