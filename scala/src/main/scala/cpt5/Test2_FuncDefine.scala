package cpt5

//函数定义
object Test2_FuncDefine {
  def main(args: Array[String]): Unit = {
    //（1）函数 1：无参，无返回值
    def f1(): Unit = {
      println("1 无参 无返回值")
    }
    println(f1())
    println("------------------")

    //（2）函数 2：无参，有返回值
    def f2(): String = {
      "2 无参 有返回值"
    }
    println(f2())
    println("------------------")

    //（3）函数 3：有参，无返回值
    def f3(s: String): Unit = {
      println(s)
    }
    println(f3("3 有参 无返回值"))
    println("------------------")

    //（4）函数 4：有参，有返回值
    def f4(s: String): String = {
      s
    }
    println(f4("4 有参 有返回值"))
    println("------------------")

    //（5）函数 5：多参，无返回值
    def f5(name: String, age: Int): Unit = {
      println(s"${name}, ${age}")
    }
    println(f5("KK",21))
    println("------------------")

    //（6）函数 6：多参，有返回值
    def f6(a: Int, b: Int): Int = {
      a+b
    }
    println(f6(1,2))

  }

}
