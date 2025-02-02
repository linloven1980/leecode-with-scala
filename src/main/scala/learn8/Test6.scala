package learn8
import scala.collection.mutable.ListBuffer
object Test6 {
  def recover_ip(s: String): List[String] = {
    var a: Array[Char] = s.toCharArray
    var result: ListBuffer[String] = ListBuffer.empty
    var results: ListBuffer[String] = ListBuffer.empty
    def backtracking(index: Int): Unit = {
      if (index > a.length - 1) {
        if (result.length == 4) {
          results.append(result.mkString("."))
        }
        return
      } else {
        if (result.length == 4) return
      }
      for (i <- index to math.min(index + 2, a.length - 1)) {
        if (i == index || i > index && a(index) != '0' && a.slice(index, i + 1).mkString("").toInt <= 255) {
          result.append(a.slice(index, i + 1).mkString(""))
          backtracking(i + 1)
          result.remove(result.length - 1)
        }
      }
    }
    backtracking(0)
    results.toList
  }
  def main(args: Array[String]): Unit = {
    println(recover_ip("25525511135"))
    println(recover_ip("0000"))
    println(recover_ip("1111"))
    println(recover_ip("010010"))
    println(recover_ip("101023"))
  }
}
