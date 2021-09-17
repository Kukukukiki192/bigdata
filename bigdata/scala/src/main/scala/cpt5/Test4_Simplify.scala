package cpt5

//函数至简原则
object Test4_Simplify {
  def main(args: Array[String]): Unit = {
    // 0.函数标准写法
    def f(s: String): String = {
      return s
    }
    println(f("0K"))
    // 至简原则:能省则省

    //1. return 可以省略，Scala 会使用函数体的最后一行代码作为返回值
    def f1(s: String): String = {
      s
    }
    println(f1("1K"))

    //2. 如果函数体只有一行代码，可以省略花括号
    def f2( s: String): String = s
    println(f2("2K"))

    //3. 返回值类型如果能够推断出来，那么可以省略（:和返回值类型一起省略）
    def f3(s: String) = s  //f(x)=x 标准函数声明 和数学上的函数表达一致
    println(f3("3K"))

    //4. 如果有 return，则不能省略返回值类型，必须指定
    def f4(s: String): String = {
      return s
    }
    println(f4("4K"))

    //5. 如果函数明确声明 unit，那么即使函数体中使用 return 关键字也不起作用
    def f5(s: String): Unit = {
      return s
    }
    println(f5("5K"))  //返回值()

    //6. Scala 如果期望是无返回值类型，可以省略等号
    def f6(s: String)  {
      println(s)
    }
    println(f6("6K"))

    //7. 如果函数无参，但是声明了参数列表，那么调用时，小括号，可加可不加
    def f7() = {
      println("7K")
    }
    println(f7())
    println(f7)

    //8. 如果函数没有参数列表，那么小括号可以省略，调用时小括号必须省略
    def f8 = {
      println("8K")
    }
    println(f8)

    //9. 如果不关心名称，只关心逻辑处理，那么函数名（def）可以省略
    def f9(s: String) = {
      println(s)
    }
    //匿名函数 Lambda表达式
    (s: String)=>{ println(s) }
//    def f9 = (x:String)=>{println("kk")}
//    def f10(f:String=>Unit) = {
//      f("")
//    }
//    f10(f9)
//    println(f10((x:String)=>{println("kk")}))
  }

}
