package tests

import configuration.AdaptiveConfiguration

/**
  * Created by petrkubat on 26/02/2017.
  */
trait AdaptiveTest[T] {
  def runTest(configuration: AdaptiveConfiguration): T
  def name = this.getClass.getName
  def initSpark(configuration: AdaptiveConfiguration) = SparkInitializer.initSession(configuration, name)
}
