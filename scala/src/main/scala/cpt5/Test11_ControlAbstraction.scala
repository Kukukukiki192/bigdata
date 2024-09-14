package cpt5

//控制抽象
object Test11_ControlAbstraction {
  def main(args: Array[String]): Unit = {
    //1.传值参数
    def f0(): Int = {
      println("调用f0")
      12
    }

    def f1(a: Int): Unit = {
      println("a:" + a)
      println("a:" + a)
    }
    f1(23)
    f1(f0())  //a被12代替
    println("--------------")

    //2.传名参数 传递代码块(代码块=>Int代码块返回类型)
    //Java只有值调用 Scala既有值调用,又有名调用
    def f2(a: =>Int): Unit = {
      println("a:" + a)
      println("a:" + a) //出现2次a,调用2次f0()
    }
    f2(23)    //a被23代替
    f2(f0())  //a被f0()代替 把f0()调用的控制权限抽象成a
    f2({
      println("代码块")
      2  //Int返回值赋值给a
    })
  }

}
