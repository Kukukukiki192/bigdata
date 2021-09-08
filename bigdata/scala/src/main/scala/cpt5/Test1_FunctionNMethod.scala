package cpt5

//带序号的是函数和方法的区别
object Test1_FunctionNMethod {
  // 2.方法可重载和重写,程序可执行
  def main(): Unit = {
  }

  def main(args: Array[String]): Unit = {
    // 1.Scala可在任何语法结构中声明任何语法
    import java.util.Date
    new Date()

    // 2.函数没有重载和重写的概念,程序报错
//    def test(): Unit ={
//      println("无参，无返回值")
//    }
//    def test(name:String):Unit={
//      println()
//    }

    // 3.Scala中函数可嵌套定义
    def test2(): Unit = {
      def test3(name: String): Unit = {
        println("函数可以嵌套定义")
      }
    }
    def factorial(i: Int): Int = {
      def fact(i: Int, accumulator: Int): Int = {
        if (i <= 1)
          accumulator
        else
          fact(i - 1, i * accumulator)
      }
      fact(i, 1)
    }
    println( factorial(0) ) //1
    println( factorial(1) ) //1
    println( factorial(2) ) //2
    println( factorial(3) ) //6


    //定义函数
    def sayHi(name: String): Unit = {
      println("hi "+name)
    }
    //调用函数
    sayHi("K")

    //调用对象方法
    Test1_FunctionNMethod.sayHi("KK")

    val r: String = sayHello("A") //若方法在别的程序中要像上面基于对象调用
    println(r)
  }

  //定义对象方法  (定义在类/对象object中,不能直接放在方法中)
  def sayHi(name: String): Unit = {
    println("Hi "+name)
  }

  def sayHello(name: String): String = {
//    return "Hello " + name
    "Hello " + name
  }

}
