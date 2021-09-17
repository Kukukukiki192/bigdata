package cpt2

object Test7_DataTypeConversion {
  def main(args: Array[String]): Unit = {
    //1.自动类型转换

    /**
    （1）自动提升原则：有多种类型的数据混合运算时，系统首先自动
        将所有数据转换成精度大的那种数据类型，然后再进行计算
    **/
    val a1 = 1 + 0.2  //1(Int->Double)+0.2(Double)
    println(a1)

    //（2）把精度大的数值类型赋值给精度小的数值类型时，就会报错，反之就会进行自动类型转换
    val a2 = 1.2
//    val b2: Int = a2  //error


    //（3）（byte，short）和 char 之间不会相互自动转换
    val a3: Byte = 22
//    val a3: Short = 22
    //error Byte,Short -/-> Char:
//    val b3: Char = a3

    val b3: Char = 'c'
    //error Char -/-> Byte,Short:
//    val c3: Byte = b3
//    val c3: Short = b3

    //Byte,Short -> Int
    val c3: Int = a3
    println(c3)


    //（4）byte，short，char 他们三者可以计算，在计算时首先转换为 int 类型
    val a4: Byte = 13
    val b4: Short = 25
    val c4: Char = 'c'
    val r4: Int = a4 + b4
    val r5: Int = a4 + b4 + c4
    println(r4 + r5)



    //2.强制类型转换
    val n1: Int = 1.9.toInt //向下取整
    val n2: Int = (10 * 3.5 + 6 * 1.5).toInt  //更精确
    println("n1:" + n1 + " n2:" + n2)



    //3.数值<-->String
    var s: String = 123 + ""
    val n: Int = "12.5".toDouble.toInt
    s = n.toString
    println("s:" + s + " n:" + n)



    //4.强转精度降低/溢出-面试题
    var x: Int = 128
    var y: Byte = x.toByte
    println(y)  //-128
    /**数值类型数据用补码表示
     * Int
     * 0000,0000 0000,0000 0000,0000 1000,0000 正数-原码、补码一致
     * 强转后->截取最后一个字节
     * Byte
     * 1000,0000 补码 =最大负数-128
     */

    x = 130
    y = x.toByte
    println(y)  //-126
    /**Int
     * 0000,0000 0000,0000 0000,0000 1000,0010
     * Byte
     * 1000,0010 补码 -128+2=-126
     * 1111,1110 原码 -126
     */
  }
}
