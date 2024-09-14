package cpt6

/**
 * 特质叠加
 */
object Test15_TraitOverlying {
  def main(args: Array[String]): Unit = {
    val student = new Student15
    student.increase()  //talent increase

    //钻石问题特征叠加
    val myBall = new MyBall
    println(myBall.describe())  //my ball is a red-foot-ball
  }
}

//1.继承冲突(几个特质无关)------------------------------------------------
trait Knowledge15 {
  var amount: Int = 0
  def increase(): Unit = {
    println("knowledge increase")
  }
}

trait Talent15 {
  def singing(): Unit
  def dancing(): Unit
  def increase(): Unit = {
    println("talent increase")
  }
}

//子类
class Student15 extends Person13 with Knowledge15 with Talent15 {
  override def dancing(): Unit = println("dancing")
  override def singing(): Unit = println("singing")

  //继承冲突->重写冲突的方法
  //特质叠加顺序:从右到左 这里super调用Talent15的increase()
  override def increase(): Unit = super.increase()
}

//2.钻石问题--------------------------------------------------------
trait Ball {
  def describe(): String = "ball"
}

trait Color extends Ball {
  val color: String = "red"
  override def describe(): String = color + "-" + super.describe()
}

trait Category extends Ball {
  val category: String = "foot"
  override def describe(): String = category + "-" + super.describe()
}

class MyBall extends Category with Color {
  //特质叠加顺序: MyBall -> Color -> Category -> Ball
//  override def describe(): String = "my ball is a " + super.describe()
  //调用指定混入特质中的方法->增加约束[]
  override def describe(): String = "my ball is a " + super[Category].describe()
}
