package observer

class SMSUsers(s: Subject, msg: String) extends Observer {
  def update(desc: String): Unit = {
    println(msg + ": " + desc)
  }

  def subscribe(): Unit = s.subscribeObserver(this)

  def unSubscribe(): Unit = s.unSubscribeObserver(this)
}
