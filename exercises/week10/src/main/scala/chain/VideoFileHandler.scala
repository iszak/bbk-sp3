package chain

case class VideoFileHandler(s: String) extends Handler {
  override def process(file: File): Unit = file.fileType match {
    case "video" => println(s"Process and saving video file... by ${getHandlerName()}")
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
