package learn10

object Test23 {
  def steal(arr: Array[Int]): Int = {
    if (arr.length == 1) return arr(0)
    if (arr.length == 2) return math.max(arr(0), arr(1))
    if (arr.length == 3) return math.max(arr(0), math.max(arr(1), arr(2)))
    val dp1: Array[Int] = new Array[Int](arr.length)
    val dp2: Array[Int] = new Array[Int](arr.length)
    dp1(0) = arr(0)
    dp1(1) = arr(0)
    for (i <- 2 to arr.length - 2) {
      dp1(i) = math.max(dp1(i - 1), dp1(i - 2) + arr(i))
    }
    dp2(0) = 0
    dp2(1) = arr(1)
    for (i <- 2 to arr.length - 1) {
      dp2(i) = math.max(dp2(i - 1), dp2(i - 2) + arr(i))
    }
    math.max(dp1(arr.length - 2), dp2(arr.length - 1))
  }

  def main(args: Array[String]): Unit = {
    println(steal(Array[Int](2,3,2)))
    println(steal(Array[Int](1,2,3,1)))
    println(steal(Array[Int](0)))
  }
}
