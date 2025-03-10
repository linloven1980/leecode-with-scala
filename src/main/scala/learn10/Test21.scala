package learn10

object Test21 {
  def multi_layer_bag(weight: Array[Int], value: Array[Int], count: Array[Int], bag_volumn: Int): Int = {
    val counts: Int = count.sum
    val weight1: Array[Int] = new Array[Int](counts)
    val value1: Array[Int] = new Array[Int](counts)
    var index: Int = 0
    for (i <- 0 to count.length - 1) {
      for (j <- 1 to count(i)) {
        weight1(index) = weight(i)
        value1(index) = value(i)
        index += 1
      }
    }
    println(weight1.mkString(","))
    println(value1.mkString(","))
    val dp: Array[Array[Int]] = Array.ofDim[Int](weight1.length, bag_volumn + 1)
    for (j <- 1 to bag_volumn) {
      if (j >= weight1(0)) dp(0)(j) = value1(0)
    }
    for (i <- 1 to weight1.length - 1) {
      for (j <- 1 to bag_volumn) {
        if (j >= weight1(i)) {
          dp(i)(j) = math.max(dp(i - 1)(j), value1(i) + dp(i - 1)(j - weight1(i)))
        } else dp(i)(j) = dp(i - 1)(j)
      }
    }
    dp(weight1.length - 1)(bag_volumn)
   }

  def main(args: Array[String]): Unit = {
    println(multi_layer_bag(Array[Int](1, 3, 4), Array[Int](15, 20, 30), Array[Int](2, 3, 2), 10))
  }

}
