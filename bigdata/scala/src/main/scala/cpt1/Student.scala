package cpt1

class Student(name: String, var age: Int){
  def print(): Unit={
    println( "name=" + name +", age=" + age + ", school=" + Student.school );
  }
}

//引入伴生对象
object Student{
  val school: String = "K"

  def main(args: Array[String]): Unit = {
    val a=new Student("a",20)
    val b = new Student("b", 14)
    a.print()
    b.print()
  }
}