package chain

case class AudioFileHandler(s: String) extends Handler {
  override def process(file: File): Unit = file.fileType match {
    case "audio" => println(s"Process and saving audio file... by ${getHandlerName()}")
    case _ => nextHandler match {
      case Some(handler) => {
        println(s"${getHandlerName()} forwards request to ${handler.getHandlerName()}")
        handler.process(file)
      }
      case _ => println("File not supported")
    }
  }

  override def getHandlerName(): String = s
}
