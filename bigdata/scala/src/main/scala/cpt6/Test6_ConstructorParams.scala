package cpt6

/**
 * 构造器参数
 */
object Test6_ConstructorParams {
  def main(args: Array[String]): Unit = {
    val student2 = new Student2
    student2.name = "xx"
    student2.age = 12
    println(s"student2: name = ${student2.name}, age = ${student2.age}")

    val student3 = new Student3("s",43)
    println(s"student3: name = ${student3.name}, age = ${student3.age}")

    val student4 = new Student4("r",5)
//    println(s"student4: name = ${student4.name}, age = ${student4.age}")  //得不到属性
    student4.printInfo()

    var student6 = new Student6("6",6)
    student6.printInfo()
    student6 = new Student6("66",66,"MIT")
    student6.printInfo()
  }

}

/**
 * 定义类
 * 无参构造器
 */
class Student2() {
  //单独定义属性
  var name: String = _
  var age: Int = _
}

//=下面定义
class Student3(var name: String, var age: Int)

//主构造器参数无修饰(形参不作为属性)
class Student4(name: String, age: Int) {
  def printInfo() { //如果期望是无返回值类型,可省略等号
    println(s"student4: name = $name, age = $age")
  }
}

//不推荐 麻烦
//class Student44(_name: String, _age: Int) {
//  var name: String = _name
//  var age: Int = _age
//}

class Student5(val name: String, val age: Int) //属性不可更改 初始化后调用student5.age=5->error

class Student6(var name: String, var age: Int) {
  var school: String = _

  def this(name: String, age: Int, school: String) {
    this(name, age)
    this.school = school
  }

  def printInfo(): Unit = {
    println(s"student6: name = $name, age = $age, school = $school")
  }
}