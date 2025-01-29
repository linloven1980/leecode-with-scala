package learn6

import scala.collection.mutable

object Test6 {
  def topkfreq(a: Array[Int], k: Int): List[Int] = {
    val m = mutable.HashMap[Int, Int]()
    var l: List[Int] = List.empty
    for (i <- 0 to a.length - 1) {
      if (m.contains(a(i))) {
        m(a(i)) = m(a(i)) + 1
      }else {
        m(a(i)) = 1
      }
    }
    val pq = mutable.PriorityQueue[(Int, Int)]()(Ordering.by[(Int, Int), Int](_._2).reverse)

    for (e <- m) {
      pq.enqueue(e)
    }
    for ( i <- 1 to m.size - k) pq.dequeue()
    for (i <- 1 to k) l = pq.dequeue()._1 :: l
    l
  }

  def main(args: Array[String]): Unit = {
    println(topkfreq(Array[Int](1,1,1,2,2,3), 2))
  }

}
