package command

class SmsJob extends Job {
  protected var receiver:Option[Sms] = None

  def setSms(sms: Sms): Unit = receiver = Some(sms)

  override def run(): Unit = receiver match {
    case Some(sms) => sms.sendSms
    case None => None
  }
}