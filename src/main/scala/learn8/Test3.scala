package learn8
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._
object Test3 {
  def combination_sum(a: Array[Int], target: Int): List[List[Int]] = {
    var result: ListBuffer[Int] = ListBuffer.empty
    var results: ListBuffer[List[Int]] = ListBuffer.empty
    var sum = 0
    def backtracking(index: Int): Unit = {
      if (sum > target) return
      if (sum == target) {
        results.append(result.toList)
        return
      }
      if (index > a.length - 1) return
      var i = 0
      while (true) {
        if (sum + a(index) > target) {
          if (i > 0) {
            sum -= a(index) * (i - 1)
            for (i <- 1 to i - 1) result.remove(result.length - 1)
          }
          return
        }
        if (i > 0) {
          sum += a(index)
          result.append(a(index))
        }
        backtracking(index + 1)
        i += 1
      }
    }
    backtracking(0)
    results.toList
  }
  def combination_sum1(a: Array[Int], target: Int): List[List[Int]] = {
    var result: ListBuffer[Int] = ListBuffer.empty
    var results: ListBuffer[List[Int]] = ListBuffer.empty
    var sum = 0
    def backtracking(index: Int): Unit = {
      if (sum > target) return
      if (sum == target) {
        results.append(result.toList)
        return
      }
      breakable{
        for (i <- index to a.length - 1) {
          if (sum + a(i) > target) break
          result.append(a(i))
          sum += a(i)
          backtracking(i)
          result.remove(result.length - 1)
          sum -= a(i)
        }
      }


    }
    backtracking(0)
    results.toList
  }
  def main(args: Array[String]): Unit = {
    println(combination_sum(Array[Int](2, 3, 4), 8))
    println(combination_sum(Array[Int](2, 3, 6, 7), 7))
    println(combination_sum1(Array[Int](2, 3, 4), 8))
    println(combination_sum1(Array[Int](2, 3, 6, 7), 7))
  }

}
