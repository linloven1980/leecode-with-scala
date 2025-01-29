package learn1

object Test3 {
  def search(a: Array[Int]): Array[Int] = {
    val at = new Array[Int](a.length)
    var len = a.length - 1
    var l = 0
    var r = a.length - 1
    var lval = a(l) * a(l)
    var rval = a(r) * a(r)
    while (len >= 0) {
      if (lval >= rval) {
        at(len) = lval
        l += 1
        lval = a(l) * a(l)
      } else {
        at(len) = rval
        r -= 1
        rval = a(r) * a(r)
      }
      len -= 1
    }
    at
  }

  def main(args: Array[String]): Unit = {
    val a = Array(-6, -4, -3, -1, 0, 2, 3, 4, 6, 7)
    val at = search(a)
    println(at.mkString(","))
  }

}
