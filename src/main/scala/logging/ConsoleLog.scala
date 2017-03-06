package logging

/**
  * Created by pk250187 on 3/7/17.
  */
class ConsoleLog extends Log {
  override def log(text: String): Unit = println(text)

  override def close(): Unit = Unit
}
