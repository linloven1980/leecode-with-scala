package learn8
import scala.collection.mutable.ListBuffer
object Test1 {
  def combination_sum(n: Int, k: Int): List[List[Int]] = {
    var result: ListBuffer[Int] = ListBuffer.empty
    var results: ListBuffer[List[Int]] = ListBuffer.empty
    var sum = 0
    def backtracking(index: Int, k: Int): Unit = {
      if (result.length == k) {

        if (sum == n) results.append(result.toList)
        return
      }
      for (i <- index to math.min(9 - (k - result.length) + 1, n - sum)) {
        result.append(i)
        sum += i
        backtracking(i + 1, k)
        result.remove(result.length - 1)
        sum -= i
      }
    }
    backtracking(1, k)
    results.toList
  }

  def main(args: Array[String]): Unit = {
    println(combination_sum(45, 9))
    println(combination_sum(27, 5))
    println(combination_sum(18, 4))
  }

}
