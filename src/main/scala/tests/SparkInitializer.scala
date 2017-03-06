package tests

import configuration.AdaptiveConfiguration
import org.apache.spark.sql.SparkSession

/**
  * Created by pk250187 on 3/6/17.
  */
trait SparkInitializer {
  def initSession(adaptiveConfiguration: AdaptiveConfiguration, name: String = "tests.AdaptiveTest") : SparkSession
}
