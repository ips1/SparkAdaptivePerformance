import configuration.CaseGenerator
import logging.{ConsoleLog, DevNullLog, FileLog}
import tests.{SQLTest, SparkLocalInitializer}

/**
  * Created by petrkubat on 26/02/2017.
  */
object Main {
  val tests = List(new SQLTest(600000))

  def main(args: Array[String]): Unit = {
    val log = new ConsoleLog()//new FileLog("/opt/mount/log.txt")
    val runner = new AdaptiveTestRunner(new SparkLocalInitializer(), 2, log)
    runner.runTests(tests, CaseGenerator)
    log.close
  }
}
