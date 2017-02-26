/**
  * Created by petrkubat on 26/02/2017.
  */
object CaseGenerator extends CaseProvider {
  val targetSizeGenerator = new ConfigurationGenerator[Int](1 * 1024 * 1024,
                                                            512 * 1024 * 1024,
                                                            (x) => 2 * x)
  val minPartitionsGenerator = new ConfigurationGenerator[Int](-1, 256, (x) => if (x < 0) 1 else 2 * x)

  def getCases() : Iterable[AdaptiveConfiguration] =
    for (targetSize <- targetSizeGenerator.getConfigurations;
         minPartitions <- minPartitionsGenerator.getConfigurations)
      yield new AdaptiveConfiguration(true, targetSize, minPartitions)
}
