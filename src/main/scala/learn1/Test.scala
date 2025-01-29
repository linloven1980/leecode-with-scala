package learn1

object Test {
    def search(l: Array[Int], target: Int): Int = {
      var left = 0
      var right = l.length - 1

      while (left <= right) {
        val mid = (left + right) / 2
        if (l(mid) > target) {
          right = mid - 1
        } else if (l(mid) < target) {
          left = mid + 1
        } else {
          return mid
        }
      }
      -1
    }

  def main(args: Array[String]): Unit = {
     val l = Array(1,3, 4, 7, 9, 10)
     val target = search(l, 6)
     println(target)
  }

}
