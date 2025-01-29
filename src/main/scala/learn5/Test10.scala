package learn5

object Test10 {
  def foursum(a: Array[Int], target: Int): List[List[Int]] = {
    var arr = a.sorted
    var result: List[List[Int]] = List.empty
    for (i <- 0 to arr.length - 4){
      if(i == 0 || i > 0 && arr(i) != arr(i - 1)) {
        for (j <- i + 1 to arr.length - 3) {
          if (arr(j) != arr(j - 1)) {
            var l = j + 1
            var r = arr.length - 1
            while (l < r) {
              if (arr(i) + arr(j) + arr(l) + arr(r) == target) {
                result = List(arr(i), arr(j), arr(l), arr(r)) :: result
                while (arr(l) == arr(l + 1)) l += 1
                l += 1
                while (arr(r) == arr(r - 1)) r -= 1
                r -= 1
              }else if (arr(i) + arr(j) + arr(l) + arr(r) > target){
                while (arr(r) == arr(r - 1)) r -= 1
                r -= 1
              }else {
                while (arr(l) == arr(l + 1)) l += 1
                l += 1
              }
            }
          }

        }
      }
    }
    result
  }
  def main(args: Array[String]): Unit = {
    println(foursum(Array[Int](1, 0, -1, 0, -2, 2), 0))
  }

}
