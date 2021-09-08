package cpt5

object Test3_FuncParam {

  def main(args: Array[String]): Unit = {
    //1.可变参数
    def f1(s: String*) = {  //s是集合类型
      println(s)
    }
    f1()        //无入参:输出List()
    f1("a")     //有入参:输出WrappedArray(..)
    f1("a","b")

    //2.如果参数列表中存在多个参数，那么可变参数一般放置在最后
    def f2(s1: String, s2: String*) = {
      println("s1: " + s1 + " s2: " + s2)
    }
    f2("a")
    f2("a","b","c")

    //3.参数默认值，一般将有默认值的参数放置在参数列表的后面
    def f3(s: String = "K") = {
      println("hi " + s)
    }
    f3()
    f3("a")

    //4.带名参数
    def f4(name: String = "K", age: Int) = {
      println(s"${name}${age}岁了")
    }
    f4("KK",21)
    f4(age = 18)

  }

}
