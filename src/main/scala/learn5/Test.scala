package learn5

object Test {
  def remove(a: Array[Int], ele: Int): Unit = {
    var j = 0
    for (i <- 0 to a.length - 1) {
      if (a(i) != ele) {
        a(j) = a(i)
        j += 1
      }
    }
    println(a.mkString(""))
    println(j)
  }
  def main(args: Array[String]): Unit = {
    remove(Array[Int](3,2,2,3), 3)
    remove(Array[Int](0,1,2,2,3,0,4,2), 2)
  }

}
