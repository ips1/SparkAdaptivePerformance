import configuration.{AdaptiveConfiguration, CaseProvider}
import logging.Log
import tests.{AdaptiveTest, SparkInitializer}

/**
  * Created by petrkubat on 26/02/2017.
  */
class AdaptiveTestRunner(val sparkInitializer: SparkInitializer, testRepeatCount: Int, val log: Log) {
  private def runTest[T](test: AdaptiveTest[T], configuration: AdaptiveConfiguration): Unit = {
    val name = configuration.getLongName(test.name)

    log.log(s"\n$name:")
    val startTime = System.nanoTime
    val result = test.runTest(sparkInitializer, configuration)
    val duration = System.nanoTime - startTime
    log.log(s"Result: $result\nDuration: $duration")
  }

  def runTests[T](tests: Iterable[AdaptiveTest[T]], caseProvider: CaseProvider) = tests
    .foreach(test =>
      caseProvider.getCases.foreach(testCase =>
        (1 to testRepeatCount).foreach(it =>
          runTest(test, testCase))))
}
