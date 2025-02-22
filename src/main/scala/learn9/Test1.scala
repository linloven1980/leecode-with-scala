package learn9

object Test1 {
  def swing_length(arr: Array[Int]): Int = {
    var a: Array[Int] = new Array[Int](arr.length - 1)
    for (i <- 1 to arr.length - 1) {
      if (arr(i) >= arr(i - 1)) a(i - 1) = 1
      else a(i - 1) = -1
    }
    var sum = 0
    for (i <- 0 to a.length - 1) {
      if (i == 0 || i > 0 && a(i) != a(i - 1)) sum += 1
    }
    sum + 1
  }

  def main(args: Array[String]): Unit = {
    println(swing_length(Array[Int](1,7,4,9,2,5)))
    println(swing_length(Array[Int](1,17,5,10,13,15,10,5,16,8)))
    println(swing_length(Array[Int](1,2,3,4,5,6,7,8,9)))
    println(swing_length(Array[Int](1,2,2,2,1)))
    println(swing_length(Array[Int](1,2,2,2,3,4)))
  }
}
