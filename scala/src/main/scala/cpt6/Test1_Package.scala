//用嵌套风格定义包-更灵活
package com {
  import com.k.scala.Inner

  //在外层包中定义单例对象
  object Outer {
    var out: String = "out"
    def main(args: Array[String]): Unit = {
      println(Inner.in) //父包访问子包需要导包
    }
  }
  package k { //标红是因为按嵌套风格定义的包与按Java风格层级关系不对应,IDEA对嵌套风格支持不够好 不影响
    package scala {
      //在内层包中定义单例对象
      object Inner {
        val in: String = "in"
        def main(args: Array[String]): Unit = {
          println(Outer.out)  //子包访问父包无需导包
          Outer.out = "outer"
          println(Outer.out)

//          commonValue //error
//不能访问包共享属性,因为该单例对象所属包并不是当前文件所属位置cpt6,而是按嵌套风格定义的com.k.scala
        }
      }
    }
  }
}

//在同一文件中定义多个包
package a {
  package b {

    import com.k.scala.Inner

    object Test1_Package{
      def main(args: Array[String]): Unit = {
        println(Inner.in)
      }
    }

  }
}