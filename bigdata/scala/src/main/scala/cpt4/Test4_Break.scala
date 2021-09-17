package cpt4

import scala.util.control.Breaks
import scala.util.control.Breaks._ //引入类下的所有属性、方法

object Test4_Break {
  def main(args: Array[String]): Unit = {
    //本质：用异常实现循环中断
    try {
      for(i<-0 until 5) {
        if(i==3)
          throw new RuntimeException()
        println(i)
      }
    } catch {
      case e: Exception => //do nothing 仅退出循环
    }

    //用Breaks类的封装方法
    Breaks.breakable(
      for(i<-0 until 5) {
        if(i==3)
          Breaks.break()
        println(i)
      }
    )

    //简化
    breakable(
      for(i<-0 until 5) {
        if(i==3)
          break()
        println(i)
      }
    )

  }

}
