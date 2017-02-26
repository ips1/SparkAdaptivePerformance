package datatypes

import scala.util.Random

/**
  * Created by petrkubat on 26/02/2017.
  */
object RandomExtensions {
  implicit def richRand(rand: Random) = new {
    def nextRecord = new Record(rand.nextInt(Record.MaxRecordType),
                                rand.nextInt(Record.MaxSize),
                                rand.nextLong(),
                                rand.nextInt(Record.MaxUsers))
  }
}
