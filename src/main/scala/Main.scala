/**
  * Created by petrkubat on 26/02/2017.
  */
object Main {
  val tests = List(GroupByTest)

  def main(args: Array[String]): Unit = {
    AdaptiveTestRunner.runTests(tests, CaseGenerator)
  }
}
