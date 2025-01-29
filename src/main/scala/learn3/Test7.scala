package learn3

import scala.util.control.Breaks._
object Test7 {
  def foursum(a: Array[Int], target: Int): Unit = {
    var arr = a.sorted
    var r: List[List[Int]] = List.empty
    var i, j, k, l = 0
    while (i <= arr.length - 4) {
      j = i + 1
      while (j <= arr.length - 3) {
        k = j + 1
        while (k <= arr.length - 2) {
          l = k + 1
          breakable{
            while (l <= arr.length - 1) {
              if (arr(i) + arr(j) + arr(k) + arr(l) == target) {
                r = List(arr(i), arr(j), arr(k), arr(l)) :: r
                break
              }
              if (arr(i) + arr(j) + arr(k) + arr(l) > target) {
                break
              }
              l += 1
            }
          }
          while (arr(k) == arr(k + 1)) k += 1
          k += 1

        }
        while (arr(j) == arr(j + 1)) j += 1
        j += 1
      }
      while (arr(i) == arr(i + 1)) i += 1
      i += 1
    }
    println(r)
  }

  def foursum1(a: Array[Int], target: Int): Unit = {
    var arr = a.sorted
    var r: List[List[Int]] = List.empty
    var i, j, k, l = 0
    while (i <= arr.length - 4) {
      j = i + 1
      while (j <= arr.length - 3) {
        k = j + 1
        l = arr.length - 1
        while (k < l) {
          if (arr(i) + arr(j) + arr(k) + arr(l) == target) {
            r = List(arr(i), arr(j), arr(k), arr(l)) :: r
            while (arr(k) == arr(k + 1)) k += 1
            k += 1
          }
          if (arr(i) + arr(j) + arr(k) + arr(l) > target) {
            l -= 1
          }
          if (arr(i) + arr(j) + arr(k) + arr(l) < target) {
            k += 1
          }
        }
        while (arr(j) == arr(j + 1)) j += 1
        j += 1
      }
      while (arr(i) == arr(i + 1)) i += 1
      i += 1

    }
    println(r)
  }
  def main(args: Array[String]): Unit = {
    foursum(Array[Int](1, 1, 1, 0, 0, 0, -1, -1, -1, 0, -2, 2), 0)
    foursum1(Array[Int](1, 1, 1, 0, 0, 0, -1, -1, -1, 0, -2, 2), 0)
  }

}
