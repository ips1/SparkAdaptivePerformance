package logging

/**
  * Created by petrkubat on 27/02/2017.
  */
trait Log {
  def log(text: String)
  def close()
}
