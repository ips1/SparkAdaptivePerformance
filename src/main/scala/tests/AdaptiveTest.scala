package tests

import configuration.AdaptiveConfiguration

/**
  * Created by petrkubat on 26/02/2017.
  */
trait AdaptiveTest[T] {
  def runTest(initializer: SparkInitializer, configuration: AdaptiveConfiguration): T
  def name = this.getClass.getName
  def initSpark(initializer: SparkInitializer, configuration: AdaptiveConfiguration) = initializer.initSession(configuration, name)
}
