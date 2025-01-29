package learn6

import scala.collection.mutable.Stack

object Test {
  class Queuebystack() {
    val input: Stack[Int] = Stack.empty
    val output: Stack[Int] = Stack.empty

    def push(value: Int): Unit = {
      input.push(value)
    }

    def pop(): Int = {
      if (!output.isEmpty) {
        return output.pop
      } else {
        while (!input.isEmpty) {
          output.push(input.pop())
        }
        if (!output.isEmpty){
          return output.pop()
        }else {
          throw new Exception("queue is empty")
        }

      }
    }

    def peek(): Int = {
      val value = pop()
      output.push(value)
      value
    }

    def empty(): Boolean = {
      return input.isEmpty && output.isEmpty
    }


  }

  def main(args: Array[String]): Unit = {
    val qbs = new Queuebystack()
    qbs.push(1)
    qbs.push(2)
    qbs.push(3)
    println(qbs.empty())
    println(qbs.pop())
    println(qbs.peek())
    println(qbs.pop())
    println(qbs.pop())
    //println(qbs.pop())
    println(qbs.empty())
  }
}
