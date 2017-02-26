import org.apache.spark.sql.SparkSession

/**
  * Created by petrkubat on 19/02/2017.
  */
object SparkInitializer {
  def initSession(adaptiveConfiguration: AdaptiveConfiguration) : SparkSession = SparkSession
      .builder
      .appName(adaptiveConfiguration.getName)
      .config("spark.sql.adaptive.enabled", adaptiveConfiguration.adaptiveEnabled)
      .config("spark.sql.adaptive.shuffle.targetPostShuffleInputSize", adaptiveConfiguration.targetPostShuffleInputSize)
      .config("spark.sql.adaptive.minNumPostShufflePartitions", adaptiveConfiguration.minNumPostShufflePartitions)
      .getOrCreate()
}
