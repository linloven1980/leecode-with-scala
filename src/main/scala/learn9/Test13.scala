package learn9
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks._
object Test13 {
  def split_space(s: String): List[Int] = {
    var a = s.toCharArray
    def get_space(begin: Int): Int = {
      var end = a.length - 1
      while (a(end) != a(begin)) {
        end -= 1
      }
      var i = begin
      while (i <= end) {
        breakable{
          for (j <- a.length - 1 to end by -1) {
            if (a(i) == a(j)) {
              end = j
              break
            }
          }
        }
        i += 1

      }
      end
    }
    var begin = 0
    var result: ListBuffer[Int] = ListBuffer.empty
    while (begin <= a.length - 1) {
      var end = get_space(begin)
      result.append(end - begin + 1)
      begin = end + 1
    }
    result.toList
  }

  def split_space1(s: String): List[Int] = {
    var a = s.toCharArray
    var boundary: Array[Int] = new Array[Int](26)
    var result: ListBuffer[Int] = ListBuffer.empty
    for (i <- 0 to a.length - 1) {
      boundary(a(i) - 'a') = i
    }
    var begin = 0
    var end = boundary(a(0) - 'a')
    breakable{
      for (i <- 0 to a.length - 1) {
        if (i == end) {
          result.append(end - begin + 1)
          if (i == a.length - 1) break()
          else {
            begin = i + 1
            end = boundary(a(begin) - 'a')
          }
        } else {
          if (boundary(a(i) - 'a') > end) end = boundary(a(i) - 'a')
        }
      }
    }
    result.toList
  }

  def main(args: Array[String]): Unit = {
    println(split_space("ababcbacadefegdehijhklij"))
    println(split_space1("ababcbacadefegdehijhklij"))
  }
}
