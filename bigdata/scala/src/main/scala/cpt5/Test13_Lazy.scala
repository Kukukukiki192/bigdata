package cpt5

/**惰性加载
 * 惰性函数:当函数返回值被声明为 lazy 时,函数的执行将被推迟,直到首次对其取值,该函数才会执行
 * lazy 不能修饰 var 类型的变量!
 * 单例模式(懒汉式),等到用的时候再加载,减少内存负担
 */
object Test13_Lazy {
  def main(args: Array[String]): Unit = {
    lazy val r = sum(2, 5)
    println("1.函数调用")
    println("3.r=" + r)   //第1次调用,执行
    println("4.r=" + r)   //第2次调用,不用执行,取已经算好的值
  }

  def sum(a: Int, b: Int): Int = {
    println("2.调用sum")
    a + b
  }

}
