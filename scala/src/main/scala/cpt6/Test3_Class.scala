package cpt6

import scala.beans.BeanProperty

//类和对象
object Test3_Class {
  def main(args: Array[String]): Unit = {
    //创建对象
    var stu: Student = new Student
    //    stu.name  //error 不可访问私有属性
    println(stu.sex + " " + stu.age)
    stu.setAge(14)
    stu.sex = "female"
    println(stu.sex + " " + stu.age)
  }

}

//（ 1 ）Scala 语法中,类并不声明为 public,所有这些类都具有公有可见性(即默认就是 public)
//定义类
class Student {
  //定义属性
  private var name: String = "Alice"

  @BeanProperty //自动生成JavaBean规范的 getter setter
  var age: Int = _

  var sex: String = _
  //_作为属性初始值的用法:属性必须为变量var.Int默认为0,Double为0.0,Boolean为false
  //val修饰的属性不能赋默认值,必须显示指定
}

//（ 2 ）一个 Scala 源文件可以包含多个类
//class Teacher{ }
