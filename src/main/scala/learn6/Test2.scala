package learn6

import scala.collection.mutable.Stack

object Test2 {
  def validbrackets(str: String): Boolean = {
    val a = str.toCharArray
    val s: Stack[Int] = Stack.empty
    for (i <- 0 to a.length - 1) {
      if (a(i) == '(' || a(i) == '[' || a(i) == '{') {
        if (a(i) == '(') s.push(')')
        else if (a(i) == '[') s.push(']')
        else s.push('}')

      } else {
        if (s.isEmpty || s.pop() != a(i)) return false
      }
    }
    if (s.isEmpty) return true
    else return false
  }
  def main(args: Array[String]): Unit = {
    println(validbrackets("()"))
    println(validbrackets("()[]{}"))
    println(validbrackets("(]"))
    println(validbrackets("([)]"))
    println(validbrackets("{[]}"))
  }

}
