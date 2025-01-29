package learn6
import scala.collection.mutable.Queue
object Test1 {
  class Stackbyqueue {
    val queue: Queue[Int] = Queue.empty
    def push(value: Int): Unit = {
      queue.enqueue(value)
    }
    def pop(): Int = {
      if (queue.isEmpty) throw new Exception("stack is empty")
      for (i <- 1 to queue.size - 1) queue.enqueue(queue.dequeue())
      return queue.dequeue()
    }
    def top(): Int = {
      val value = pop()
      push(value)
      value
    }
    def empty(): Boolean = {
      return queue.isEmpty
    }
  }

  def main(args: Array[String]): Unit = {
    val sbq = new Stackbyqueue()
    sbq.push(1)
    sbq.push(2)
    sbq.push(3)
    println(sbq.pop)
    println(sbq.top)
    println(sbq.pop)
    println(sbq.pop)
    println(sbq.empty())
  }

}
