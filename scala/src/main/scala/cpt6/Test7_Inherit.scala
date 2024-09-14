package cpt6

/**
 * 继承
 */
object Test7_Inherit {
  def main(args: Array[String]): Unit = {
    //extends Person7: 子主<-父主
    //extends Person7(name, age): 子主<-父辅<-父主
    val student1 = new Student7("A",1)

    //extends Person7: 子辅<-子主<-父主
    //extends Person7(name, age): 子辅<-子主<-父辅<-父主
    val student2 = new Student7("B",2,"2018")

    student1.printInfo()
    student2.printInfo()

    val teacher = new Teacher7()
    teacher.printInfo()

    val person = new Person7
    person.printInfo()

    def personInfo(person: Person7): Unit = {
      person.printInfo()
    }
    println("------------")//动态绑定
    personInfo(student1)  //Student: A, 1, null
    personInfo(student2)  //Student: B, 2, 2018
    personInfo(teacher)   //Teacher
    personInfo(person)    //Person: null, 0
  }
}

//定义父类
class Person7() { //无参可不加()
  var name: String = _
  var age: Int = _

  println("1.调用父类主构造器")

  def this(name: String, age: Int) {
    this()
    println("2.调用父类辅助构造器")
    this.name = name
    this.age = age
  }

  def printInfo() {
    println(s"Person: $name, $age")
  }
}

//定义子类      var在父类中定义了子类形参就不用再定义
//class Student7(name: String, age: Int) extends Person7 {
class Student7(name: String, age: Int) extends Person7(name, age) {
  var no: String = _

  println("3.调用子类主构造器")

  def this(name: String, age: Int, no: String) {
    this(name, age)
    println("4.调用子类辅助构造器")
    this.no = no
  }

  override def printInfo(): Unit = {
    println(s"Student: $name, $age, $no")
  }
}

class Teacher7 extends Person7 {
  override def printInfo(): Unit = {
    println("Teacher")
  }
}