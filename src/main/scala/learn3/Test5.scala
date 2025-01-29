package learn3

object Test5 {
  def ransom(r: String, m: String): Unit = {
    var a = new Array[Int](26)
    for (i <- m.toCharArray) {
      a(i - 'a') += 1
    }
    var can = true
    for (i <- r.toCharArray) {
      a(i - 'a') -= 1
      if (a(i - 'a') < 0) can = false
    }
    println(can)
  }
  def main(args: Array[String]): Unit = {
    ransom("abc", "aab")
  }

}
