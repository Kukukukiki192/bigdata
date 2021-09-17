package cpt2

import scala.io.StdIn

//标准输入
object Test4_StdIn {
  def main(args: Array[String]): Unit = {
    //键盘输入
    println("please input ur name: ")
    val name = StdIn.readLine()
    println("please input ur age: ")
    val age = StdIn.readInt()
    //打印
    print(s"Welcome ${age}-year-old ${name} to study!")
  }
}
