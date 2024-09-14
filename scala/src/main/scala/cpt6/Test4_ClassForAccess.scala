package cpt6

/**  权限访问
 * 1.Scala 中属性和方法的默认访问权限为public,但Scala中无 public 关键字
 * 2.private 为私有权限,只在 类内部 和 伴生对象 中可用
 * 3.protected 为受保护权限,Scala中受保护权限比Java中更严格,同类、子类可访问,同包无法访问
 * 4.private[包名]增加包访问权限,包名下的其他类也可以使用
 */
object Test4_ClassForAccess {
  def main(args: Array[String]): Unit = {
    val person: Person = new Person()
    //    person.idCard //error
    println(person.age)
    println(person.sex)
    person.printInfo()
  }
}

//定义父类
class Person{
  private var idCard: String = "2342125"
  protected var name: String = "Alice"
  var sex: String = "female"
  private[cpt6] var age: Int = 18

  def printInfo() = {
    println(s"Person: $idCard $name $sex $age")
  }
}