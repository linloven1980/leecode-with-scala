package learn10

object Test1 {
  def climb_stair(n: Int): Int = {
    if (n == 1) return 1

    var cnt = 0
    def backtracking(i: Int): Unit = {
      if (i == n) {
        cnt += 1
        return
      }
      if (i == n - 1) {
        cnt += 2
        return
      }
      backtracking(i + 1)
      backtracking(i + 2)
    }
    backtracking(1)
    cnt
  }
  def climb_stair1(n: Int): Int = {
    if (n == 1) return 1
    if (n == 2) return 2
    var dp: Array[Int] = new Array[Int](n)
    dp(0) = 1
    dp(1) = 2
    for (i <- 2 to n - 1){
      dp(i) = dp(i - 1) + dp(i - 2)
    }
    dp(n - 1)
  }

  def main(args: Array[String]): Unit = {
    println(climb_stair(2))
    println(climb_stair(3))
    println(climb_stair(4))
    println(climb_stair1(2))
    println(climb_stair1(3))
    println(climb_stair1(4))
  }

}
