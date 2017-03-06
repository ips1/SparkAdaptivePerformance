package tests

import configuration.AdaptiveConfiguration
import org.apache.spark.sql.SparkSession

/**
  * Created by pk250187 on 3/6/17.
  */

class SparkLocalInitializer extends SparkInitializer {
  def initSession(adaptiveConfiguration: AdaptiveConfiguration, name: String = "tests.AdaptiveTest") : SparkSession = SparkSession
    .builder
    .master("local[8]")
    .appName(adaptiveConfiguration.getLongName(name))
    .config("spark.sql.adaptive.enabled", adaptiveConfiguration.adaptiveEnabled)
    .config("spark.sql.adaptive.shuffle.targetPostShuffleInputSize", adaptiveConfiguration.targetPostShuffleInputSize)
    .config("spark.sql.adaptive.minNumPostShufflePartitions", adaptiveConfiguration.minNumPostShufflePartitions)
    .getOrCreate()
}