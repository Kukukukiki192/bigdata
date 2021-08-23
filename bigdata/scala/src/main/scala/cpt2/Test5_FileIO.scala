package cpt2

import java.io.{File, PrintWriter}
import scala.io.Source

//文件读写
object Test5_FileIO {

  def main(args: Array[String]): Unit = {
    //从文件读取数据
    Source.fromFile("scala/src/main/resources/data.txt").foreach(print) //从项目根目录下的scala目录开始读相对路劲 foreach传了函数进去

    //将数据写入文件 scala没有专门的工具类->java都有->直接引用java的IO类
    val writer = new PrintWriter(new File("scala/src/main/resources/out.txt"))
    writer.write("hello Scala from Java writer")
    writer.close()
  }

}
