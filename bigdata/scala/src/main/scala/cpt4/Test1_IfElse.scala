package cpt4

import scala.io.StdIn

object Test1_IfElse {

  def main(args: Array[String]): Unit = {
    println("input age:")
    var age = StdIn.readInt()

    //单/双/多分支
    if(age<18) {
      println("未成年")
    } else if(age>=18 && age<50) {
      println("成年人")
    } else {
      println("老年人")
    }


    //分支语句的返回值->用当前代码块最后一行表达式的值作为返回值
    var r1: String = if(age<18) {
      "未成年"
    } else if(age>=18 && age<50) {
      "成年人"
    } else {
      "老年人"
    }
    println(r1)


    //返回值类型不同,取共同父类型
    var r2: Any = if(age<18) {
      "未成年"
    } else if(age>=18 && age<50) {
      "成年人"
    } else {
      100
    }
    println(r2)


    //实现Java中的三元运算符
    //Java: int r = a?b:c;
    var r3: Any = if(age<18) "未成年" else "成年人"
    println(r3)


    //嵌套分支 不要超过3层
    var r4: String = if(age<18) {
      "未成年"
    } else {
      if (age >= 18 && age < 50) {
        "成年人"
      } else {
        "老年人"
      }
    }
    println(r4)


    // Scala无Switch分支->用模式匹配处理
  }

}
