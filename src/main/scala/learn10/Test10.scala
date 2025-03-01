package learn10

object Test10 {
  def equal_sub_set(arr: Array[Int]): Boolean = {
    val sum = arr.sum
    if (sum % 2 != 0) return false
    val target: Int = sum / 2
    var tmp_sum = 0
    var result = false
    def backtracking(index: Int): Unit = {
      if (tmp_sum > target) return
      if (tmp_sum == target) {
        result = true
        return
      }
      for (i <- index to arr.length - 1) {
        tmp_sum += arr(i)
        backtracking(index + 1)
        tmp_sum -= arr(i)
        backtracking(index + 1)
      }
    }
    backtracking(0)
    result
  }

  def equal_sub_set1(arr: Array[Int]): Boolean = {
    val sum = arr.sum
    if (sum % 2 != 0) return false
    val target: Int = sum / 2
    val dp: Array[Int] = new Array[Int](target + 1)

    if (arr(0) == target) return true
    for (j <- 1 to target){
      if (arr(0) <= j) dp(j) = arr(0)
    }
    for (i <- 1 to arr.length - 1) {
      if (arr(i) == target) return true
      for (j <- target to 1 by -1 ) {
        if (arr(i) <= j) {
          dp(j) = math.max(dp(j), arr(i) + dp(j - arr(i)))
          if (dp(j) == target) return true
        }
      }
    }
    false
  }

  def main(args: Array[String]): Unit = {
    println(equal_sub_set(Array[Int](1, 5, 11, 5)))
    println(equal_sub_set(Array[Int](1, 2, 3, 5)))
    println(equal_sub_set1(Array[Int](1, 5, 11, 5)))
    println(equal_sub_set1(Array[Int](1, 2, 3, 5)))
  }
}
