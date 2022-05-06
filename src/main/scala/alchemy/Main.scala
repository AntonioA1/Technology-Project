package alchemy

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path
import java.io._
import scala.collection.mutable.ListBuffer

import java.text.SimpleDateFormat
import java.util.Calendar

object Main {
  // val orderGenerator = new DataGeneration()
  val hive = new HiveClient()
  val csvPath = "/home/maria_dev/alchemyData.csv"
  val hdfsPath ="hdfs://sandbox-hdp.hortonworks.com:8020/user/maria_dev/alchemyData.csv"

  def main(args: Array[String]): Unit = {
    
    var rows = getData()
    appendRowsToCSV(rows)

    println("Writing Data to CSV...")

    println(s"Uploading $csvPath to HDFS...")
    hive.loadIntoHDFS(csvPath, hdfsPath)

    println("Loading into Hive...")
    hive.loadIntoHive("/user/maria_dev/")
  }

  def getData(): ListBuffer[String] = {
    val format = new SimpleDateFormat("y=MM-DD HH:mm:ss")
    val currentDay = format.format(Calendar.getInstance().getTime())

    var orderList = new ListBuffer[String]()

    for(itr <- 1 to 100) {
     val orderAny = new Order(itr, currentDay.toString)
      orderList += orderAny.generateRow()
     }

    return orderList
  }

  def appendRowsToCSV(rows: ListBuffer[String]): Unit = {
    val file = new File(csvPath)
    val bw = new BufferedWriter(new FileWriter(file))

    for (row <- rows) {
      println(row + "\n")
      bw.write(row + "\n")
    }
    bw.close()
  }
}
