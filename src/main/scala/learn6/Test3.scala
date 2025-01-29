package learn6

object Test3 {
  def removeduplicate(str: String): String = {
    val a = str.toCharArray
    val s = new Array[Char](a.length)
    var j = -1
    for (i <- 0 to a.length - 1) {
      if (j == -1) {
        s(0) = a(i)
        j = 0
      } else {
        if (s(j) == a(i)) {
          s(j) = '\u0000'
          j -= 1
        } else {
          j += 1
          s(j) = a(i)
        }
      }
    }
    s.mkString("")
  }
  def main(args: Array[String]): Unit = {
    println(removeduplicate("abbaca"))
  }

}
