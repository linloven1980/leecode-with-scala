package learn9

object Test5 {
  def jump_game(arr: Array[Int]): Int = {
    var jump_count: Int = 0
    var begin: Int = 0
    var next_begin: Int = 0
    var end: Int = arr(0)
    while (end < arr.length - 1) {
      begin = next_begin
      next_begin = end + 1
      jump_count += 1
      for (i <- begin to end) {
        if (i + arr(i) > end) end = i + arr(i)
      }

    }
    jump_count + 1
  }

  def main(args: Array[String]): Unit = {
    println(jump_game(Array[Int](2,3,1,1,4)))
  }

}
