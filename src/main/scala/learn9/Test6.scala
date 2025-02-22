package learn9

object Test6 {
  def k_opposit_sum(arr: Array[Int], k: Int): Int = {
    var a = arr.sorted
    var sum: Int = 0
    var count: Int = k
    var min: Int = Int.MaxValue
    var result: Int = 0
    for (i <- 0 to a.length - 1) {
      if (a(i) < 0 && count > 0) {
        sum -= a(i)
        count -= 1
      } else {
        sum += a(i)
      }
      min = math.min(min, math.abs(a(i)))
    }
    if (count == 0) result = sum
    else {
      if (count % 2 == 0) result = sum
      else result = sum - min * 2
    }
    result
  }

  def k_opposit_sum1(arr: Array[Int], k: Int): Int = {
    var a = arr.sortBy(math.abs(_))
    var count: Int = k
    for (i <- a.length - 1 to 0 by -1) {
      if (a(i) < 0 && count > 0) {
        a(i) = math.abs(a(i))
        count -= 1
      }
    }
    if (count > 0 && count % 2 != 0) {
      a(0) = a(0) * -1
    }
    a.sum
  }
  def main(args: Array[String]): Unit = {
    println(k_opposit_sum(Array[Int](4,2,3), 1))
    println(k_opposit_sum(Array[Int](3,-1,0,2), 3))
    println(k_opposit_sum(Array[Int](2,-3,-1,5,-4), 2))
    println(k_opposit_sum1(Array[Int](4,2,3), 1))
    println(k_opposit_sum1(Array[Int](3,-1,0,2), 3))
    println(k_opposit_sum1(Array[Int](2,-3,-1,5,-4), 2))
  }
}
