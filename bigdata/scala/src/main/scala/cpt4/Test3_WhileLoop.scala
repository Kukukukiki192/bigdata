package cpt4

object Test3_WhileLoop {

  def main(args: Array[String]): Unit = {
    //推荐for 不推荐while
    var i = 0
    while(i<5) {
      println(i)
      i+=1
    }

    i = 0
    do{
      i-=1
      println(i)
    }while(i>=0)
  }

}
