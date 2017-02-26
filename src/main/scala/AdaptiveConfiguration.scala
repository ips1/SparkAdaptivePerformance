/**
  * Created by petrkubat on 26/02/2017.
  */
class AdaptiveConfiguration(val adaptiveEnabled: Boolean,
                            val targetPostShuffleInputSize: Int,
                            val minNumPostShufflePartitions: Int) {
  def getLongName(name: String): String =
    s"$name enabled:$adaptiveEnabled " +
    s"targetSize: $targetPostShuffleInputSize " +
    s"minPartitions: $minNumPostShufflePartitions"
}