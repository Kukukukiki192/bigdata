package cpt6

/**
 * 匿名子类
 */
object Test10_AnnoymousClass {
  def main(args: Array[String]): Unit = {
    val person = new Person10 {
      override var age: Int = 77

      override def sleep(): Unit = println("person")
    }
    println(person.age)
    person.sleep()
  }

}

//定义抽象类
abstract class Person10 {
  var age: Int
  def sleep(): Unit
}