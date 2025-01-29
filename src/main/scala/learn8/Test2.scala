package learn8
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.HashMap
object Test2 {
  def phone_number_combination(s: String): List[String] = {
    var result: ListBuffer[Char] = ListBuffer.empty
    var results: ListBuffer[String] = ListBuffer.empty
    var number_map: HashMap[Char, Array[Char]] = HashMap.empty
    number_map('2') = Array[Char]('a', 'b', 'c')
    number_map('3') = Array[Char]('d', 'e', 'f')
    number_map('4') = Array[Char]('g', 'h', 'i')
    number_map('5') = Array[Char]('j', 'k', 'l')
    number_map('6') = Array[Char]('m', 'n', 'o')
    number_map('7') = Array[Char]('p', 'q', 'r', 's')
    number_map('8') = Array[Char]('t', 'u', 'v')
    number_map('9') = Array[Char]('w', 'x', 'y', 'z')
    var l: ListBuffer[Array[Char]] = ListBuffer.empty
    var a = s.toCharArray
    for (i <- a) {
      l.append(number_map(i))
    }

    def backtracking(i: Int): Unit = {
      if (i == l.length) {
        results.append(result.mkString(""))
        return
      }
      for (item <- l(i)) {
        result.append(item)
        backtracking(i + 1)
        result.remove(result.length - 1)
      }
    }
    backtracking(0)
    results.toList
  }

  def main(args: Array[String]): Unit = {
    println(phone_number_combination("23"))
    println(phone_number_combination("2479"))
  }
}
