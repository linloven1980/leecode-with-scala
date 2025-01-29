package learn1

object Test5 {
  def search(n: Int):Unit = {
    var begin = 0
    var len = n - 1
    var i = 1
    val a = Array.ofDim[Int](n, n)
    while (i <= n*n) {
      var x = begin
      for (y <- begin to begin + len - 1) {
        a(x)(y) = i
        i += 1
      }
      var y = begin + len
      for (x <- begin to begin + len -1) {
        a(x)(y) = i
        i += 1
      }
      x = begin + len
      for (y <- begin + len to begin + 1 by -1) {
        a(x)(y) = i
        i += 1
      }
      y = begin
      for (x <- begin + len to begin + 1 by -1) {
        a(x)(y) = i
        i += 1
      }

      begin += 1
      len -= 2
      if (i == n*n) {
        if (i == 1) {
          a(0)(0) = i
          i += 1
        }
        else {
          a(begin)(begin) = i
          i += 1
        }
      }

    }
    a.foreach(a1 => {a1.foreach(a2 => {print(a2)
    print(",")})
    println})
  }

  def main(args: Array[String]): Unit = {
    search(5)
  }
}
