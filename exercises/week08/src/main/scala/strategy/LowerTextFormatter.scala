package strategy

case class LowerTextFormatter() extends TextFormatter {
  override def format(text: String): Unit = println("[LowerTextFormatter]: " + text.toLowerCase)
}
