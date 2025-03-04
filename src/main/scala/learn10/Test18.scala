package learn10

object Test18 {
  def exchange(coins: Array[Int], total: Int): Int = {
    val dp: Array[Array[Int]] = Array.fill[Int](coins.length, total + 1)(Int.MaxValue)
    dp(0)(0) = 0
    for (j <- 1 to total) {
      if (j % coins(0) == 0) dp(0)(j) = dp(0)(j - coins(0)) + 1
    }

    for (i <- 1 to coins.length - 1) {
      for (j <- 0 to total) {
        if (j >= coins(i)) {
          dp(i)(j) = math.min(dp(i - 1)(j), dp(i)(j - coins(i)) + 1)
        } else {
          dp(i)(j) = dp(i - 1)(j)
        }
      }
    }
    //println(dp.map(_.mkString(",")).mkString("\n"))
    if (dp(coins.length - 1)(total) == Int.MaxValue) return -1
    dp(coins.length - 1)(total)
  }

  def main(args: Array[String]): Unit = {
    println(exchange(Array[Int](1, 2, 5), 11))
    println(exchange(Array[Int](2), 3))
    println(exchange(Array[Int](1), 0))
    println(exchange(Array[Int](1), 1))
    println(exchange(Array[Int](1), 2))
  }

}
