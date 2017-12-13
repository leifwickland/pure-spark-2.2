package example

import org.apache.spark.sql.SparkSession

object PureSpark {
  def main(args: Array[String]): Unit = {
    val sc = SparkSession
      .builder
      .appName("Spark Test")
      .getOrCreate()
      .sparkContext
    def log(logBasePath: String, s: String) = {
      println(s)
      sc
        .parallelize(Seq(s))
        .coalesce(1)
        .saveAsTextFile(logBasePath + s"-${System.currentTimeMillis}/")
    }
    val Array(logBasePath) = args
    log(logBasePath, "Started")
    log(logBasePath, AppConf.loadClasspath().toString)
  }

}
