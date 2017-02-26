/**
  * Created by petrkubat on 26/02/2017.
  */
class ConfigurationGenerator[T <% Ordered[T]](val minValue: T,
                                val maxValue: T,
                                val iteration: T => T) {
  def getConfigurations: Iterable[T] = Stream.iterate(minValue) { iteration(_) }.takeWhile { _ < maxValue }
}
