package tests

import datatypes.Record
import configuration.AdaptiveConfiguration

import scala.util.Random

/**
  * Created by petrkubat on 26/02/2017.
  */
class SQLTest(val dataSize: Int) extends AdaptiveTest[Int] {
  private def generateData(count: Int) : Seq[Record] = {
    val rand = new Random(42)

    val data = new Array[Record](count)
    for (i <- 0 until count) {
      import datatypes.RandomExtensions._
      data(i) = rand.nextRecord
    }

    return data
  }

  override def runTest(initializer: SparkInitializer, configuration: AdaptiveConfiguration): Int = {
    val spark = initSpark(initializer, configuration)
    val sqlContext = spark.sqlContext

    import spark.implicits._

    val data1 = sqlContext.createDataset(generateData(dataSize))
    //val data2 = sqlContext.createDataset(generateData(dataSize))

    val result = data1
      .filter(_.recordType > 5)
      .groupByKey(_.size)
      .reduceGroups((left, right) => new Record(left.recordType, left.size, left.data, left.users + right.users))
      .filter(_._2.users > 200)
      .count()

    spark.stop()

    return result.toInt
  }
}
