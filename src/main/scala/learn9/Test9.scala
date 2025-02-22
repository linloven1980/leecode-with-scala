package learn9

object Test9 {
  def lemon_exchange(cash: Array[Int]): Boolean = {
    var cash_count: Array[Int] = Array[Int](0, 0)
    for (i <- 0 to cash.length - 1) {
      if (cash(i) == 5) {
        cash_count(0) += 1
      } else if (cash(i) == 10) {
        cash_count(1) += 1
        cash_count(0) -= 1
        if (cash_count(0) < 0) return false
      } else if (cash(i) == 20) {
        if (cash_count(1) > 0) {
          cash_count(1) -= 1
          cash_count(0) -= 1
        } else {
          cash_count(0) -= 3
        }
        if (cash_count(0) < 0) return false
      }

    }
    true
  }
  def main(args: Array[String]): Unit = {
    println(lemon_exchange(Array[Int](5,5,5,10,20)))
    println(lemon_exchange(Array[Int](5,5,10)))
    println(lemon_exchange(Array[Int](10,10)))
    println(lemon_exchange(Array[Int](5,5,10,10,20)))
  }

}
