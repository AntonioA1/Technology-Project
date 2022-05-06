import Dependencies._

ThisBuild / scalaVersion     := "2.11.8"
ThisBuild / version          := "0.1"
ThisBuild / organization     := "com.PJ2"
ThisBuild / organizationName := "PJ2"

lazy val root = (project in file("."))
  .settings(
    name := "alchemy",
    libraryDependencies += scalaTest % Test,
    // libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.7.0",
    libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.4.8",
    libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.4.8",
    libraryDependencies += "org.apache.spark" % "spark-hive_2.11" % "2.4.8"
  )