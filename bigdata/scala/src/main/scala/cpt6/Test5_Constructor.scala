package cpt6

/**
 * 构造器
 */
object Test5_Constructor {
  def main(args: Array[String]): Unit = {
    val student1: Student1 = new Student1()
    student1.Student1()

    //Student1("A")<-Student1()
    val student2 = new Student1("A")

    //Student1("B",23)<-Student1("B")<-Student1()
    val student3 = new Student1("B",23)

  }

}

class Student1() {  //主构造器
  var name: String = _
  var age: Int = _

  println("1.主构造方法被调用")

  //声明辅助构造器
  def this(name: String) {
    this()  //直接调用主构造方法
    println("2.辅助构造方法1被调用")
    this.name = name
    println(s"name: $name age: $age")
  }

  def this(name: String, age: Int) {
    this(name)  //调用之前的辅助构造方法
    println("3.辅助构造方法2被调用")
    this.age = age
    println(s"name: $name age: $age")
  }

  def Student1(): Unit = {
    println("一般方法被调用")
  }
}
