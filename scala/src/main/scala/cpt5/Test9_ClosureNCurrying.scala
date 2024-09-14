package cpt5

/**闭包 如果一个函数,访问到了它的外部(局部)变量的值,则该函数和他所处的环境,称为闭包
 * 函数柯里化  把一个参数列表的多个参数,变成多个参数列表
 */
object Test9_ClosureNCurrying {
  def main(args: Array[String]): Unit = {
    def add(a: Int, b: Int): Int = {
      a + b
    }

    //1.固定一个加数
    def addByFour(b: Int): Int = {
      4 + b
    }

    //2.扩展固定加数改变的情况
    def addByFive(b: Int): Int = {
      5 + b
    }

    //3.将固定参数作为另一个参数("第1层参数")传入
    def addByFour1(): Int=>Int = {
      val a = 4
      def addB(b: Int): Int = {
        a + b
      }
      addB
    }

    def addByA(a: Int): Int=>Int = {
      def addB(b: Int): Int = {
        a + b
      }
      addB
    }
    println(addByA(2)(24))

    val addByFour2 = addByA(4)
    val addByFive2 = addByA(5)
    println(addByFour2(13))   //=addByA(4)(13)
    println(addByFive2(12))   //=addByA(5)(12)


    //4.Lambda表达式简写
    def addByA1(a: Int): Int=>Int = {
      (b: Int) => {
        a + b
      }
    }
    def addByA2(a: Int): Int=>Int = {
      b => a + b
    }
    def addByA3(a: Int): Int=>Int =  a + _

    val addByFour3 = addByA3(4)
    val addByFive3 = addByA3(5)
    println(addByFour3(11))   //=addByA3(4)(11)
    println(addByFive3(11))   //=addByA3(5)(11)


    //5.柯里化
    def addCurring(a: Int)(b: Int): Int = a + b
    println(addCurring(35)(24))

  }

}
