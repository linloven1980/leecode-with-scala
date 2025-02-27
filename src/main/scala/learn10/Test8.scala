package learn10

object Test8 {
  def bag_question(weight: Array[Int], value: Array[Int], bag_volumn: Int): Int = {
    val dp: Array[Array[Int]] = Array.ofDim[Int](weight.length, bag_volumn + 1)
    for (j <- 1 to bag_volumn) {
      if (j >= weight(0)) dp(0)(j) = value(0)
    }
    for (i <- 1 to weight.length - 1) {
      for (j <- 1 to bag_volumn) {
        if (j < weight(i)) dp(i)(j) = dp(i - 1)(j)
        else {
          dp(i)(j) = math.max(dp(i - 1)(j), value(i) + dp(i - 1)(j - weight(i)))
        }
      }
    }
    println(dp.map(_.mkString(",")).mkString("\n"))
    dp(weight.length - 1)(bag_volumn)
  }

  def main(args: Array[String]): Unit = {
    println(bag_question(Array[Int](1, 3, 4), Array[Int](15, 20, 30), 4))
  }
}
