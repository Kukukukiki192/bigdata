package cpt5

//高阶函数
object Test6_HighOrderFunc {
  def main(args: Array[String]): Unit = {
    def f(n: Int): Int = {
      println("调用f")
      n + 1
    }
    val r: Int = f(12)
    println(r)

    def ff(): Int = {
      println("调用ff")
      1
    }
    ff()
    ff
    println("-----------")

    //1.函数作为值传递
    val f1 = f _          //把函数当作整体
    val f2: Int=>Int = f  //明确指定当前变量类型是函数类型
    println(f1)
    println(f2)           //得到函数的引用地址

    val f3 = ff           //无参调用可省()
    val f4 = ff _
    val f5: ()=>Int = ff
    println(f3)
    println(f4)
    println(f5)
    println("-----------")


    //2.函数作为参数传递
    //定义二元运算函数 dual:二元的,双重的
    def dualEval(op: (Int, Int)=>Int, a: Int, b: Int): Int = {
      op(a, b)
    }
    def add(a: Int, b: Int): Int = {
      a + b
    }
//    val add = (a: Int, b: Int) => a + b
    println(dualEval(add, 1, 1))
    println(dualEval((a, b) => a + b, 1, 2))
    println(dualEval(_ + _, 1, 3))
    println("-----------")


    /**3.函数作为 函数返回值 返回
        def f6(): Int=>Unit = {
          def f7(a: Int): Unit = {
            println("调用f7 " + a)
          }
          f7    //明确指定返回类型 直接返回函数
        }
     */
    def f6() = {
      def f7(a: Int): Unit = {
        println("调用f7 " + a)
      }
      f7 _    //将函数作为整体返回
    }

    println(f6)       //返回函数地址
    println(f6())     //返回函数地址

    val f7 = f6()
    println(f7)       //返回函数地址
    println(f7(22))   //返回()
    println(f6()(22)) //=f7(22)
  }

}
