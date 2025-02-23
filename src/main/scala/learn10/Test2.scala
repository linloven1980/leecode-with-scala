package learn10

object Test2 {
  def min_cost(cost: Array[Int]): Int = {
    var dp: Array[Int] = new Array[Int](cost.length)
    dp(0) = cost(0)
    dp(1) = cost(1)
    if (cost.length > 2) {
      for (i <- 2 to cost.length - 1) {
        dp(i) = math.min(dp(i - 1) + cost(i), dp(i - 2) + cost(i))
      }

    }
    math.min(dp(cost.length - 2), dp(cost.length - 1))
  }

  def main(args: Array[String]): Unit = {
    println(min_cost(Array[Int](10, 15, 20)))
    println(min_cost(Array[Int](1, 100, 1, 1, 1, 100, 1, 1, 100, 1)))
  }

}
