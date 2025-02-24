package learn10

object Test4 {
  def different_path(m: Int, n: Int): Int = {
    var cnt: Int = 0

    def backtracking(i: Int, j: Int): Unit = {
      if (i == m && j == n) {
        cnt += 1
        return
      }
      if (i > m || j > n) return
      backtracking(i + 1, j)
      backtracking(i, j + 1)
    }

    backtracking(1, 1)
    cnt
  }

  def different_path1(m: Int, n: Int): Int = {
    var dp: Array[Array[Int]] = Array.ofDim[Int](m, n)
    dp(0)(1) = 1
    dp(1)(0) = 1
    dp(1)(1) = 2
    for (i <- 0 to m - 1) {
      for (j <- 0 to n - 1) {
        if (i == 0 || i == 1) {
          if (j > 1) {
            if (i == 0) dp(i)(j) = dp(i)(j - 1)
            else {
              dp(i)(j) = dp(i)(j - 1) + dp(i - 1)(j)
            }
          }
        } else {
          if (j == 0) {
            dp(i)(j) = dp(i - 1)(j)
          } else {
            dp(i)(j) = dp(i)(j - 1) + dp(i - 1)(j)
          }

        }
      }
    }
    println(dp.map(_.mkString(",")).mkString("\n"))
    dp(m - 1)(n - 1)
  }

  def main(args: Array[String]): Unit = {
    println(different_path(3, 7))
    println(different_path(2, 3))
    println(different_path(7, 3))
    println(different_path(3, 3))
    println(different_path1(3, 7))
    println(different_path1(2, 3))
    println(different_path1(7, 3))
    println(different_path1(3, 3))
  }

}
