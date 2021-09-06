package cpt3

object Test1_Operator {

  def main(args: Array[String]): Unit = {
    //1.算数运算符
    val a1: Int = 10/3
    println(a1)

    val a2: Double = 10/3
    println(a2)

    val a3: Double = 10.0/3
    println(a3)
    println(a3.formatted("%5.2f"))  //字符串长度为5,不足补空格,保留2位小数

    val a4: Int = -10%3
    println(a4)
    println("-----------------------")


    //2.关系/比较运算符
    val s1: String = "hello"
    val s2: String = new String("hello")
    println(s1==s2)        //比较内容 Java中比较的是地址
    println(s1.equals(s2)) //比较内容
    println(s1.eq(s2))     //比较地址
    println("-----------------------")


    //3.逻辑运算符  逻辑与/或/非
    def m(n: Int): Int = {
      println("m被调用")
      return n
    }
    val n = 1
    println((4>5) && m(n)>0)

    /**判断一个字符串是否不为空 s为空:null "" "  "
     * 扩展:避免逻辑与空指针(null)异常 短路与:前者为真就不执行后者了*/
    def isNotEmpty(s: String): Boolean = {
      return s != null && !"".equals(s.trim)
    }
    println(isNotEmpty(null))
    println(isNotEmpty(""))
    println(isNotEmpty(" "))
    println("-----------------------")


    //4.赋值运算符
    var b: Byte = 1
//    b += 1  //error: Java中默认会做强转 Scala不会 编译错误
    b = (b + 1).toByte
    println(b)

    var i = 1
    i += 1  //Scala无++、--，可通过+=、-=来实现同样效果
    println(i)
    println("-----------------------")


    //5.位运算符  按位与/或/异或/取反 左移/右移/无符号右移
    val b1 = 1000
    println(b1<<2) //b1*2^2=b1*4

    val b2: Short = -13 //(简化用8位表示)原1000,1101 补1111,0011
    println(b2<<2)  //补1100,1100(低位补0)      原1011,0100=-52
    println(b2>>2)  //补1111,1100(高位补符号位)  原1000,0100=-4
    //结果为-4而不是-3:补码移出后截取当前整数部分,补码表达向下(小)取整 但是-13/4=-3
    println(b2>>>2)  //补0011,1100(高位补0)  原(同补 是很大的正数)
    println("-----------------------")


    //6.Scala运算符的本质
    val n1 = 1
    val n2 = 2
    println(n1.+(n2)) //以自己作为一个加数,传参作为另一个加数做加法运算->面向对象
    /**1）当调用对象的方法时，点.可以省略
     * 2）如果函数参数只有一个，或者没有参数，()可以省略 */
    println(n1 + n2)

    println(1.toString())
    println(1 toString())
    println(1 toString)

    println(1.34.*(25))
    println(7.5.toInt.toString)
    println(7.5 toInt)
//    println(7.5 toInt toString) //error

  }
}
