package learn8
import scala.collection.mutable.ListBuffer
object Test12 {
  def get_route(a: Array[(String, String)]): List[List[String]] = {
    var arr = a.sortBy(_._2)
    var result: ListBuffer[String] = ListBuffer.empty
    var results: ListBuffer[List[String]] = ListBuffer.empty
    var used: Array[Int] = new Array[Int](arr.length)
    var tmp_loc: String = null
    def backtracking(used: Array[Int]): Unit = {
      if (result.length == arr.length) {
        result.append(tmp_loc)
        results.append(result.toList)
        result.remove(result.length - 1)
        return
      }
      for (i <- 0 to arr.length - 1) {
        if (used(i) == 0) {
          if (result.length == 0 || tmp_loc == arr(i)._1) {
            result.append(arr(i)._1)
            tmp_loc = arr(i)._2
            used(i) = 1
            backtracking(used)
            result.remove(result.length - 1)
            tmp_loc = arr(i)._1
            used(i) = 0
          }
        }
      }
    }
    backtracking(used)
    results.toList
  }

  def main(args: Array[String]): Unit = {
    println(get_route(Array[(String, String)](("MUC", "LHR"), ("JFK", "MUC"), ("SFO", "SJC"), ("LHR", "SFO"))))
    println(get_route(Array[(String, String)](("JFK","SFO"), ("JFK","ATL"), ("SFO","ATL"), ("ATL","JFK"), ("ATL","SFO"))))
    println(get_route(Array[(String, String)](("JFK","KUL"), ("JFK","NRT"), ("NRT","JFK"))))
  }
}
