/**
  * Created by petrkubat on 26/02/2017.
  */
object AdaptiveTestRunner {
  val testRepeatCount = 20

  def runTests(tests: Iterable[AdaptiveTest], caseProvider: CaseProvider) = tests
    .foreach(test =>
      caseProvider.getCases().foreach(testCase =>
        (1 to testRepeatCount).foreach(it =>
          test.runTest(testCase))))
}
