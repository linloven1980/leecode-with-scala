package learn8
import scala.collection.mutable.ListBuffer
object Test11 {
  def get_full_sequence(arr: Array[Int]): List[List[Int]] = {
    var result: ListBuffer[Int] = ListBuffer.empty
    var results: ListBuffer[List[Int]] = ListBuffer.empty
    var used: Array[Int] = new Array[Int](arr.length)
    def backtracking(used: Array[Int]): Unit = {
      if (result.length == arr.length) {
        results.append(result.toList)
        return
      }
      var used_layer = new Array[Int](21)
      for (i <- 0 to arr.length - 1) {
        if (used(i) == 0 && used_layer(arr(i) + 10) == 0) {
          result.append(arr(i))
          used(i) = 1
          used_layer(arr(i) + 10) = 1
          backtracking(used)
          result.remove(result.length - 1)
          used(i) = 0
        }
      }
    }
    backtracking(used)
    results.toList
  }

  def get_full_sequence1(arr: Array[Int]): List[List[Int]] = {
    var result: ListBuffer[Int] = ListBuffer.empty
    var results: ListBuffer[List[Int]] = ListBuffer.empty
    var used: Array[Int] = new Array[Int](arr.length)
    var a = arr.sorted
    def backtracking(used: Array[Int]): Unit = {
      if (result.length == a.length) {
        results.append(result.toList)
        return
      }
      for (i <- 0 to a.length - 1) {
        if (used(i) == 0) {
          if (i == 0 || i > 0 && a(i) != a(i - 1) || used(i - 1) == 0) {
            result.append(a(i))
            used(i) = 1
            backtracking(used)
            result.remove(result.length - 1)
            used(i) = 0
          }
        }
      }
    }
    backtracking(used)
    results.toList
  }

  def main(args: Array[String]): Unit = {
    //println(get_full_sequence(Array[Int](1, 1, 2)))
    //println(get_full_sequence(Array[Int](1, 2, 1, 2)))
    println(get_full_sequence1(Array[Int](1, 1, 2)))
    //println(get_full_sequence1(Array[Int](1, 2, 1, 2)))
  }
}
