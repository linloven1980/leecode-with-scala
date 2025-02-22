package learn9

object Test3 {
  def buy_stock(arr: Array[Int]): Int = {
    var begin: Int = 0
    var end: Int = 0
    var sum: Int = 0
    for (i <- 0 to arr.length - 1) {
      if (i == 0 || i > 0 && arr(i) >= arr(i - 1)) {
        end = i
        if (end == arr.length - 1) sum += arr(end) - arr(begin)

      } else {
        sum += arr(end) - arr(begin)
        begin = i
        end = i


      }
    }
    sum
  }
  def buy_stock1(arr: Array[Int]): Int = {
    var profit_arr:Array[Int] = new Array[Int](arr.length - 1)
    for (i <- 1 to arr.length - 1) {
      profit_arr(i - 1) = arr(i) - arr(i - 1)
    }
    var sum = 0
    for (i <- 0 to profit_arr.length - 1) {
      if (profit_arr(i) > 0) sum += profit_arr(i)
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    println(buy_stock(Array[Int](7,1,5,3,6,4)))
    println(buy_stock(Array[Int](1,2,3,4,5)))
    println(buy_stock(Array[Int](7,6,4,3,1)))
    println(buy_stock1(Array[Int](7,1,5,3,6,4)))
    println(buy_stock1(Array[Int](1,2,3,4,5)))
    println(buy_stock1(Array[Int](7,6,4,3,1)))
  }

}
