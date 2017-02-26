name := "SparkAdaptivePerformance"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.0.2"
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.0.2"
libraryDependencies += "org.apache.spark" % "spark-mllib_2.11" % "2.0.2"

fork := true
javaOptions in run += "-Xmx16G"
javaOptions in run += "-Dspark.ui.showConsoleProgress=false"
