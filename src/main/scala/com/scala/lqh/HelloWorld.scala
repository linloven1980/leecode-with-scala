package com.scala.lqh

object HelloWorld extends App {
   val test: PartialFunction[String, String] = {
     case "abc"  => "123"
   }
}
