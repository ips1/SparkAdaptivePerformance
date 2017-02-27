package tests

import java.io.{File, PrintWriter}

import configuration.AdaptiveConfiguration
import org.apache.spark.storage.StorageLevel

import scala.util.Random

/**
  * Created by petrkubat on 19/02/2017.
  */
object GroupByTest extends AdaptiveTest[Unit] {
  override def runTest(configuration: AdaptiveConfiguration): Unit = {
    val spark = SparkInitializer.initSession(configuration, "GroupByTest")

    val numIterations = 50
    val numMappers = 10
    val numKVPairs = 200000
    val valSize = 1000
    val numReducers = numMappers

    val pairs1 = spark.sparkContext.parallelize(0 until numMappers, numMappers).flatMap { p =>
      val ranGen = new Random(42)
      val arr1 = new Array[(Int, Array[Byte])](numKVPairs)
      for (i <- 0 until numKVPairs) {
        val byteArr = new Array[Byte](valSize)
        ranGen.nextBytes(byteArr)
        arr1(i) = (ranGen.nextInt(Int.MaxValue), byteArr)
      }
      arr1
    }
    // Enforce that everything has been calculated and in cache
    pairs1.persist(StorageLevel.MEMORY_ONLY)
    pairs1.count()

    val perfLog = new PrintWriter(new File("perf.csv"))

    for (idx <- 1 to numIterations) {
      val startTime = System.nanoTime
      val count = pairs1.groupByKey(numReducers).count
      val endTime = System.nanoTime

      val duration = endTime - startTime
      println(s"Iteration $idx: $duration ms")

      perfLog.println(duration)
      perfLog.flush()
    }

    perfLog.close()

    spark.stop()
  }
}
