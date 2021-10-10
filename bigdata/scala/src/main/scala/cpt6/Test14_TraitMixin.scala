package cpt6

/**
 * 特质混入mixin
 */
object Test14_TraitMixin {
  def main(args: Array[String]): Unit = {
    val student: Student14 = new Student14
    student.study()
    student.increase()

    student.dating()
    student.increase()

    student.play()
    student.increase()

    println("-----动态混入----")
    val studentWithTalent = new Student14 with Talent{
      override def singing(): Unit = println("student is good at singing")
      override def dancing(): Unit = println("student is good at dancing")
    }
    studentWithTalent.study()
    studentWithTalent.play()
    studentWithTalent.increase()
    studentWithTalent.singing()
    studentWithTalent.dancing()
  }

}

//特质
trait Knowledge {
  var amount: Int = 0
  def increase(): Unit
}

trait Talent {
  def singing(): Unit
  def dancing(): Unit
}

//子类
class Student14 extends Person13 with Young with Knowledge {
  //重写冲突的属性
  override val name: String = "kk"

  //实现抽象方法
  def dating(): Unit = println(s"student $name is dating")  //不重写name的话会产生属性继承冲突

  //自定义方法
  def study(): Unit = println(s"student $name is studying")

  //重写父类方法
  override def hello(): Unit = {
    super.hello()
    println(s"hello from student $name")
  }

  //实现特质中的抽象方法 父类也有该方法override
  override def increase(): Unit = {
    amount += 1
    println(s"student $name knowledge increased $amount")
  }
}