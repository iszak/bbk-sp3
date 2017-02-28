package observer

import scala.collection.mutable.ListBuffer

class CommentaryObject(var subscribers: ListBuffer[Observer], val title: String)
  extends Subject
    with Commentary {
  private var currentDesc = ""

  def subscribeObserver(observer: Observer): Unit = subscribers += observer

  def unSubscribeObserver(observer: Observer): Unit = subscribers -= observer

  def notifyObservers(): Unit = subscribers.foreach(_.update(subjectDetails))

  def subjectDetails: String = currentDesc

  def setDesc(desc: String): Unit = {
    currentDesc = desc
    notifyObservers()
  }
}
