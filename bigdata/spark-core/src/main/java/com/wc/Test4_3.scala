package com.wc

import scala.io.Source
import java.io.PrintWriter
import java.io.File
import Array._
import scala.util.control._

object Test4_3 {

  def main(args: Array[String]){
    File()
  }

  def File(){
    val data=InFile("data/student.txt")
    var student= ofDim[String](4,2)
    val loop = new Breaks;
    var time:Int=0
    for(i<-data){
      var text=String.valueOf(i);
      var text2=text.split(" ")
      loop.breakable{
        for(j<- 0 to student.size-1){
          if(student(j)(0)==null){student(j)(0)=text2(0);student(j)(1)=text2(1);loop.break;}
          else{
            if(text2(0)==student(j)(0)){student(j)(1)=String.valueOf(student(j)(1).toInt+text2(1).toInt);time+=1}
          }
        }
      }
    }
    for(j<-0 to 3){
      student(j)(1)=String.valueOf(student(j)(1).toDouble/3)
    }
    outFile(student)
  }

  def InFile(path:String) : Array[String] ={
    val source = Source.fromFile(path, "UTF-8")
    val lines = source.getLines().toArray
    return lines
  }

  def outFile(data:Array[Array[String]]){
    val writer = new PrintWriter(new File("data/avg.txt"))
    for(i <-0 to data.size-1)
      writer.println(data(i)(0)+" "+data(i)(1))
    writer.close()
  }
}