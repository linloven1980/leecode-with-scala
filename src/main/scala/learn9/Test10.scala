package learn9

object Test10 {
  def rebuild_heigh_queue(arr: Array[(Int, Int)]): Array[(Int, Int)] = {
    def fit_position(a: Array[(Int, Int)], pos: Int, item: (Int, Int)): Boolean = {
      if (pos == 0) {
        if (item._2 == 0) return true
        else return false
      } else {
        var cnt = 0
        for (i <- 0 to pos - 1) {
          if (a(i)._1 >= item._1) cnt += 1
        }
        if (cnt == item._2) return true
        else return false
      }
    }
    var result: Array[(Int, Int)] = Array.empty
    var tmp_result: Array[(Int, Int)] = new Array[(Int, Int)](arr.length)
    var occupied: Array[Int] = new Array[Int](arr.length)
    def backtracking(pos: Int): Unit = {
      if (pos == arr.length) {
        result = tmp_result.clone()
        return
      }
      for (i <- 0 to arr.length - 1) {
        if (occupied(i) == 0 && fit_position(tmp_result, pos, arr(i)) == true) {
          tmp_result(pos) = arr(i)
          occupied(i) = 1
          backtracking(pos + 1)
          occupied(i) = 0
        }
      }
    }
    backtracking(0)
    result
  }

  def rebuild_heigh_queue1(arr: Array[(Int, Int)]): Array[(Int, Int)] = {
    def cmp(a: (Int, Int), b: (Int, Int)): Boolean = {
      if (a._1 == b._1) return a._2 < b._2
      else return a._1 > b._1
    }
    var result: Array[(Int, Int)] = Array.empty
    var a = arr.sortWith(cmp)

    def insert(target: Array[(Int, Int)], item: (Int, Int)): Array[(Int, Int)] = {
      var (t1, t2) = target.splitAt(item._2)
      return t1 ++ Array[(Int, Int)](item) ++ t2
    }
    for (i <- 0 to a.length - 1) {
      result = insert(result, a(i))
    }

    result
  }

  def main(args: Array[String]): Unit = {
    println(rebuild_heigh_queue(Array[(Int, Int)]((7,0),(4,4),(7,1),(5,0),(6,1),(5,2))).mkString(""))
    println(rebuild_heigh_queue(Array[(Int, Int)]((6,0),(5,0),(4,0),(3,2),(2,2),(1,4))).mkString(""))
    println(rebuild_heigh_queue1(Array[(Int, Int)]((7,0),(4,4),(7,1),(5,0),(6,1),(5,2))).mkString(""))
    println(rebuild_heigh_queue1(Array[(Int, Int)]((6,0),(5,0),(4,0),(3,2),(2,2),(1,4))).mkString(""))
  }

}
