package learn3

object Test {
  def checkword(s: String, t: String): Unit = {
    var a = new Array[Int](26)
    for (c <- s.toCharArray) {
      a(c - 'a') += 1
    }
    for (c <- t.toCharArray) {
      a(c - 'a') -= 1
    }
    var finddiff = false
    for (c <- a) {
      if (c != 0) finddiff = true
    }
    println(finddiff)
  }
  def main(args: Array[String]): Unit = {
    checkword("aabcd", "bacdb")
  }

}
