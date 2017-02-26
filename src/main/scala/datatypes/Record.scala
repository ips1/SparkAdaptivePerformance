package datatypes

/**
  * Created by petrkubat on 26/02/2017.
  */
case class Record(val recordType: Int, val size: Int, val data: Long, val users: Int)

object Record {
  val MaxRecordType = 20
  val MaxSize = 10000
  val MaxData = Long.MaxValue
  val MaxUsers = 1000
}
