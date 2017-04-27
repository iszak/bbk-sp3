package chain

case class DocFileHandler(s: String) extends Handler {
  override def process(file: File): Unit = file.fileType match {
    case "doc" => println(s"Processing file at ${file.fileName} path ${file.filePath} with ${getHandlerName()} ")
    case _ => nextHandler match {
      case Some(handler) => handler.process(file)
      case _ => None
    }
  }

  override def getHandlerName(): String = s
}
