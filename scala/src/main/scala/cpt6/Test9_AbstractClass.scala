package cpt6

/**
 * 抽象类
 */
object Test9_AbstractClass {
  def main(args: Array[String]): Unit = {
    val student = new Student9
    student.eat()
    student.sleep()
  }

}

//定义抽象类
abstract class Person9 {
  /** 非抽象属性
   * 子类对非抽象属性重写,父类非抽象属性只支持 val,而不支持 var
   * 因为 var 修饰的为可变变量,子类继承之后就可以直接使用,没必要重写
   */
  val name: String = "person"
  var name1: String = "person"

  //抽象属性
  var age: Int

  //非抽象方法
  def eat(): Unit = {
    println("person eat")
  }

  //抽象方法
  def sleep(): Unit

}

//定义具体实现子类
class Student9 extends Person9 {
  //实现抽象属性和方法
  var age: Int = 12

  def sleep(): Unit = {
    println("student sleep")
  }

  //重写非抽象属性和方法
  override val name: String = "student"
  name1 = "student" //var属性直接修改即可

  override def eat(): Unit = {
    super.eat()
    println("student eat")
  }
}