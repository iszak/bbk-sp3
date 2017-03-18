package composite

case class HtmlElement(s: String) extends HtmlTag(s) {
  override def generateHtml: Unit = println(startTag + tagBody + endTag)
}
