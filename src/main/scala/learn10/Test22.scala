package learn10

object Test22 {
  def steal(arr: Array[Int]): Int = {
    if (arr.length == 1) return arr(0)
    if (arr.length == 2) return math.max(arr(0), arr(1))
    val dp: Array[(Int, Int)] = new Array[(Int, Int)](arr.length)
    dp(0) = (arr(0), 0)
    dp(1) = (arr(1), arr(0))
    for (i <- 2 to arr.length - 1) {
      //println(i)
      dp(i) = (arr(i) + dp(i - 1)._2, math.max(dp(i - 1)._1, dp(i - 1)._2))
      //println(dp(i))
    }
    math.max(dp(arr.length - 1)._1, dp(arr.length - 1)._2)
  }

  def steal1(arr: Array[Int]): Int = {
    if (arr.length == 1) return arr(0)
    if (arr.length == 2) return math.max(arr(0), arr(1))
    val dp: Array[Int] = new Array[Int](arr.length)
    dp(0) = arr(0)
    dp(1) = math.max(arr(0), arr(1))
    for (i <- 2 to arr.length - 1) {
      dp(i) = math.max(arr(i) + dp(i - 2), dp(i - 1))
    }
    dp(arr.length - 1)
  }

  def main(args: Array[String]):Unit = {
    println(steal(Array[Int](1,2,3,1)))
    println(steal(Array[Int](2,7,9,3,1)))
    println(steal1(Array[Int](1,2,3,1)))
    println(steal1(Array[Int](2,7,9,3,1)))
  }

}
