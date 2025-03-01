package learn10

object Test12 {
  def target_sum(arr: Array[Int], target: Int): Int = {
    var sum: Int = 0
    var result: Int = 0
    def backtracking(index: Int): Unit = {
      if (index == arr.length) {
        if (sum == target) result += 1
        return
      }
      sum += arr(index)
      backtracking(index + 1)
      sum -= arr(index)
      sum -= arr(index)
      backtracking(index + 1)
      sum += arr(index)
    }
    backtracking(0)
    result
  }

  def target_sum1(arr: Array[Int], target: Int): Int = {
    var bag_volumn: Int = (arr.sum - target) / 2
    var result: Int = 0
    var sum = 0
    def backtracking(index: Int): Unit = {
      if (sum == bag_volumn) {
        result += 1
        return
      }
      if (sum > bag_volumn) return
      for (i <- index to arr.length - 1) {
        sum += arr(i)
        backtracking(i + 1)
        sum -= arr(i)
      }
    }
    backtracking(0)
    result
  }

  def target_sum2(arr: Array[Int], target: Int): Int = {
    val bag_volumn: Int = (arr.sum + target) / 2
    val dp: Array[Array[(Int, Int)]] = Array.ofDim[(Int, Int)](arr.length, bag_volumn + 1)
    for (j <- 0 to bag_volumn) {
      if (j < arr(0)) dp(0)(j) = (0, 1)
      else dp(0)(j) = (arr(0), 1)
    }
    for (i <- 0 to arr.length - 1) {
      dp(i)(0) = (0, 1)
    }
    for (i <- 1 to arr.length -1) {
      for (j <- 1 to bag_volumn) {
        if (j < arr(i)) dp(i)(j) = dp(i - 1)(j)
        else {
          val a: Int = dp(i - 1)(j)._1
          val b: Int = arr(i) + dp(i - 1)(j - arr(i))._1
          if (a > b) dp(i)(j) = dp(i - 1)(j)
          else if (a < b) dp(i)(j) = (b, 1)
          else dp(i)(j) = (a, dp(i - 1)(j)._2 + dp(i - 1)(j - arr(i))._2)
        }
      }
    }
    println(dp.map(_.mkString(",")).mkString("\n"))
    if (dp(arr.length - 1)(bag_volumn)._1 == bag_volumn) return dp(arr.length - 1)(bag_volumn)._2
    0
  }

  def main(args: Array[String]): Unit = {
    println(target_sum(Array[Int](1, 1, 1, 1, 1), 3))
    println(target_sum1(Array[Int](1, 1, 1, 1, 1), 3))
    println(target_sum2(Array[Int](1, 1, 1, 1, 1), 3))
  }
}
