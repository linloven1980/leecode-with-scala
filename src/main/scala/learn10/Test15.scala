package learn10

object Test15 {
  def exchange(coins: Array[Int], total: Int): Int = {
    var result: Int = 0
    var sum: Int = 0
    def backtracking(index: Int): Unit = {
      if (index == coins.length) {
        if (sum == total) {
          result += 1

        }
        return
      }


      var cnt = 0
      while (coins(index) * cnt + sum <= total) {
        sum += coins(index) * cnt
        backtracking(index + 1)
        sum -= coins(index) * cnt
        cnt += 1
      }
    }
    backtracking(0)
    result
  }

  def exchange1(coins: Array[Int], total: Int): Int = {
    val dp: Array[Array[(Int, Int)]] = Array.ofDim[(Int, Int)](coins.length, total + 1)
    for (j <- 0 to total) {
      if (coins(0) <= j) dp(0)(j) = (coins(0) + dp(0)(j - coins(0))._1, 1)
      else dp(0)(j) = (0, 1)
    }

    for (i <- 1 to coins.length - 1) {
      for (j <- 0 to total) {
        if (coins(i) <= j) {
          val a = dp(i - 1)(j)._1
          val b = coins(i) + dp(i)(j - coins(i))._1
          if (a > b) dp(i)(j) = dp(i - 1)(j)
          else if (a < b) dp(i)(j) = (b, dp(i)(j - coins(i))._2)
          else dp(i)(j) = (a, dp(i - 1)(j)._2 + dp(i)(j - coins(i))._2)
        }else {
          dp(i)(j) = dp(i - 1)(j)
        }

      }
    }
    if (dp(coins.length - 1)(total)._1 == total) return dp(coins.length - 1)(total)._2
    0
  }

  def exchange2(coins: Array[Int], total: Int): Int = {
    val dp: Array[Array[Int]] = Array.ofDim[Int](coins.length, total + 1)
    for (j <- 0 to total) {
      if (j % coins(0) == 0) dp(0)(j) = 1
    }
    for (i <- 0 to coins.length - 1) {
      dp(i)(0) = 1
    }
    for (i <- 1 to coins.length - 1) {
      for (j <- 1 to total) {
        if (j >= coins(i)) dp(i)(j) = dp(i - 1)(j) + dp(i)(j - coins(i))
        else dp(i)(j) = dp(i - 1)(j)
      }
    }
    //println(dp.map(_.mkString(",")).mkString("\n"))
    dp(coins.length - 1)(total)
  }

  def exchange3(coins: Array[Int], total: Int): Int = {
    val dp: Array[Int] = new Array[Int](total + 1)
    dp(0) = 1
    for (i <- 0 to coins.length - 1) {
      for (j <- 1 to total) {
        if (j >= coins(i)) dp(j) += dp(j - coins(i))
      }
    }
    dp(total)
  }

  def main(args: Array[String]): Unit = {
    println(exchange(Array[Int](1, 2, 5), 5))
    println(exchange(Array[Int](2), 3))
    println(exchange(Array[Int](10), 10))
    println(exchange1(Array[Int](1, 2, 5), 5))
    println(exchange1(Array[Int](2), 3))
    println(exchange1(Array[Int](10), 10))
    println(exchange2(Array[Int](1, 2, 5), 5))
    println(exchange2(Array[Int](2), 3))
    println(exchange2(Array[Int](10), 10))
    println(exchange3(Array[Int](1, 2, 5), 5))
    println(exchange3(Array[Int](2), 3))
    println(exchange3(Array[Int](10), 10))
  }

}
