package cpt6

/**
 * 扩展
 * ---类型检查和转换---
 * 1. obj.isInstanceOf[T]	判断 obj 是不是 T 类型  判断对象是否为某个类型的实例
 * 2. obj.asInstanceOf[T]	将 obj 强转成 T 类型    将对象转换为某个类型的实例
 * 3. classOf				      获取对象的类名          获取类的信息
 * ---枚举类和应用类---
 * 枚举类  extends Enumeration
 * 应用类  extends App
 * ---Type 定义新类型---
 */
object Test17_Extends {
  def main(args: Array[String]): Unit = {
    val student = new Student17
    val person1 = new Student17
    val person = new Person17

    //判断类型
    println("student is Student17:" + student.isInstanceOf[Student17])
    println("student is Person17:" + student.isInstanceOf[Person17])
    println("person1 is Student17:" + person1.isInstanceOf[Student17])
    println("person1 is Person17:" + person1.isInstanceOf[Person17])
    println("person is Student17:" + person.isInstanceOf[Student17])  //只有这个是false
    println("person is Person17:" + person.isInstanceOf[Person17])
    //爸爸永远是爸爸,儿子长大了也能当爸爸

    //类型转换
    if(person1.isInstanceOf[Student17]) {
      //判断是这个类型才能转换
      val newStudent = person1.asInstanceOf[Student17]
      println(newStudent) //cpt6.Student17@71c7db30
    }

    //获取类名
    println(classOf[Person17])  //class cpt6.Person17
    val personClass: Class[Person17] = classOf[Person17]
    println(personClass)

    //测试枚举类
    println(WeekDay.MON)

  }
}

class Person17
class Student17 extends Person17

//枚举类对象
object WeekDay extends Enumeration {
  val MON = Value(1, "MONDAY")
  val TUES = Value(2, "TUESDAY")
}

//应用类对象
object Main extends App {
  //type定义新类型
  type myString = String
  val a: myString = "aaa"
  println(a)
}