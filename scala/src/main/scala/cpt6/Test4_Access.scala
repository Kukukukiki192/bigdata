package cpt6

//权限访问
object Test4_Access {
  def main(args: Array[String]): Unit = {
    //创建对象
    val person: Person = new Person()
    //    person.idCard //error
    println(person.age)
    println(person.sex)
    person.printInfo()

    val worker: Worker = new Worker()
    worker.printInfo()
  }
}

class Worker extends Person {
  override def printInfo(): Unit = {
    //    println(idCard) //error
    println(s"Worker: $name $sex $age")
  }
}
