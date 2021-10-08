package cpt6

/**
 * 单例模式
 */
object Test12_Singleton {
  def main(args: Array[String]): Unit = {
    //构造器私有化 不能直接new对象 -> 用伴生对象获取实例
    val student1 = Student12.getInstance()
    student1.print()

    val student2 = Student12.getInstance()
    student2.print()

    println(student1==student2) //返回true 说明全局就一份实例

  }

}

class Student12 private(val name: String, val age: Int){
  def print(): Unit={
    println(s"student: name=$name, age= $age, school= ${Student11.school}");
  }
}

//饿汉式
//object Student12 {
//  private val student: Student12 = new Student12("k",13)
//  def getInstance(): Student12 = student
//}

//懒汉式(使用时再加载实例)
object Student12 {
  private var student: Student12 = _
  def getInstance(): Student12 = {
    if(student==null) student = new Student12("k",13)
    student
  }
}