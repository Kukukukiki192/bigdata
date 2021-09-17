package cpt5

//自定义函数实现while
object Test12_MyWhile {
  def main(args: Array[String]): Unit = {
    //1.常规 while
    var n = 10
    while (n > 1) {
      println(n)
      n -= 1
    }


    //2.闭包实现一个函数,将代码块作为参数传入,递归调用
    def myWhile(condition: =>Boolean): (=>Unit) => Unit = { //返回值类型是函数类型(参数-代码块=>返回值)
      //内层函数递归调用,参数就是循环体
      def doLoop(op: =>Unit): Unit = {
        if(condition) {
          op
          myWhile(condition)(op)
        }
      }
      doLoop
    }

    n=20
    myWhile(n>10)(n-=1)   //闭包函数(条件)(操作)
    println(n)

    n = 30
    myWhile(n>20) {   //内层参数({})的()可省
      println(n)
      n -= 1
    }


    //3.用匿名函数实现 (化简步骤->Test8)
    def myWhile1(condition: =>Boolean): (=>Unit) => Unit = {
      (op) => {
        if(condition) {
          op
          myWhile(condition)(op)
        }
      }
    }


    //4.柯里化实现
    def myWhile2(condition: =>Boolean)(op: =>Unit): Unit = {
        if(condition) {
          op
          myWhile(condition)(op)
        }
    }
    n = 40
    myWhile(n>30) {
      println(n)
      n -= 1
    }
  }

}
