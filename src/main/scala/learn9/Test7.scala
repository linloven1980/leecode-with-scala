package learn9

import scala.util.control.Breaks._
object Test7 {
  def gas_station(gas: Array[Int], cost: Array[Int]): Int = {
    var result = -1
    breakable{
      for (begin <- 0 to gas.length - 1) {
        var i: Int = begin
        var stops = 1
        var gas_vol = gas(i)
        breakable{
          while (stops <= gas.length) {
            if (gas_vol < cost(i)) break()
            else {
              gas_vol -= cost(i)
              i += 1
              if (i == gas.length) i = 0
              gas_vol += gas(i)
              stops += 1
            }
          }
        }
        if (stops == gas.length + 1) {
          result = i
          break
        }

      }
    }

    result
  }
  def gas_station1(gas: Array[Int], cost: Array[Int]): Int = {
    var sum: Int = 0
    var lowest: Int = Int.MaxValue
    var lowest_index: Int = 0
    for (i <- 0 to gas.length - 1) {
      sum += gas(i) - cost(i)
      if (sum < lowest) {
        lowest = sum
        if (lowest < 0) lowest_index = i + 1
      }

    }
    if (sum < 0) return -1
    else return lowest_index
  }
  def gas_station2(gas: Array[Int], cost: Array[Int]): Int = {
    var sum: Int = 0
    var result = 0
    var sub_sum = 0
    for (i <- 0 to gas.length - 1) {
      sum += gas(i) - cost(i)
      sub_sum += gas(i) - cost(i)
      if (sub_sum < 0) {
        result = i + 1
        sub_sum = 0
      }
    }
    if (sum < 0) return -1
    result
  }
  def main(args: Array[String]): Unit = {
    println(gas_station(Array[Int](1,2,3,4,5), Array[Int](3,4,5,1,2)))
    println(gas_station(Array[Int](2,3,4), Array[Int](3,4,3)))
    println(gas_station1(Array[Int](1,2,3,4,5), Array[Int](3,4,5,1,2)))
    println(gas_station1(Array[Int](2,3,4), Array[Int](3,4,3)))
    println(gas_station2(Array[Int](1,2,3,4,5), Array[Int](3,4,5,1,2)))
    println(gas_station2(Array[Int](2,3,4), Array[Int](3,4,3)))
  }

}
