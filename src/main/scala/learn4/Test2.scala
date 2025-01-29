package learn4

object Test2 {
  def replacenum(s: String): Unit = {
    var a = s.toCharArray
    var numcount = 0
    for (c <- a) {
      if (c >= '0' && c <= '9')  numcount += 1
    }
    var arr = new Array[Char](a.length + numcount * 5)
    var i = a.length - 1
    var j = arr.length - 1
    while (i >= 0) {
      if (a(i) >= '0' && a(i) <= '9') {
        arr(j) = 'r'
        arr(j-1) = 'e'
        arr(j-2) = 'b'
        arr(j-3) = 'm'
        arr(j-4) = 'u'
        arr(j-5) = 'n'
        j -= 5
      }else {
        arr(j) = a(i)
      }
      i -= 1
      j -= 1
    }
    println(arr.mkString(""))

  }
  def main(args: Array[String]): Unit = {
    replacenum("a5b5c")

  }

}
