package tests

import configuration.AdaptiveConfiguration
import org.apache.spark.sql.SparkSession

/**
  * Created by petrkubat on 19/02/2017.
  */
class SparkRemoteInitializer extends SparkInitializer {
  def initSession(adaptiveConfiguration: AdaptiveConfiguration, name: String = "tests.AdaptiveTest") : SparkSession = SparkSession
      .builder
      .appName(adaptiveConfiguration.getLongName(name))
      .config("spark.sql.adaptive.enabled", adaptiveConfiguration.adaptiveEnabled)
      .config("spark.sql.adaptive.shuffle.targetPostShuffleInputSize", adaptiveConfiguration.targetPostShuffleInputSize)
      .config("spark.sql.adaptive.minNumPostShufflePartitions", adaptiveConfiguration.minNumPostShufflePartitions)
      .getOrCreate()
}
