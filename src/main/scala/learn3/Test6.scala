package learn3

import scala.collection.mutable
import scala.util.control.Breaks._
object Test6 {
  def threesum(a: Array[Int]): Unit = {
    var arr = a.sorted
    var l: List[List[Int]] = List.empty
    breakable{
      for (i <- 0 to arr.length - 1) {
        if (arr(i) > 0) break
        if (i > 0 && arr(i) == arr(i -1)) {

        } else {
          var set = mutable.HashSet[Int]()
          for (j <- i + 1 to arr.length -1) {
            if (j > i + 2 && arr(j) == arr(j-1) && arr(j-1) == arr(j-2)) {

            }else{
              var c = 0 - arr(i) - arr(j)
              if (set.contains(c)) {
                l = List(arr(i), c, arr(j)) :: l
                set.remove(c)
              }else {
                set.add(arr(j))
              }

            }
          }
        }
      }
    }

    println(l)

  }

  def threesum1(a: Array[Int]): Unit = {
    var arr = a.sorted
    var l: List[List[Int]] = List.empty
    var i, j, k = 0
    while (arr(i) <= 0) {
      j = i + 1
      k = arr.length - 1
      while (j < k) {
        if (arr(i) + arr(j) + arr(k) == 0) {
          l = List(arr(i), arr(j), arr(k)) :: l
          while (arr(j) == arr(j + 1)) j += 1
          j += 1
        }
        if (arr(i) + arr(j) + arr(k) > 0) {
          k -= 1
        }
        if (arr(i) + arr(j) + arr(k) < 0) {
          j += 1
        }
      }
      while (arr(i) == arr(i + 1)) i += 1
      i += 1

    }
    println(l)

  }

  def threesum2(a: Array[Int]): Unit = {
    var arr = a.sorted
    var r: List[List[Int]] = List.empty
    var i, j, k= 0
    while (arr(i) <= 0) {
      j = i + 1
      while (j < arr.length - 1) {
        k = j + 1
        breakable{
          while (k < arr.length) {
            if (arr(i) + arr(j) + arr(k) == 0) {
              r = List(arr(i), arr(j), arr(k)) :: r
              break()
            }
            if (arr(i) + arr(j) + arr(k) > 0) {
              break()
            }
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
    //threesum2(Array[Int](-7, -1, -1, -1, 0,0,0,0,0,1,1,1,2,8))
    threesum2(Array[Int](-3, -2, -2, -1, 0, 3, 4))
    threesum1(Array[Int](-3, -2, -2, -1, 0, 3, 4))
    threesum(Array[Int](-3, -2, -2, -1, 0, 3, 4))
  }

}
