package com.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.io.Source
import java.io.PrintWriter
import java.io.File
import Array._
import scala.util.control._

object Test4_2 {

  def main(args: Array[String]){
    File()

  }

  def File(){
    val AFile=InFile("data/A.txt")
    val BFile=InFile("data/B.txt")
    var CFile=concat( AFile, BFile)
    var CFile2=new Array[String](CFile.size)
    val loop = new Breaks;

    for(i<-CFile){
      loop.breakable{
        for(j<- 0 to CFile2.size-1 ){
          if(CFile2(j)!=null){if(i==CFile2(j))loop.break;}
          else {CFile2(j)=i;loop.break;}
        }
      }
    }
    outFile(CFile2)
  }

  def InFile(path:String) : Array[String] ={
    val source = Source.fromFile(path, "UTF-8")
    val lines = source.getLines().toArray
    return lines

  }

  def outFile(data:Array[String]){
    val writer = new PrintWriter(new File("data/C.txt"))
    for(i <-data)
      if(i!=null)writer.println(i)
    writer.close()
  }

}

//  def main(args: Array[String]): Unit = {
//    val sparkConf = new SparkConf().setMaster("local").setAppName("Test4_2")
//    val sc = new SparkContext(sparkConf)
//
//    val lines1 = sc.textFile("data/A.txt")
//    val lines2 = sc.textFile("data/B.txt")
//    val lines=lines1.union(lines2)
//    val distinct_lines = lines.distinct()
////    val res = distinct_lines.sortBy(lambda x:x)
////    res.repartition(1).saveAsTextFile("data/C.txt")
//    distinct_lines.repartition(1).saveAsTextFile("data/C")



//  }