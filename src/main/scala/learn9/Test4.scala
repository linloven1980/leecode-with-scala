package learn9

object Test4 {
  def jump_game(arr: Array[Int]): Boolean = {
    var steps: Int = arr(0)
    var i: Int = 0
    while (steps > 0 && i <= arr.length - 1) {
      if (arr(i) > steps) steps = arr(i)
      i += 1
      steps -= 1

    }
    if (i == arr.length - 1) return true
    false
  }

  def main(args: Array[String]): Unit = {
    println(jump_game(Array[Int](2,3,1,1,4)))
    println(jump_game(Array[Int](3,2,1,0,4)))
  }
}
