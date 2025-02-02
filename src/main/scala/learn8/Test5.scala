package learn8
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._
object Test5 {
  def is_parlindromic_string(a: Array[Char]): Boolean = {
    var l: Int = 0
    var r: Int = a.length - 1
    while (l < r) {
      if (a(l) != a(r)) return false
      l += 1
      r -= 1
    }
    true
  }

  def find_parlindromic_string(s: String): List[List[String]] = {
    var result: ListBuffer[Array[Char]] = ListBuffer.empty
    var results: ListBuffer[List[String]] = ListBuffer.empty
    var a: Array[Char] = s.toCharArray
    def backtracking(index: Int): Unit = {
      if (index > a.length - 1) {
        results.append(result.map(_.mkString("")).toList)
        return
      }

      for (i <- index to a.length - 1) {
        if (is_parlindromic_string(a.slice(index, i + 1)) == true) {
          result.append(a.slice(index, i + 1))
          backtracking(i + 1)
          result.remove(result.length - 1)
        }
      }

    }
    backtracking(0)
    results.toList
  }

  def main(args: Array[String]): Unit = {
    println(find_parlindromic_string("aabaa"))
  }

}
