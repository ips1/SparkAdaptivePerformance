/**
  * Created by petrkubat on 26/02/2017.
  */
trait AdaptiveTest {
  def runTest(configuration: AdaptiveConfiguration)
  def initSpark(configuration: AdaptiveConfiguration) = SparkInitializer.initSession(configuration, this.getClass.getName)
}
