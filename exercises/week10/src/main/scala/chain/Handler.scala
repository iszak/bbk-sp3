package chain

trait Handler {
	protected var nextHandler: Option[Handler] = None

	def setHandler(handler: Handler): Unit = nextHandler = Some(handler)
	def process(file: File)
	def getHandlerName(): String
}
    