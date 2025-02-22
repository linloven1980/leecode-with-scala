package learn9

object Test2 {
  def max_sub_array(arr: Array[Int]): Int = {
    var sum: Int = Int.MinValue
    for (i <- 0 to arr.length - 1) {
      var tmp: Int = 0
      for (j <- i to arr.length - 1) {
        tmp += arr(j)
        if (tmp > sum) sum = tmp
      }
    }
    sum
  }

  def max_sub_array1(arr: Array[Int]): Int = {
    var sum: Int = Int.MinValue
    var tmp: Int = 0
    for (i <- 0 to arr.length - 1) {
      tmp += arr(i)
      if (tmp > sum) sum = tmp
      if (tmp < 0) tmp = 0

    }
    sum
  }

  def main(args: Array[String]): Unit = {
    println(max_sub_array(Array[Int](-2,1,-3,4,-1,2,1,-5,4)))
    println(max_sub_array1(Array[Int](-2,1,-3,4,-1,2,1,-5,4)))
  }
}
