package logging

import java.io.{File, PrintWriter}

/**
  * Created by petrkubat on 27/02/2017.
  */
class FileLog(val fileName: String) extends Log {
  val writer = new PrintWriter(new File(fileName))

  override def log(text: String): Unit = {
    writer.println(text)
    writer.flush()
  }

  override def close = writer.close()
}
