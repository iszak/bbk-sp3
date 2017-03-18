package abstractfactory

class LondonParserFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): XMLParser = parserType.toUpperCase match {
    case "LONDONFEEDBACK" => new LondonFeedbackXMLParser
    case _ => throw new IllegalArgumentException(s"Type $parserType is unsupported")
  }
}
