package com.wc

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test4_1 {

  def main(args: Array[String]): Unit = {
    //Application

    //Spark框架

    //TODO 建立和Spark框架的连接
    //JDBC:Connection           表示Spark框架运行的环境(本地环境)  设置应用程序的名称
    val sparkConf = new SparkConf().setMaster("local").setAppName("Test4_1")
    val sc = new SparkContext(sparkConf)

    //TODO 执行业务操作

    // 1.该系总共有多少学生
//    val lines=sc.textFile("data/Data01.txt")//打开文件 D:\edu\大三下\大数据
//    val lines=sc.textFile("D:/edu/大三下/大数据/Data01.txt")
//    val par=lines.map(row=>row.split(",")(0))//切分取第一数值
//    val distinct_par=par.distinct()//去重
//    distinct_par.count//输出

    // 2.该系总共开设了多少门课程
    val lines=sc.textFile("D:/edu/大三下/大数据/Data01.txt")
    val par=lines.map(row=>row.split(",")(1))//切分取第2数值
    val distinct_par=par.distinct()//去重
    distinct_par.count//输出

    // 3.Tom 同学的总成绩平均分是多少
//    val lines=sc.textFile("D:/edu/大三下/大数据/Data01.txt")//打开文件
//    val pare=lines.filter(row=>row.split(",")(0)=="Tom")//fileter
//    pare.foreach(println)//输出内容
//    /*Tom,DataBase,26
//    Tom,Algorithm,12
//    Tom,OperatingSystem,16
//    Tom,Python,40
//    Tom,Software,60*/
//    pare.map(row=>(row.split(",")(0),row.split(",")(2).toInt))
//      .mapValues(x=>(x,1))
//      .reduceByKey((x,y)=>(x._1+y._1,x._2+y._2))
//      .mapValues(x=>(x._1/x._2)).collect()
//    //res13: Array[(String, Int)] = Array((Tom,30))



    // 4.求每名同学的选修的课程门数
//    val lines=sc.textFile("D:/edu/大三下/大数据/Data01.txt")
//    val pare=lines.map(row=>(row.split(",")(0),row.split(",")(1)))
//    pare.mapValues(x=>(x,1)).reduceByKey((x,y)=>(" ",x._2+y._2)).mapValues(x =>x._2).foreach(println)

    // 5.该系 DataBase 课程共有多少人选修；
//    val lines=sc.textFile("D:/edu/大三下/大数据/Data01.txt")
//    val pare=lines.filter(row=>row.split(",")(1)=="DataBase")
//    pare.count

    // 6.各门课程的平均分是多少；
//    val lines=sc.textFile("D:/edu/大三下/大数据/Data01.txt")
//    val par=lines.map(row=>(row.split(",")(1),row.split(",")(2).toInt))
//    par.mapValues(x=>(x,1)).reduceByKey((x,y)=>(x._1+y._1,x._2+y._2)).mapValues(x=>(x._1/x._2)).collect()

    // 7.使用累加器计算共有多少人选了 DataBase 这门课
//    val lines=sc.textFile("D:/edu/大三下/大数据/Data01.txt")
//    val pare=lines.filter(row=>row.split(",")(1)=="DataBase").map(row=>(row.split(",")(1),1))
//    val accum=sc.longAccumulator("My Accumulator")
//    pare.values.foreach(x=>accum.add(x))
//    accum.value


//    // 1.读取文件,获取一行一行的数据
//    val lines: RDD[String] = sc.textFile("data/Data01.txt")
//
//    // 2.将一行数据拆分成一个一个的单词
//    //   扁平映射/扁平化：将整体拆分成个体的操作
//    val words: RDD[String] = lines.flatMap(_.split(","))
//
//    // 3.将数据根据单词进行分组,便于统计
//    //   (hello,hello,hello),(world,world)
//    val wordGroup: RDD[(String,Iterable[String])] = words.groupBy(word => word)
//
//    // 4.将分组后的数据进行转换
//    //   (hello,3),(world,2)
//    val wordToCount = wordGroup.map{
//      case(word,list)=>{
//      (word,list.size)
//      }
//    }
//
//    // 5.将转换结果采集到控制台打印出来
//    val array: Array[(String,Int)] = wordToCount.collect()
//    array.foreach(println)

    //TODO 关闭连接
    sc.stop()
  }

}
