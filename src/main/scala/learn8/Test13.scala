package learn8
import scala.collection.mutable.{ArrayStack, ListBuffer}
object Test13 {
  def n_queens(n: Int): List[List[String]] = {
    var result: ListBuffer[String] = ListBuffer.empty
    var results: ListBuffer[List[String]] = ListBuffer.empty
    var arr: Array[Array[Int]] = Array.ofDim[Int](n, n)
    def backtracking(index: Int, map: Array[Array[Int]]): Unit = {


      if (index == n) {
        if (result.length == n) {
          results.append(result.toList)
        }
        return
      }
      var arr: Array[Array[Int]] = map.map(_.clone())
      for (i <- 0 to n - 1) {
        //println("index:" + index)
        //println("i:" + i)
        //println(arr.map(_.mkString("")).mkString("\n"))
        if (arr(index)(i) == 0) {
          for (j <- 0 to n - 1) arr(index)(j) = 1
          for (j <- 0 to n - 1) arr(j)(i) = 1
          var x: Int = index
          var y: Int = i
          while (x < n && y < n) {
            arr(x)(y) = 1
            x += 1
            y += 1
          }
          x = index
          y = i
          while (x >= 0 && x < n && y >= 0 && y < n) {
            arr(x)(y) = 1
            x -= 1
            y -= 1
          }
          x = index
          y = i
          while (x < n && y >= 0 && y < n) {
            arr(x)(y) = 1
            x += 1
            y -= 1
          }
          x = index
          y = i
          while (x >= 0 && x < n && y < n) {
            arr(x)(y) = 1
            x -= 1
            y += 1
          }
          var tmp_chars: Array[Char] = new Array[Char](n)
          for (j <- 0 to n - 1) {
            if (j == i) tmp_chars(j) = 'Q'
            else tmp_chars(j) = '.'
          }
          //println(arr.map(_.mkString("")).mkString("\n"))
          result.append(tmp_chars.mkString(""))
          backtracking(index + 1, arr)
          result.remove(result.length - 1)
          arr = map.map(_.clone())
        }

      }
    }
    backtracking(0, arr)
    results.toList
  }

  def n_queens1(n: Int): List[List[String]] = {
    var result: ListBuffer[String] = ListBuffer.empty
    var results: ListBuffer[List[String]] = ListBuffer.empty
    var map: Array[Array[Char]] = Array.fill(n, n)('.')
    def backtracking(index: Int): Unit = {
      if (index == n) {
        if (result.length == n) {
          results.append(result.toList)
        }
        return
      }
      for (i <- 0 to n - 1) {
        var flag = true
        //for (j <- 0 to n - 1) {
        //  if (map(index)(j) == 'Q') flag = false
        //}
        for (j <- 0 to n - 1) {
          if (map(j)(i) == 'Q') flag = false
        }
        var x: Int = index
        var y: Int = i
        while (x < n && y < n) {
          if (map(x)(y) == 'Q') flag = false
          x += 1
          y += 1
        }
        x = index
        y = i
        while (x >= 0 && x < n && y >= 0 && y < n) {
          if (map(x)(y) == 'Q') flag = false
          x -= 1
          y -= 1
        }
        x = index
        y = i
        while (x >= 0 && x < n && y >= 0 && y < n) {
          if (map(x)(y) == 'Q') flag = false
          x += 1
          y -= 1
        }
        x = index
        y = i
        while (x >= 0 && x < n && y >= 0 && y < n) {
          if (map(x)(y) == 'Q') flag = false
          x -= 1
          y += 1
        }
        if (flag) {
          map(index)(i) = 'Q'
          result.append(map(index).mkString(""))
          backtracking(index + 1)
          map(index)(i) = '.'
          result.remove(result.length - 1)
        }
      }

    }
    backtracking(0)
    results.toList
  }

  def main(args: Array[String]): Unit = {
    println(n_queens(1))
    println(n_queens(2))
    println(n_queens(3))
    println(n_queens(4))
    println(n_queens1(1))
    println(n_queens1(2))
    println(n_queens1(3))
    println(n_queens1(4))
  }
}
