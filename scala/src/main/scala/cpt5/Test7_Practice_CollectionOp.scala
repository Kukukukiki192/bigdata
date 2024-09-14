package cpt5

import scala.collection.mutable.ArrayBuffer

//高阶函数案例：模拟 Map 映射、 Filter 过滤、 Reduce 聚合
object Test7_Practice_CollectionOp {
  def main(args: Array[String]): Unit = {
    //1.map映射
    val arr: Array[Int] = Array(12, 45, 67)

    //处理数组 抽象操作 处理完返回新数组
    def arrOp(arr: Array[Int], op: Int=>Int): Array[Int] = {
      for(elem <- arr) yield op(elem)
    }

    // +1
    def addOne(elem: Int): Int = {
      elem + 1
    }

    //调用
    val newArr: Array[Int] = arrOp(arr, addOne)
    println(newArr.mkString(","))   //以','为分隔符打印

    //传入匿名函数 实现元素翻倍
    val newArr1 = arrOp(arr, _ * 2) //elem => elem * 2
    println(newArr1.mkString(","))


    //2.filter过滤  有参数，且参数再后面只使用一次，则参数省略且 后面参数用_表示
    def filter(arr:Array[Int],op:Int =>Boolean) = {
      var arr1: ArrayBuffer[Int] = ArrayBuffer[Int]()
      for (elem <- arr if op(elem)) {
        arr1.append(elem)
      }
      arr1.toArray
    }
    var arr1 = filter(Array(1, 2, 3, 4), _ % 2 == 1)
    println(arr1.mkString(","))


    //3.reduce聚合 有多个参数，且每个参数再后面只使用一次，则参 数省略且后面参数用_表示，第 n 个_代表第 n 个参数
    def reduce(arr: Array[Int], op: (Int, Int) => Int) = {
      var init: Int = arr(0)
      for (elem <- 1 until arr.length) {
        init = op(init, elem)
      }
      init
    }
    val arr2 = reduce(Array(1, 2, 3, 4), _ * _)
    println(arr2)

  }

}
