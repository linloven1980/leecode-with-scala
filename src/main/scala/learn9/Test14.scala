package learn9

import scala.collection.mutable.ListBuffer

object Test14 {
  def merge_space(arr: Array[(Int, Int)]): List[(Int, Int)] = {
    if (arr.length == 1) return List[(Int, Int)](arr(0))
    var a = arr.sortBy(_._1)
    var result: ListBuffer[(Int, Int)] = ListBuffer.empty
    var begin = a(0)._1
    var end = a(0)._2
    for (i <- 1 to a.length - 1) {
      if (a(i)._1 <= end) {
        end = math.max(end, a(i)._2)
      } else {
        result.append((begin, end))
        begin = a(i)._1
        end = a(i)._2
      }
    }
    result.append((begin, end))
    result.toList
  }

  def main(args: Array[String]): Unit = {
    println(merge_space(Array[(Int, Int)]((1,3),(2,6),(8,10),(15,18))))
    println(merge_space(Array[(Int, Int)]((1,4),(4,5))))
  }

}
