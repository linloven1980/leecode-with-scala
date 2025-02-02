package learn8
import scala.collection.mutable.ListBuffer
object Test7 {
  def get_sub_set(a: Array[Int]): List[List[Int]] = {
    var result: ListBuffer[Int] = ListBuffer.empty
    var results: ListBuffer[List[Int]] = ListBuffer.empty
    def backtracking(index: Int, count: Int): Unit = {
      if (result.length == count) {
        results.append(result.toList)
        return
      }
      for (i <- index to a.length - count + result.length) {
        result.append(a(i))
        backtracking(i + 1, count)
        result.remove(result.length - 1)
      }
    }
    for (i <- 0 to a.length) {
      backtracking(0, i)
    }
    results.toList

  }
  def get_sub_set1(a: Array[Int]): List[List[Int]] = {
    var result: ListBuffer[Int] = ListBuffer.empty
    var results: ListBuffer[List[Int]] = ListBuffer.empty
    def backtracking(index: Int): Unit = {
      results.append(result.toList)
      for (i <- index to a.length - 1) {
        result.append(a(i))
        backtracking(i + 1)
        result.remove(result.length - 1)
      }
    }
    backtracking(0)
    results.toList
  }

  def main(args: Array[String]): Unit = {
    println(get_sub_set(Array[Int](1, 2, 3)))
    println(get_sub_set1(Array[Int](1, 2, 3)))
  }

}
