package learn4

object Test {
  def reverse(s: String): Unit = {
    var a = s.toCharArray
    var i = 0
    var j = a.length - 1
    while (i <= j) {
      var tmp = a(i)
      a(i) = a(j)
      a(j) = tmp
      i += 1
      j -= 1
    }
    println(a.mkString(""))
  }
  def main(args: Array[String]): Unit = {
    reverse("hello")
  }
}
