package learn10

object Test11 {
  def last_stone(arr: Array[Int]): Int = {
    val sum = arr.sum
    val target = sum / 2
    val dp: Array[Int] = new Array[Int](target + 1)
    for (j <- 1 to target) {
      if (j >= arr(0)) dp(j) = arr(0)
    }

    for (i <- 1 to arr.length - 1) {
      for (j <- target to 1 by - 1) {
        if (j >= arr(i)) dp(j) = math.max(dp(j), arr(i) + dp(j - arr(i)))
      }
      
    }

    sum - dp(target) * 2

  }

  def main(args: Array[String]): Unit = {
    println(last_stone(Array[Int](2,7,4,1,8,1)))
  }

}
