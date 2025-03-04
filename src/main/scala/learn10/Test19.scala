package learn10
import scala.collection.mutable.{ArrayStack, ListBuffer}
object Test19 {
  def complete_square(n: Int): Int = {
    val l: ListBuffer[Int] = ListBuffer.empty
    var num: Int = 1
    var num_square: Int = 1
    while (num_square <= n) {
      l.append(num_square)
      num += 1
      num_square = num * num
    }
    val nums: Array[Int] = l.toArray
    val dp: Array[Array[Int]] = Array.fill(nums.length, n + 1)(Int.MaxValue)
    dp(0)(0) = 0
    for (j <- 1 to n) {
      dp(0)(j) = j
    }
    for (i <- 1 to nums.length - 1) {
      for (j <- 0 to n) {
        if (j >= nums(i)) {
          dp(i)(j) = math.min(dp(i - 1)(j), dp(i)(j - nums(i)) + 1)
        } else {
          dp(i)(j) = dp(i - 1)(j)
        }
      }
    }
    dp(nums.length - 1)(n)
  }

  def main(args: Array[String]): Unit = {
    println(complete_square(12))
    println(complete_square(13))
  }

}
