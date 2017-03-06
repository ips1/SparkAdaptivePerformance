package logging

/**
  * Created by pk250187 on 3/6/17.
  */
class DevNullLog extends Log {
  override def log(text: String): Unit = Unit
  override def close(): Unit = Unit
}
