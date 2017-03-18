package composite

import java.util.List
import java.util.ArrayList

abstract class HtmlTag(tagName: String) {
  protected val children:List[HtmlTag] = new ArrayList[HtmlTag]()

  protected var startTag:String = _
  protected var endTag:String = _
  protected var tagBody:String = _

  def getTagName: String = tagName

  def setStartTag(tag: String): Unit = startTag = tag

  def setEndTag(tag: String): Unit = endTag = tag

  def setTagBody(body: String) = tagBody = body

  def addChildTag(htmlTag: HtmlTag) = children.add(htmlTag)

  def removeChildTag(htmlTag: HtmlTag) = children.remove(htmlTag)

  def getChildren: List[HtmlTag] = children

  def generateHtml
}