package command

class FileIOJob extends Job {
  protected var receiver: Option[FileIO] = None

  def setFileIO(fileIO: FileIO): Unit = receiver = Some(fileIO)

  override def run(): Unit = receiver match {
    case Some(file) => file.execute()
    case None => None
  }
}