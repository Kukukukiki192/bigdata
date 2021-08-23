package cpt2

//标识符(各种变量、方法、函数)的命名规范
object Test2_Identifier {

  def main(args: Array[String]): Unit = {
    //（1）以字母或者下划线开头，后接字母、数字、下划线
//    var a_: String = "" //error
    var a_x: String = ""
    var a_1: String = ""
    var _ab: String = ""
    var Int: String = "Int" // ok 因为在 Scala 中 Int 是预定义的字符,不是关键字，但不推荐
    println(Int)
    var _: String = "_" // ok 单独一个下划线不可以作为标识符，因为_被认为是一个方法
//    println(_) //error: missing parameter type for expanded function ((x$1: <error>) => println(x$1))

    //（2）以操作符开头，且只包含操作符（+ - * / # !等） 与':'要以' '分开
    var !: : String = "!:"
    var +*-/#! : String = "+*-/#!"
//    var +*-/#!1 : String = "" // error 以操作符开头，必须都是操作
    println(!:)

    //（3）用反引号``包括的任意字符串，即使是 Scala 关键字（39 个）也可以
//    var if : String = "" // error 不能用关键字
    var `if` : String = "`if`" // ok 用反引号`....`包括的任意字符串，包括关键字
    println(`if`)
  }

  /**   scala关键字
      • package, import, class, object, trait, extends, with, type, for
      • private, protected, abstract, sealed, final, implicit, lazy, override
      • try, catch, finally, throw
      • if, else, match, case, do, while, for, return, yield
      • def, val, var
      • this, super
      • new
      • true, false, null
   */
}