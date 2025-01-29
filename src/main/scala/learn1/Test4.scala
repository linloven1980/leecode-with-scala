package learn1

object Test4 {
    def search(a: Array[Int], target: Int): Int = {
      var sum = 0
      var len = 9999
      for(i <- 0 to a.length - 1) {

        var j = i
        while (j < a.length && sum < target) {
          sum += a(j)
          if (sum >= target) {
            var len1 = j - i + 1
            if (len1 < len) {
              len = len1
            }
          }
          j += 1
        }
        sum = 0
      }
      len
    }

  def search1(a: Array[Int], target: Int): Int = {
    var sum = 0
    var j = 0
    var len = 9999

    for (i <- 0 to a.length-1) {
      var len1 = 0
      sum += a(i)

      if (sum > target) {
        while (j <= i && sum >= target) {
          sum -= a(j)
          j += 1
        }
        len1 = i - j + 2

        if (len1 < len) {
          len = len1
        }
      }
    }
    len
  }

  def main(args: Array[String]): Unit = {
    val a: Array[Int] = Array(2,3,1,2,4,3, 7)
    val len = search(a, 39)
    println(len)
    val len1 = search1(a, 39)
    println(len1)
  }
}
