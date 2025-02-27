package learn10

object Test9 {
  def bag_question(weight: Array[Int], value: Array[Int], bag_volumn: Int): Int = {
    val dp: Array[Int] = new Array[Int](bag_volumn + 1)
    for (j <- 0 to bag_volumn) {
      if (j >= weight(0)) dp(j) = value(0)
    }
    for (i <- 1 to weight.length - 1) {
      for (j <- bag_volumn to 1 by -1) {
        if (weight(i) <= j) {
          dp(j) = math.max(dp(j), value(i) + dp(j - weight(i)))
        }
      }
    }
    dp(bag_volumn)
  }

  def main(args: Array[String]): Unit = {
    println(bag_question(Array[Int](1, 3, 4), Array[Int](15, 20, 30), 4))
  }

}
