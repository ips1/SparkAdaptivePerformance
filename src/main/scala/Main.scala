/**
  * Created by petrkubat on 26/02/2017.
  */
object Main {
  val tests = List(new SQLTest(10000))

  def main(args: Array[String]): Unit = {
    AdaptiveTestRunner.runTests(tests, CaseGenerator)
  }
}
