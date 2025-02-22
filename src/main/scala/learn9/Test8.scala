package learn9

object Test8 {
  def deliver_candy(score: Array[Int]): Int = {
    if (score.length == 1) return 1
    var candy: Array[Int] = new Array[Int](score.length)
    candy(0) = 1
    for (i <- 1 to score.length - 1) {
      if (score(i) > score(i - 1)) candy(i) = candy(i - 1) + 1
      else if (score(i) == score(i - 1)) candy(i) = 1
      else {
        candy(i) = 1
        var j = i - 1
        while (j >= 0 && score(j) > score(j + 1) && candy(j) <= candy(j + 1)) {
          candy(j) = candy(j + 1) + 1
          j -= 1
        }
      }
    }
    candy.sum
  }
  def deliver_candy1(score: Array[Int]): Int = {
    if (score.length == 1) return 1
    var candy: Array[Int] = Array.fill(score.length)(1)
    for (i <- 1 to score.length - 1) {
      if (score(i) > score(i - 1)) {
        candy(i) = candy(i - 1) + 1
      }
    }
    for (i <- score.length -2 to 0 by -1) {
      if (score(i) > score(i + 1)) {
        candy(i) = math.max(candy(i), candy(i + 1) + 1)
      }
    }
    candy.sum
  }

  def main(args: Array[String]): Unit = {
    println(deliver_candy(Array[Int](1,0,2)))
    println(deliver_candy(Array[Int](1,2,2)))
    println(deliver_candy(Array[Int](1,2,2,5,4,3,2)))
    println(deliver_candy1(Array[Int](1,0,2)))
    println(deliver_candy1(Array[Int](1,2,2)))
    println(deliver_candy1(Array[Int](1,2,2,5,4,3,2)))
  }
}
