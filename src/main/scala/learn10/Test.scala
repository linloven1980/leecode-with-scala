package learn10

object Test {
  def fibonacci(n: Int): Int = {
    if (n == 1) return 0
    if (n == 2) return 1
    var a = 0
    var b = 1
    if (n > 2) {


      for (i <- 3 to n) {
        var c = a + b
        a = b
        b = c

      }
    }
    b
  }
  def fibonacci1(n: Int): Int = {
    if (n == 1) return 0
    if (n == 2) return 1

    var dp: Array[Int] = new Array[Int](n)
    dp(0) = 0
    dp(1) = 1
    for (i <- 2 to n - 1) {
      dp(i) = dp(i - 1) + dp(i - 2)
    }
    dp(n - 1)
  }

  def main(args: Array[String]): Unit = {
    println(fibonacci(5))
    println(fibonacci(10))
    println(fibonacci1(5))
    println(fibonacci1(10))
  }
}
