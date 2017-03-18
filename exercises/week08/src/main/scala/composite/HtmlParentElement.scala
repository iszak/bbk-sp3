package composite

import scala.collection.JavaConverters._

case class HtmlParentElement(s: String) extends HtmlTag(s) {
  override def generateHtml: Unit = {
    println(startTag)
    children.asScala.foreach(child => child.generateHtml)
    println(endTag)
  }
}
