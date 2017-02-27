import configuration.CaseGenerator
import logging.FileLog
import tests.SQLTest

/**
  * Created by petrkubat on 26/02/2017.
  */
object Main {
  val tests = List(new SQLTest(200000))

  def main(args: Array[String]): Unit = {
    val log = new FileLog("/opt/mount/log.txt")
    val runner = new AdaptiveTestRunner(2, log)
    runner.runTests(tests, CaseGenerator)
    log.close
  }
}
