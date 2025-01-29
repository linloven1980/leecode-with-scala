package learn5

object Test9 {
  def threesum(a: Array[Int]): List[List[Int]] = {
    var arr = a.sorted
    var result: List[List[Int]] = List.empty
    for(i <- 0 to arr.length - 3) {
      if (i == 0 || i > 0 && arr(i) != arr(i - 1)) {
        var l = i + 1
        var r = a.length - 1
        while (l < r) {
          if (arr(i) + arr(l) + arr(r) == 0) {
            result = List(arr(i), arr(l), arr(r)) :: result
            println(result)
            while (arr(l) == arr(l + 1)) l += 1
            l += 1
            while (arr(r) == arr(r - 1)) r -= 1
            r -= 1
          } else if (arr(i) + arr(l) + arr(r) > 0) {
            while (arr(r) == arr(r - 1)) r -= 1
            r -= 1
          } else {
            while (arr(l) == arr(l + 1)) l += 1
            l += 1
          }
        }
      }


    }
    result
  }
  def main(args: Array[String]): Unit = {
    println(threesum(Array[Int](-1, 0, 1, 2, -1, -4)))
  }
}
