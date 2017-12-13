import sbt._

object Dependencies {
  lazy val sparkVersion = "2.1.0"
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.3"
  lazy val spark = "org.apache.spark" %% "spark-core" % sparkVersion
  lazy val sparkSql = "org.apache.spark" %% "spark-sql" % sparkVersion
  lazy val pureconfig = "com.github.pureconfig" %% "pureconfig" % "0.8.0"
}

