package command

class EmailJob extends Job {
  protected var receiver: Option[Email] = None

  def setEmail(email: Email): Unit = receiver = Some(email)

  override def run(): Unit = receiver match {
    case Some(email) => email.sendEmail()
    case None => None
  }
}