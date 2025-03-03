package learn10
import scala.collection.mutable.ListBuffer
object Test13 {
  def transform(str: String): (Int, Int) = {
    var zero: Int = 0
    var one: Int = 0
    val arr = str.toCharArray
    for (i <- 0 to arr.length - 1) {
      if (arr(i) == '0') zero += 1
      if (arr(i) == '1') one += 1
    }
    (zero, one)
  }
  def one_and_zero(arr: Array[String], m: Int, n: Int): Int = {
    val arr1: Array[(Int, Int)] = new Array[(Int, Int)](arr.length)
    for (i <- 0 to arr.length - 1) {
      arr1(i) = transform(arr(i))
    }
    println(arr1.mkString(","))
    var tmp_m: Int = 0
    var tmp_n: Int = 0
    val l: ListBuffer[(Int, Int)] = ListBuffer.empty
    var result: Int = 0
    def backtracking(index: Int): Unit = {
      if (index == arr1.length) {
        if (l.length > result) result = l.length
        return
      }

      if (arr1(index)._1 + tmp_m <= m && arr1(index)._2 + tmp_n <= n) {
        tmp_m += arr1(index)._1
        tmp_n += arr1(index)._2
        l.append(arr1(index))
        backtracking(index + 1)
        l.remove(l.length - 1)
        tmp_m -= arr1(index)._1
        tmp_n -= arr1(index)._2
      }
      backtracking(index + 1)

    }
    backtracking(0)
    result
  }

  def one_and_zero1(arr: Array[String], m: Int, n: Int): Int = {
    val arr1: Array[(Int, Int)] = new Array[(Int, Int)](arr.length)
    for (i <- 0 to arr.length - 1) {
      arr1(i) = transform(arr(i))
    }
    //println(arr1.mkString(","))
    var dp: Array[Array[Array[Int]]] = Array.ofDim[Int](arr.length, m+1, n+1)
    for (i <- 0 to m) {
      for (j <- 0 to n) {
        if (arr1(0)._1 <= i && arr1(0)._2 <= j) {
          dp(0)(i)(j) = 1
        }
      }
    }
    //println(dp(0).map(_.mkString(",")).mkString("\n"))
    for (index <- 1 to arr1.length - 1) {
      for (i <- 0 to m) {
        for (j <- 0 to n) {
          if (arr1(index)._1 <= i && arr1(index)._2 <= j) {
            dp(index)(i)(j) = math.max(dp(index - 1)(i)(j), 1 + dp(index - 1)(i - arr1(index)._1)(j - arr1(index)._2))
          } else {
            dp(index)(i)(j) = dp(index - 1)(i)(j)
          }
        }
      }
      //println
      //println(dp(index).map(_.mkString(",")).mkString("\n"))
    }
    dp(arr1.length - 1)(m)(n)
  }

  def main(args: Array[String]): Unit = {
    println(one_and_zero(Array[String]("10", "0001", "111001", "1", "0"), 5, 3))
    println(one_and_zero(Array[String]("10", "0", "1"), 1, 1))
    println(one_and_zero1(Array[String]("10", "0001", "111001", "1", "0"), 5, 3))
    println(one_and_zero1(Array[String]("10", "0", "1"), 1, 1))
  }

}
