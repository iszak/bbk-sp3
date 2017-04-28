package memento

case class Originator(
  var x: Double,
  var y: Double,
  var careTaker: CareTaker
) {

  private var lastUndoSavepoint: String = _

  createSavepoint("INITIAL")

  def createSavepoint(savepointName: String): Unit = {
    println(s"Saving state...$savepointName")
    careTaker.saveMemento(Memento(x, y), savepointName)
    lastUndoSavepoint = savepointName
  }

  def undo(): Unit = setOriginatorState(lastUndoSavepoint)

  def undo(savepointName: String): Unit = setOriginatorState(savepointName)

  def undoAll(): Unit = {
    println("Clearing all save points...")
    setOriginatorState("INITIAL")
    careTaker.clearSavepoints()
    lastUndoSavepoint = null
  }

  private def setOriginatorState(savepointName: String): Unit = {
    println(s"Undo at ...$savepointName")
    val memento = careTaker.getMemento(savepointName)

    x = memento.x
    y = memento.y
  }

  override def toString(): String = "X: " + x + ", Y: " + y
}
