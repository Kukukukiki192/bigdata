package cpt2

import cpt1.Student

object Test6_DataType {

  def main(args: Array[String]): Unit = {
    //1.整型 Byte Short Int Long
    var a: Byte = 127
//    a = 128 //error 越界
    a = -128   //!将原码-0约定为最小补码负数(无原码转补码后为1000,0000)

    val b = 10  //默认Int
//    val c = 3000000000 //error 越界 >2147483647=2^31-1
    val c = 3000000000L
    println(c)

    val a1: Byte = 10
    val a2: Byte = (10 + 20) //自动类型提升->编译器可自定运算并判断是否超出范围 报错是因为IDEA对scala支持不到位,但可以运行
    println(a2)
//    val a3: Byte = (a1 + 20) //编译报错,因为运行时才能取a1的值来运算并判断a3的值是否在范围内
    val a3: Byte = (a1 + 20).toByte //强转
    println(a3)


    //2.浮点型 Float Double
    val d = 3.14 //默认Double
    val f:Float = 3.14f


    //3.字符型
    //（1）字符常量是用单引号 ' ' 括起来的单个字符。
    var c1: Char = 'a'
    println("c1=" + c1)
    var c2:Char = 'a' + 1 //报错原因同上
    println(c2)

    //特殊符号 转义
    //（2）\t ：一个制表位，实现对齐的功能
    println("姓名\t年龄")
    //（3）\n ：换行符
    println("西门庆\n潘金莲")
    //（4）\\ ：表示\
    println("c:\\岛国\\avi")
    //（5）\" ：表示"
    println("同学们都说：\"大海哥最帅\"")


    //4.布尔型
    var isResult : Boolean = false


    //5.空类型
    // 5.1 空值Unit
    def f1():Unit = {
      println("f1被调用")
    }
//    val f11 = f1()
    val f11:Unit = f1()
    println("f1:" + f11)
//    println("f1:" + f1)   //相当于前2行

    // 5.2 空引用Null
//    val n:Int = null //error 值类型不能接收空引用
    var student = new Student("alice", 18)
    student = null
    println(student)

    // 5.3 Nothing
    def f3(n: Int): Int = {
      if(n == 0)
        throw new NullPointerException
      else
        return n
    }
//    val f33 = f3(1)
    val f33 = f3(0)
    println(f33)

    def test(): Nothing={
      throw new Exception()
    }
    test    //直接用方法名
 }

}
