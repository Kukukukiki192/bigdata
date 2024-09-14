package cpt6

/**
 * 伴生对象
 */
object Test11_Object {
  def main(args: Array[String]): Unit = {
//    val student = new Student11("k",21)   //伴生类构造器私有化后error
//    student.print()

    /**
     * 伴生对象中的属性和方法都可以通过伴生对象名(类名)直接调用访问
     */
    val student1 = Student11.newStudent("k",21)
    student1.print()

    val student2 = Student11.apply("k",21)
    student2.print()

    //通过伴生对象的apply方法(apply可省略),实现不使用new创建对象
    //obj(arg)=obj.apply(arg) 用以统一面向对象编程和函数式编程的风格
    val student3 = Student11("k",21)
    student3.print()

    /**
     * val student = new Student11("k",21)
     * 当使用 new 关键字构建对象时，调用的其实是类的构造方法
     * val student = Student11("k",21)
     * 当直接使用类名构建对象时，调用的其实时伴生对象的 apply 方法
     */

  }

}

//伴生类
class Student11 private(val name: String, val age: Int){
  def print(): Unit={
    println(s"student: name=$name, age= $age, school= ${Student11.school}");
  }
}

//伴生对象
object Student11 {
  val school: String = "ZJUT"  //当作静态属性

  //定义一个类的对象实例的创建方法
  def newStudent(name: String, age: Int):Student11 = new Student11(name, age) //当作静态方法

  def apply(name: String, age: Int):Student11 = new Student11(name, age)

}