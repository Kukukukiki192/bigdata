package cpt6

/**
 * 多态
 */
object Test8_DynamicBind {
  def main(args: Array[String]): Unit = {
    val teacher: Teacher8 = new Teacher8()
    val teacher1: Person8 = new Teacher8
    println(teacher.name)
    teacher.hello()
    println(teacher1.name)  //动态绑定属性
    teacher1.hello()  //动态绑定方法
  }
}

class Person8 {
  val name: String = "person"
  def hello(): Unit = {
    println("hello person")
  }
}

class Teacher8 extends Person8 {
  override val name: String = "teacher"
  override def hello(): Unit = {
    println("hello teacher")
  }
}