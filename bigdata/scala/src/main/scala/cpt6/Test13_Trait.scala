package cpt6

/**
 * 特质trait
 */
object Test13_Trait {
  def main(args: Array[String]): Unit = {
    val student = new Student13
    student.study()
    student.hello() //动态绑定 先调父类再调子类
    student.dating()
    student.play()  //$name以Student13的name为准
    /** student student is studying
        hello from student
        hello from student student
        student student is dating
        youth student is playing
     */
  }
}

//父类
class Person13 {
  val name:String = "k"
  var age:Int = 12

  def hello() = {
    println("hello from " + name)
  }
}

//特质
trait Young {
  //声明抽象和非抽象属性
  var age: Int
  val name: String = "ali"

  //声明抽象和非抽象方法
  def dating(): Unit
  def play(): Unit = {
    println(s"youth $name is playing")
  }
}

class Student13 extends Person13 with Young {
  //重写冲突的属性
  override val name: String = "student"

  //实现抽象方法
  def dating(): Unit = println(s"student $name is dating")  //不重写name的话会产生属性继承冲突

  //自定义方法
  def study(): Unit = println(s"student $name is studying")

  //重写父类方法
  override def hello(): Unit = {
    super.hello()
    println(s"hello from student $name")
  }
}