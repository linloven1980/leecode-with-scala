package learn10
import scala.collection.mutable.ListBuffer
object Test7 {
  def different_tree(n: Int): Int = {
    if (n == 1) return 1
    var dp: Array[Int] = new Array[Int](n + 1)
    dp(0) = 1
    dp(1) = 1
    for (i <- 2 to n) {
      for (j <- 1 to i) {
        dp(i) += dp(j - 1) * dp(i - j)
      }

    }
    dp(n)
  }

  def main(args: Array[String]): Unit = {
    println(different_tree(1))
    println(different_tree(2))
    println(different_tree(3))
    println(different_tree(4))
  }

}
