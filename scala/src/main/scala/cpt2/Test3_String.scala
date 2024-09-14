package cpt2

//字符串输出
object Test3_String {
  def main(args: Array[String]): Unit = {
    //（1）字符串，通过+号连接
    val name : String = "A"
    val age : Int = 18
    println(age + "岁的" + name + "在学习")
    //*用于将一个字符串复制多次并连接
    println(name*3)

    //（2）printf 用法：字符串，通过占位符%传值
    printf("%d岁的%s在学习", age, name)

    //（3）字符串模板（插值字符串）：通过$获取变量值
    println(s"${age}岁的${name}在学习")
    val num = 3.14125 //默认Double
    val num1 : Double = 3.14125
    val num2 : Float = 3.14125f
    println(f"PAI is ${num}%2.2f") //第一个f:格式化模板字符串 第二个f:浮点类型 第一个2:整个数的长度是2，不够补空格 第二个2:保留2位小数
    println(raw"PAI is ${num}%2.2f") //按原始输出

    //（4） """: 多行字符串原格式输出
    //输入带有空格、\t 之类，导致每行开头不能整洁对齐-> stripMargin 方法(忽略边界)默认"|"作为连接符加在多行换行的行头
    val sql =
    s"""
       |select *
       |from
       |  student
       |where
       |  name = ${name}
       |and
       |  age > ${age+2}
       |""".stripMargin
    println(sql)
  }

}
