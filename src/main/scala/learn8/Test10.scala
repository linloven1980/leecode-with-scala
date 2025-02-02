package learn8
import scala.collection.mutable.ListBuffer
object Test10 {
  def get_full_sequence(arr: Array[Int]): List[List[Int]] = {
    var result: ListBuffer[Int] = ListBuffer.empty
    var results: ListBuffer[List[Int]] = ListBuffer.empty
    def backtracking(a: Array[Int]): Unit = {
      if (a.length == 1) {
        result.append(a(0))
        results.append(result.toList)
        result.remove(result.length - 1)
      } else {
        for (i <- 0 to a.length - 1) {
          result.append(a(i))
          var tmp: Array[Int] = Array.empty
          if (i == 0) tmp = a.slice(1, a.length)
          else if (i == a.length - 1) tmp = a.slice(0, a.length - 1)
          else {
            var left = a.slice(0, i)
            var right = a.slice(i + 1, a.length)
            tmp = left ++ right
          }
          backtracking(tmp)
          result.remove(result.length - 1)

        }
      }

    }
    backtracking(arr)
    results.toList
  }

  def get_full_sequence1(arr: Array[Int]): List[List[Int]] = {
    var result: ListBuffer[Int] = ListBuffer.empty
    var results: ListBuffer[List[Int]] = ListBuffer.empty
    var used: Array[Int] = new Array[Int](arr.length)
    def backtracking(used: Array[Int]): Unit = {
      if (result.length == arr.length) {
        results.append(result.toList)
        return
      }

      for (i <- 0 to arr.length - 1) {
        if (used(i) == 0) {
          result.append(arr(i))
          used(i) = 1
          backtracking(used)
          result.remove(result.length - 1)
          used(i) = 0
        }
      }
    }
    backtracking(used)
    results.toList
  }

  def main(args: Array[String]): Unit = {
    println(get_full_sequence(Array[Int](1, 2, 3)))
    println(get_full_sequence1(Array[Int](1, 2, 3)))
  }

}
