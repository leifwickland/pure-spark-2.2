import Dependencies._

name := "PureSpark"
organization := "com.example"
scalaVersion := "2.11.12"
version      := "0.1.0"

libraryDependencies ++= Seq(
  scalaTest % Test,
  spark % Provided,
  sparkSql % Provided,
  pureconfig)

assemblyJarName in assembly := s"pure-spark-$sparkVersion-assembly.jar"
assemblyShadeRules in assembly := Seq(ShadeRule.rename("shapeless.**" -> "new_shapeless.@1").inAll)
