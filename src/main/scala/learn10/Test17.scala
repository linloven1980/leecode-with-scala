package learn10

object Test17 {
  def climb_stair(): Int = {
    val input: String = scala.io.StdIn.readLine()
    val arr = input.split(" ")
    val height: Int = arr(0).toInt
    val max_steps: Int = arr(1).toInt
    val step: Array[Int] = new Array[Int](max_steps)
    for (i <- 0 to step.length - 1) step(i) = i + 1
    println(step.mkString(","))
    val dp: Array[Int] = new Array[Int](height + 1)
    dp(0) = 1
    for (j <- 1 to height) {
      for (i <- 0 to step.length - 1) {
        if (j >= step(i)) dp(j) += dp(j - step(i))
      }
      println(dp.mkString(","))
    }

    dp(height)
  }

  def main(args: Array[String]): Unit = {
    println(climb_stair())
  }

}
