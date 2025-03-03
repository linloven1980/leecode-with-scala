package learn10

object Test16 {
  def combination_sum(arr: Array[Int], sum: Int): Int = {
    val dp: Array[Int] = new Array[Int](sum + 1)
    dp(0) = 1
    for (j <- 1 to sum) {
      for (i <- 0 to arr.length - 1) {
        if (j >= arr(i)) dp(j) += dp(j - arr(i))
      }
    }
    dp(sum)
  }

  def main(args: Array[String]): Unit = {
    println(combination_sum(Array[Int](1, 2, 3), 4))
  }

}
