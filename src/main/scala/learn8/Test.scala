package learn8
import scala.collection.mutable.ListBuffer
object Test {
  def backtracking(begin: Int, end: Int, k: Int): ListBuffer[List[Int]] = {
    if (k == 0 ) {
      val l = new ListBuffer[List[Int]]()
      l.append(List.empty)
      return l
    }
    val result: ListBuffer[List[Int]] = ListBuffer.empty
    for (i <- begin to end) {
      for(item <- backtracking(i + 1, end + 1, k - 1)) {
        result.append(i :: item)
      }
    }
    result
  }
  def get_combination(n: Int, k: Int): ListBuffer[List[Int]] = {
    return backtracking(1, n - k + 1, k)
  }
  def get_combination1(n: Int, k: Int): List[List[Int]] = {
    var results: ListBuffer[List[Int]] = ListBuffer.empty
    var result: ListBuffer[Int] = ListBuffer.empty
    def backtracking(n: Int, k: Int, index: Int): Unit = {
      if (result.length == k) {
        results.append(result.toList)
        return
      }
      for (i <- index to n - (k - result.length) + 1) {
        result.append(i)
        backtracking(n, k, i + 1)
        result.remove(result.length - 1)
      }
    }
    backtracking(4, 2, 1)
    results.toList
  }
  def main(args: Array[String]): Unit = {
    println(get_combination(4, 2))
    println(get_combination(10, 3))
    //println(get_combination(20, 10))
    println(get_combination1(4, 2))
  }

}
