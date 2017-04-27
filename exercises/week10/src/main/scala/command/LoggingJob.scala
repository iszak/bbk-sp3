package command

class LoggingJob extends Job {
  protected var receiver:Option[Logging] = None

  def setLogging(logging: Logging): Unit = receiver = Some(logging)

  override def run(): Unit = receiver match {
    case Some(logging) => logging.log
    case None => None
  }
}