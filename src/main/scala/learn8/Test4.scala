package learn8
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._
object Test4 {
  def combination_sum(a: Array[Int], target: Int): List[List[Int]] = {
    var result: ListBuffer[Int] = ListBuffer.empty
    var results: ListBuffer[List[Int]] = ListBuffer.empty
    var arr = a.sorted
    println(arr.mkString(","))
    var sum = 0
    def backtracking(index: Int): Unit = {
      if (sum > target) return
      if (sum == target) {
        results.append(result.toList)
        return
      }
      breakable{
        for (i <- index to arr.length - 1) {
          if (sum + arr(i) > target) break
          if (index == i || i > index && arr(i) != arr(i - 1)) {
            result.append(arr(i))
            sum += arr(i)
            backtracking(i + 1)
            result.remove(result.length - 1)
            sum -= arr(i)
          }

        }
      }

    }
    backtracking(0)
    results.toList
  }
  def main(args: Array[String]): Unit = {
    println(combination_sum(Array[Int](10,1,2,7,6,1,5), 8))
    println(combination_sum(Array[Int](2,5,2,1,2), 5))
  }

}
