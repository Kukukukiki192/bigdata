package cpt2

import cpt1.Student

//var(variable变量)/val(value常量) 变量名 [: 变量类型] = 初始值
//!能用常量的地方不用变量
object Test1_Value {
  def main(args: Array[String]): Unit = {
    //（1）声明变量时，类型可以省略，编译器自动推导，即类型推导
    var a = 1
    val b = 2

    //（2）类型确定后，就不能修改，说明 Scala 是强数据类型语言
    //  a = "str" //error a类型为Int

    //（3）变量声明时，必须要有初始值
    //  var c //error
    //  var c:Int //error

    //（4）在声明/定义一个变量时，可以使用 var 或者 val 来修饰，var 修饰的变量可改变，val 修饰的变量不可改
    a = 2
    //  b = 3 //error b是val修饰的


    var alice = new Student("alice",20)
    alice = new Student("Alice",20)
    alice = null

    val bob = new Student("bob",20)
    //  bob = new Student("bob",24) //error 常量bob指向新的定义不合法
    //bob是引用类型,指向的对象不能变,但对象里的属性可更改->看属性是var还是val
    bob.age = 24 //未定义age为var时error
    bob.print()
  }

}
