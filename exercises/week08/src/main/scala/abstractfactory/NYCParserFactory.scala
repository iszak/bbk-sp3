package abstractfactory

class NYCParserFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String): XMLParser = parserType.toUpperCase match {
    case "NYCORDER" => new NYCOrderXMLParser
    case _ => throw new IllegalArgumentException(s"Type $parserType is unsupported")
  }
}
