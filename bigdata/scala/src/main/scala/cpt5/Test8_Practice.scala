package cpt5

//匿名函数练习
object Test8_Practice {
  def main(args: Array[String]): Unit = {
    /**1.定义一个匿名函数，并将它作为值赋给变量 fun。函数有三个参数，
     * 类型分别为 Int ，String ，Char ，返回值类型为 Boolean。
     * 要求调用函数 fun(0, “”, ‘0’)得到返回值为 false ，其它情况均返回 true
     */
    val fun = (a: Int, b: String, c: Char) => {
      if(a == 0 && b == "" && c == '0') false else true
    }
    println(fun(0, "", '0'))
    println(fun(3, "", '0'))


    /**2.定义一个函数 func ，它接收一个 Int 类型的参数，返回一个函数（记作 f1 ）。
     * 它返回的函数 f1 ，接收一个 String 类型的参数，同样返回一个函数（记作 f2 ）。
     * 函数 f2接 收一个 Char 类型的参数，返回一个 Boolean 的值。
     * 要求调用函数 func(0) (“”) (‘0’)得到返回值为 false ，其它情况均返回 true。
     *  def func(n: Int): String => (Char => Boolean) = {
          def f1(s: String): Char => Boolean = {
            def f2(c: Char): Boolean = {
              if(n == 0 && s == "" && c == '0') false else true
            }
            f2
          }
          f1
        }
     */
    def func(n: Int) = {
      def f1(s: String) = {
        def f2(c: Char) = {
          if(n == 0 && s == "" && c == '0') false else true
        }
        f2 _
      }
      f1 _
    }
    println(func(0)("")('0'))

    //匿名函数简写
    //1.去掉函数名、返回类型 加箭头=>
    def func1(n: Int): String => ( Char => Boolean ) = {
      (s: String) => {
        (c: Char) => {
          if(n == 0 && s == "" && c == '0') false else true
        }
      }
    }
    //2.形参类型已确定 省略参数类型
    def func2(n: Int): String => ( Char => Boolean ) = {
      (s) => {
        (c) => {
          if(n == 0 && s == "" && c == '0') false else true
        }
      }
    }
    //3.只有1个参数 省略()
    def func3(n: Int): String => ( Char => Boolean ) = {
      s => {
        c => {
          if(n == 0 && s == "" && c == '0') false else true
        }
      }
    }
    //4.只有1行代码 省略{}
    def func4(n: Int): String => ( Char => Boolean ) = {
      s => c => if(n == 0 && s == "" && c == '0') false else true
    }
    println(func4(0)("")('0'))
    println(func4(0)("hi")('0'))

    //柯里化
    def func5(n: Int)(s: String)(c: Char): Boolean = {
      if(n == 0 && s == "" && c == '0') false else true
    }
    println(func5(0)("")('0'))
    println(func5(0)("hi")('0'))

  }

}
