package learn8
import scala.collection.mutable.ListBuffer
object Test8 {
  def get_sub_group(a: Array[Int]): List[List[Int]] = {
    var arr = a.sorted
    var result: ListBuffer[Int] = ListBuffer.empty
    var results: ListBuffer[List[Int]] = ListBuffer.empty
    def backtracking(index: Int): Unit = {
      results.append(result.toList)
      for (i <- index to arr.length - 1) {
        if (i == index || i > index && arr(i) != arr(i - 1)) {
          result.append(arr(i))
          backtracking(i + 1)
          result.remove(result.length - 1)
        }
      }
    }
    backtracking(0)
    results.toList
  }

  def main(args: Array[String]): Unit = {
    println(get_sub_group(Array[Int](2, 2, 1)))
  }
}
