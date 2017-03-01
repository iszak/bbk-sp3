package strategy

case class CapTextFormatter() extends TextFormatter {
  override def format(text: String): Unit = println("[CapTextFormatter]: " + text.toUpperCase)
}
