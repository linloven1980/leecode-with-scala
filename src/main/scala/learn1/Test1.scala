package learn1

object Test1 {
  def search(a: Array[Int], target: Int): Int = {
    var f = 0
    var s = 0
    while (f < a.length) {
      if (a(f) != target) {
        a(s) = a(f)
        s += 1
      }
      f += 1
    }
    s
  }

  def main(args: Array[String]): Unit = {
    val a = Array(1,2,3,4,2,4,5,2,2)
    val l = search(a, 2)
    println(l)
    println(a.mkString(","))
  }

}
