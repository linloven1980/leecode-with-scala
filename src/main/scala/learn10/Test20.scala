package learn10

object Test20 {
  def split_words(s: String, arr: Array[String]): Boolean = {

    var result = false
    def backtracking(index: Int): Unit = {
      if (index == s.length) {
        result = true
        return
      }

      for (i <- 0 to arr.length - 1) {
        if (s.substring(index).startsWith(arr(i))) {
          backtracking(index + arr(i).length)
        }
      }
    }
    backtracking(0)
    result
  }

  def split_words1(s: String, arr: Array[String]): Boolean = {
    val s1 = " " + s
    var dp: Array[Boolean] = Array.fill[Boolean](s1.length)(false)
    dp(0) = true

    for (j <- 1 to s1.length - 1) {
      for (i <- j to 1 by -1) {
        val word = s1.substring(i, j + 1)
        if (arr.contains(word) == true && dp(i - 1) == true) dp(j) = true
      }
    }
    dp(s1.length - 1)
  }

  def main(args: Array[String]): Unit = {
    println(split_words("leetcode", Array[String]("leet", "code")))
    println(split_words("applepenapple", Array[String]("apple", "pen")))
    println(split_words("catsandog", Array[String]("cats", "dog", "sand", "and", "cat")))
    println(split_words1("leetcode", Array[String]("leet", "code")))
    println(split_words1("applepenapple", Array[String]("apple", "pen")))
    println(split_words1("catsandog", Array[String]("cats", "dog", "sand", "and", "cat")))

  }
}
