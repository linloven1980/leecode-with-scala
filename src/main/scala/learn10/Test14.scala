package learn10

object Test14 {
  def full_bag(weight: Array[Int], value: Array[Int], bag_volumn: Int): Int = {
    val dp: Array[Array[Int]] = Array.ofDim[Int](weight.length, bag_volumn + 1)
    for (j <- 1 to bag_volumn) {
      if (weight(0) <= j) dp(0)(j) = value(0) + dp(0)(j - weight(0))
    }
    for (i <- 1 to weight.length - 1) {
      for (j <- 1 to bag_volumn) {
        if (weight(i) <= j) {
          dp(i)(j) = math.max(dp(i - 1)(j), value(i) + dp(i)(j - weight(i)))
        }else {
          dp(i)(j) = dp(i - 1)(j)
        }
      }
    }
    dp(weight.length - 1)(bag_volumn)
  }

  def main(args: Array[String]): Unit = {
    println(full_bag(Array[Int](1, 3, 4), Array[Int](15, 20, 30), 4))
  }

}
