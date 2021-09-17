package cpt5

//传递匿名函数至简原则
object Test5_Lambda {
  def main(args: Array[String]): Unit = {
    /** 标准函数
        def f(s: String) = {
          println(s)
        }
        匿名函数
        (x:Int)=>{函数体}
     */

    val fun = (s: String) => {println(s + " 1")}
    def fun1 = (s: String) => {println(s + " 1")}
    //实际是以 String 作为参数类型、Unit作为返回值类型 的函数类型
    val stringToUnit: String => Unit = (s: String) => {println(s)}
    val fun2 = stringToUnit
    fun("kk")

    //定义函数,以函数作为参数
    def f(func: String => Unit): Unit = {
      func("传参")    //传参操作由函数定义
    }
    f(fun)    //只需传函数名
    println(f((x:String)=>{println(x + " 2")}))
    println("-----------")


    //匿名函数简化 (x:String)=>{println(x)}
    //1.参数的类型可以省略,会根据形参进行自动的推导
    f((x) => {
      println(x)
    })
    //2.类型省略之后,发现只有一个参数,则圆括号可以省略 其他情况:没有参数和参数超过1的永远不能省略圆括号
    f( x => {
      println(x)
    })
    //3.匿名函数如果只有一行,则大括号也可以省略
    f( x => println(x))
    //4.如果参数只出现一次,则参数省略且后面参数可以用_代替
    f( println(_))
    //5.若可推断出当前传入的println是一个函数体,而不是调用语句,可直接省略_
    f( println )
    println("-----------")


    //eg.二元运算 具体运算传参
    def op(f: (Int, Int) => Int): Int = {
      f(1, 2)
    }
    val add = (a: Int, b: Int) => a + b
    val sub = (a: Int, b: Int) => a - b
    println(op(add))
    println(op(sub))
    //化简
    println(op((a: Int, b: Int) => a + b))
    println(op((a, b) => a + b))
    println(op(_ + _))
    println(op((a, b) => b - a))
    println(op(-_ + _)) // -a+b
  }

}
