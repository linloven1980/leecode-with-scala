package learn8
import scala.collection.mutable.ListBuffer
object Test14 {
  def sudoku(arr: Array[Array[Int]]): Boolean = {
    def backtracking(x: Int, y: Int): Boolean = {
      if (x > 8) return true

      if (arr(x)(y) == 0) {

        for (i <- 1 to 9) {

          var flag = true
          for (j <- 0 to 8) {
            if (arr(x)(j) == i) flag = false
          }
          for (j <- 0 to 8) {
            if (arr(j)(y) == i) flag = false
          }
          var xxx = x / 3 * 3
          var yyy = y / 3 * 3
          for (xxx1 <- xxx to xxx + 2) {
            for (yyy1 <- yyy to yyy + 2) {
              if (arr(xxx1)(yyy1) == i) flag = false
            }
          }
          if (flag == true) {
            arr(x)(y) = i
            var xx = x
            var yy = y
            if (yy < 8) {
              yy += 1
            } else {
              xx += 1
              yy = 0
            }
            var ret = backtracking(xx, yy)
            if (ret) return true
            else {
              arr(x)(y) = 0
            }
          }
        }
      } else {
        var xx = x
        var yy = y
        if (yy < 8) {
          yy += 1
        } else {
          xx += 1
          yy = 0
        }
        return backtracking(xx, yy)
      }

      false
    }
    return backtracking(0, 0)
  }

  def main(args: Array[String]): Unit = {
    var matrix: Array[Array[Int]] = Array.ofDim(9, 9)
    var values: Array[Int] = Array[Int](5,3,0,0,7,0,0,0,0,6,0,0,1,9,5,0,0,0,0,9,8,0,0,0,0,6,0,8,0,0,0,6,0,0,0,3,4,0,0,8,0,3,0,0,1,7,0,0,0,2,0,0,0,6,0,6,0,0,0,0,2,8,0,0,0,0,4,1,9,0,0,5,0,0,0,0,8,0,0,7,9)
    //println(values.length)
    for (i <- 0 to 8){
      for (j <- 0 to 8) {
        matrix(i)(j) = values(i * 9 + j)
      }
    }

    //println(matrix.map(_.mkString(" ")).mkString("\n"))
    println(sudoku(matrix))
    println(matrix.map(_.mkString(" ")).mkString("\n"))
  }

}
