package cpt5

import scala.annotation.tailrec

//递归 & 尾递归
object Test10_Recursion {
  def main(args: Array[String]): Unit = {
    println(fact(5))
    println(tailFact(5))
  }

  /**递归实现阶乘
   * 不足:
   * 上栈压着下栈不能弹出,所以下栈的所有资源都不能释放,直到满足退出条件,才能从上到下计算完并弹出栈帧
   * 递归调用层级很深时,当前栈空间要保存的栈帧会很多,导致内存溢出->StackOverFlow
   */
  def fact(n: Int): Int = {
    if (n == 0) return 1  //基准情形 0!=1
    fact(n - 1) * n
  }

  /**优化->尾递归
   * 对于自身的递归调用永远放在当前代码块返回的最后一句
   * 内层函数是尾递归(将中间状态作为参数传入,每次调用自身时更新),外层函数调用它
   * 尾递归的优化依赖于编译器,它要知道遇到尾递归时做栈的覆盖而不是叠加(不停覆盖之前的值,不用保存上一层信息)
   */
  def tailFact(n: Int): Int = {
    @tailrec   //确保写的代码是正确的尾递归程序,写的不正确就会报错 只要是函数式编程语言都支持尾递归
    def loop(n: Int, currRes: Int): Int = {
      if(n==0) return currRes
      loop(n - 1, currRes * n)
//5->(5,1)->(4,1*5)->(3,(1*5)*4)->(2,(1*5*4)*3)->(1,(1*5*4*3)*2)->(0,((1*5*4*3*2)*1)->return 1*5!
    }
    loop(n, 1)  //初始调用为1
  }

}
