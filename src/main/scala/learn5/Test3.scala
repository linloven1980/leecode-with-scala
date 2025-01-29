package learn5

object Test3 {
  def replace(s: String): Unit = {
    var a = s.toCharArray
    var count = 0
    for (i <- 0 to a.length -1) {
      if (a(i) >= '0' && a(i) <= '9') {
        count += 1
      }
    }
    var arr = new Array[Char](s.length - count + count * 6)
    var j = arr.length - 1
    for (i <- a.length - 1 to 0 by -1) {
      if (a(i) >= '0' && a(i) <= '9') {
        arr(j) = 'r'
        arr(j - 1) = 'e'
        arr(j - 2) = 'b'
        arr(j - 3) = 'm'
        arr(j - 4) = 'u'
        arr(j - 5) = 'n'
        j -= 6
      }else {
        arr(j) = a(i)
        j -= 1
      }
    }
    println(arr.mkString(","))
  }
  def main(args: Array[String]): Unit = {
    replace("a1b2c3")
  }

}
