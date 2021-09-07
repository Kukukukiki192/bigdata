package cpt4

object Test2_ForLoop {
  def main(args: Array[String]): Unit = {
    //1.范围遍历
    // [1,3]
    println("1--------")
    for(i<-1 to 3) {  //= for(i: Int <- 1.to(3)) 面向对象
      println(i)
    }

    // [1,3)
    for(i<-1 until 3) {  //= for(i <- Range(1,3))
      println(i)
    }


    //2.集合遍历
    println("2--------")
    for(i <- Array(2,4,6)) {
      println(i)
    }
    for(i <- List(2,4,6)) {
      println(i)
    }
    for(i <- Set(2,4,6)) {
      println(i)
    }


    //3.循环守卫
    println("3--------")
    for(i<-1 to 3 if i !=2) {
      println(i)
    }
    /** =
    for(i<-1 to 3) {
      if(i != 2) println(i)
    } **/


    //4.循环步长
    println("4--------")
    for(i<-1 to 5 by 2) { //= for(i<-(1 to 5).by(2)) 注：Step cannot be 0
      println(i)
    }
    for(i<-1.0 to 5.0 by 0.4) { //Double精度缺失 最好用BigDecimal
      println(i)
    }
    println("----")
    for(i<-BigDecimal(1.0) to BigDecimal(5.0) by BigDecimal(0.4)) {
      println(i)
    }
    println("----")
    for(i<- Range(1,5,2)) { //[1,5)
      println(i)
    }
    println("----")
    // 倒叙打印 = for(i<-3 to 1 by -1)
    for(i<-1 to 3 reverse) {
      println(i)
    }


    /** 5.嵌套循环
    for(i<-1 to 3; j<-1 to 2) {}
    =
    for(i<-1 to 3) {
      for(j<-1 to 2) {}
    } **/
    println("5--------")
    println("MulTable:")
    for(i<-1 to 9; j<-1 to i) {
      print(s"${i} * ${j} = ${i*j}"+'\t')
      if(j==i) println()
    }


    //6.引入变量
    println("6--------")
    for(i<-1 to 3; j = i - 1) {
      println(i + " " + j)
    }
    for {
      i<-1 to 3
      j = i - 1
    } {
      println(i + " " + j)
    }
    /** =
    for(i<-1 to 3) {
      var j = i - 1
    } **/
    println("Pyramid:")
    for(i<-1 to 9; j = " "*(9-i) + "*"*(i*2-1)) {
      println(j)
    }
    //or找出数学关系:
    for(stars<-1 to 17 by 2; spaces = (17-stars)/2) {
      println(" "*spaces + "*"*stars)
    }


    //7.循环返回值
    println("7--------")
    var r = for(i<-1 to 3) yield i
    r = for(i<-1 to 3) yield {
      i*3
    } //yield生成集合类型作为返回值 若没有yield,返回值类型为空Unit,返回()
    println(r)

  }

}
