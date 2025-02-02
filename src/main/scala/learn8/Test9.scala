package learn8
import scala.collection.mutable.ListBuffer
object Test9 {
  def get_ascending_sub_set(a: Array[Int]): List[List[Int]] = {
    var result: ListBuffer[Int] = ListBuffer.empty
    var results: ListBuffer[List[Int]] = ListBuffer.empty
    def backtracking(index: Int): Unit = {
      if (result.length > 1) {
        results.append(result.toList)

      }
      var used: Array[Int] = new Array[Int](201)
      for (i <- index to a.length - 1) {
        if (used(a(i) + 100) == 0) {
          if (result.length == 0 || a(i) >= result(result.length - 1)) {
            used(a(i) + 100) = 1
            result.append(a(i))
            backtracking(i + 1)
            result.remove(result.length - 1)
          }

        }
      }
    }
    backtracking(0)
    results.toList
  }

  def main(args: Array[String]): Unit = {
    println(get_ascending_sub_set(Array[Int](4, 6, 7, 7)))
    println(get_ascending_sub_set(Array[Int](4, 7, 7, 5, 6, 6, 8)))
    println(get_ascending_sub_set(Array[Int](4, 7, 6, 7)))
  }
}
