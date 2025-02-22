package learn9

object Test11 {
  def shoot_balloon(arr: Array[(Int, Int)]): Int = {
    if (arr.length == 1) return 1
    var a = arr.sortBy(_._1)
    var result = 1
    var end = a(0)._2
    for (i <- 1 to a.length - 1) {
      if (a(i)._1 > end) {
        result += 1
        end = a(i)._2
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    println(shoot_balloon(Array[(Int, Int)]((10,16),(2,8),(1,6),(7,12))))
    println(shoot_balloon(Array[(Int, Int)]((1,2),(3,4),(5,6),(7,8))))
    println(shoot_balloon(Array[(Int, Int)]((1,2),(2,3),(3,4),(4,5))))
    println(shoot_balloon(Array[(Int, Int)]((1,2))))
    println(shoot_balloon(Array[(Int, Int)]((2,3),(2,3))))
  }
}
