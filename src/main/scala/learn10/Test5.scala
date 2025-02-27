package learn10
import scala.util.control.Breaks._

object Test5 {
  def different_path(matrix: Array[Array[Int]]): Int = {
    var cnt = 0
    def backtracking(i: Int, j: Int): Unit = {
      if (i == matrix.length - 1 && j == matrix(0).length - 1) {
        cnt += 1
        return
      }
      if (i > matrix.length - 1 || j > matrix(0).length - 1 || matrix(i)(j) == 1) return
      backtracking(i, j + 1)
      backtracking(i + 1, j)
    }
    backtracking(0, 0)
    cnt
  }
  def different_path1(matrix: Array[Array[Int]]): Int = {
    var dp: Array[Array[Int]] = Array.ofDim[Int](matrix.length, matrix(0).length)
    breakable{
      for (i <- 1 to matrix(0).length - 1) {
        if (matrix(0)(i) != 1) dp(0)(i) = 1
        else break()
      }
    }
    breakable{
      for (i <- 1 to matrix.length - 1) {
        if (matrix(i)(0) != 1) dp(i)(0) = 1
        else break()
      }

    }
    for (i <- 1 to matrix.length - 1) {
      for (j <- 1 to matrix(0).length - 1) {
        if (matrix(i)(j) == 1) {
          dp(i)(j) = 0
        } else {
          dp(i)(j) = dp(i)(j - 1) + dp(i - 1)(j)
        }
      }
    }
    println(dp.map(_.mkString(",")).mkString("\n"))
    dp(matrix.length - 1)(matrix(0).length - 1)

  }

  def main(args: Array[String]): Unit = {
    var matrix: Array[Array[Int]] = Array.ofDim[Int](3, 3)
    matrix(1)(1)  = 1
    println(different_path(matrix))
    println(different_path1(matrix))
    matrix = Array.ofDim[Int](2, 2)
    matrix(0)(1) = 1
    println(different_path(matrix))
    println(different_path1(matrix))
  }

}
