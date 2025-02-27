package learn10

object Test6 {
  def divide_int(n: Int): Int = {
    if (n == 2) return 1
    if (n == 3) return 2
    if (n == 4) return 4
    var quotient = n / 3
    var remainder = n % 3
    if (remainder == 0) return math.pow(3, quotient).toInt
    if (remainder == 1) return math.pow(3, quotient - 1).toInt * 4
    math.pow(3, quotient).toInt * 2
  }

  def divide_int1(n: Int): Int = {
    var dp: Array[Int] = new Array[Int](n + 1)
    dp(1) = 1
    for (i <- 2 to n) {
      for (j <- 1 to i / 2) {
        dp(i) = math.max(dp(i), math.max(j * (i - j), j * dp(i - j)))
      }
    }
    dp(n)
  }

  def main(args: Array[String]): Unit = {
    println(divide_int(10))
    println(divide_int(20))
    println(divide_int1(10))
    println(divide_int1(20))
  }

}
