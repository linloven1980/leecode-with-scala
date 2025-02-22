package learn9

object Test12 {
  def remove_overlap(arr: Array[(Int, Int)]): Int = {
    var a = arr.sortBy(_._1)
    var result = 0
    var end = a(0)._2
    for (i <- 1 to a.length - 1) {
      if (a(i)._1 < end) {
        result += 1
        end = math.min(end, a(i)._2)
      } else {
        end = a(i)._2
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    println(remove_overlap(Array[(Int, Int)]((1,2), (2,3), (3,4), (1,3))))
    println(remove_overlap(Array[(Int, Int)]((1,2), (1,2), (1,2))))
    println(remove_overlap(Array[(Int, Int)]((1,2), (2,3))))
  }
}
